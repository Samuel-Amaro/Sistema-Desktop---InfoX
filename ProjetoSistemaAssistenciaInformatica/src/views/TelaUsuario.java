package views;

import dao.CriptografaSenha;
import java.sql.*;
import dao.ModuloConexao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    /*
       * Tela em que o usuario o admin vai poder manipualr o CRUD de  usuarios, inserir novo usuario,cadastrar, atualizar, deletar    
     */
    //variaveis essenciais para usar, para manipulação do banco e QUERYs
    Connection conexao;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String loginAntigo = null;

    //metodo construtor da classe da tela usuario
    public TelaUsuario() {
        initComponents();
        //inseri um texto automatico no componente
        txtBuscaUsuario.setText("Usuario que Procura");
        //ja istancia uma conexão com SGBD autoamtico
        conexao = ModuloConexao.conector();
    }

    //metodo publico, que vai inserir um novo funcionario da loja no banco de dados, somente o admin pode fazer isso
    private void insertUser() {
        //consulta sql
        String sql = "INSERT INTO tbl_usuario(nome,telefone,login,senha,perfil) VALUES(?,?,?,?,?);";
        try {
            //setando os dados dos componetes na consulta SQL
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtTelefone.getText());
            ps.setString(3, txtLogin.getText());
            //antes de inserir a senha pura, so com o seu proprio texto vou, formatar ela e criptografar
            String senhaCriptografada = CriptografaSenha.criptografaSenhaMD5(txtSenha.getText());
            //passo a senha criptografada para mostrar no banco de dados
            ps.setString(4, senhaCriptografada);
            ps.setString(5, cbPerfil.getSelectedItem().toString());
            //validação dos campos obrigatorios, que tem que ser prenchidos, se não tiver prenchido, não e cadastrado,
            //no caso e login e senha são obrigatorios, para pelo menos poder se logar
            if (txtLogin.getText().isEmpty() && txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                //executando consulta
                ps.executeUpdate();
                //fechando consulta
                ps.close();
                //limpando os dados nas caixas de texto(como uma cache que fica salvo)
                //limpa os componetens
                txtNome.setText(null);
                txtTelefone.setText(null);
                txtLogin.setText(null);
                txtSenha.setText(null);
                cbPerfil.setSelectedItem("Selecione");
                JOptionPane.showMessageDialog(null, "Inserido Com Sucesso!", "Certo!", JOptionPane.OK_OPTION);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao Cadastrar Novo Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo que vai buscar um usuario, no banco de dados, e mostrar os dados dele no formulario, se ele existir
    private void buscaUser() {
        //consulta sql
        String sql = "SELECT * FROM tbl_usuario WHERE login = ?;";
        //setando dados na consulta e executando
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtBuscaUsuario.getText());
            rs = ps.executeQuery();
            //se o usuario existir, mostrar os dados dele, rs = ps.executeQuery(); -> retorna o numero de linhas adiconados ao banco de dados,
            //ou numero de linhas que ele trouxe do banco de dados, uso o next porque no momento não ah necessidade de usar o retorno, o next
            // e so para confirma se adicionou uma linha no banco ou se trouxe uma linha, para usar para mais de 1 linha usar uma estrutura de repetição para
            //controlar o numero de linhas, e ir atualizando, e acompanhando as linhas
            if (rs.next()) {
                //mostrando os dados do usuario
                txtNome.setText(rs.getString(2));
                txtTelefone.setText(rs.getString(3));
                txtLogin.setText(rs.getString(4));
                txtSenha.setText("Por Motivo De Segurança Não Mostraremos a senha");
                cbPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado!");
                //limpa os componetens
                txtNome.setText(null);
                txtTelefone.setText(null);
                txtLogin.setText(null);
                txtSenha.setText(null);
                cbPerfil.setSelectedItem("Selecione");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Usuario" + e);
        }

    }

    //antes de atualizar um usuario, tem que buscar, ele no banco de dados e verficar se ele existe.
    //se ele existir vai popular os componetes com os dados, dai ele pode modificar e depois mandar atualizar
    //metodo que atualiza o cadastro de um usuario, altera dados de um usuario
    private void updateUser() {
        String sql = "UPDATE tbl_usuario SET nome = ?,telefone = ?,login = ?,perfil = ? WHERE login = ?;";
        //setando dados na consulta, e tratando consulta
        try {
            ps = conexao.prepareStatement(sql);
            //setando os dados na consulta
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtTelefone.getText());
            ps.setString(3, txtLogin.getText());
            ps.setString(4, cbPerfil.getSelectedItem().toString());
            //verifica se os campos obrigatorios foram prenchidos, no caso com vou saber que o sistema vai atualizar ?
            //vai estar prenchido na caixa de texto de procurar um usuario, verifico se ela esta prenhida para poder atualizar
            if (txtBuscaUsuario.getText().equals(" ") || txtBuscaUsuario.getText().equals("Usuario que Procura")) {
                JOptionPane.showMessageDialog(null, "Quem Você Deseja Atualizar ?");
            } else {
                //setando o usario que vai ser atualizado
                ps.setString(5, txtBuscaUsuario.getText());
                //validando os campos obrigatorios vendo se foi prenchido, no caso so login e obrigatorio, ao atualizar
                if (txtLogin.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Onde esta os dados para alterar ?", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    //se tiver prenchido o campo obrigatorio login, atualiza
                    int re = ps.executeUpdate();
                    if (re > 0) {
                        JOptionPane.showMessageDialog(null, "Alteração Feita Com Sucesso!");
                        //limpa os componetens
                        txtNome.setText(null);
                        txtTelefone.setText(null);
                        txtLogin.setText(null);
                        txtSenha.setText(null);
                        cbPerfil.setSelectedItem("Selecione");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar usuario" + e);
        }

    }

    //metodo de excluir um usuario 
    private void deleteUser() {
        //estrutra que recebe a confirmação de que se deseja excluir o usuario mesmo
        int confirma = JOptionPane.showConfirmDialog(null, "Realmente Deseja Remover Este Usuario(A)", "Atenção", JOptionPane.YES_NO_OPTION);
        //confirmou que realmente dejesa remover
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //excluindo o usuario
            String sql = "DELETE FROM tbl_usuario WHERE login = ?;";
            try {
                ps = conexao.prepareStatement(sql);
                //setando dados na consulta
                if (txtDeleteUser.getText().equals(" ") && txtDeleteUser.getText().equals("Usuario que deseja Excluir")) {
                    JOptionPane.showMessageDialog(null, "Cade o usario para excluir");
                } else {
                    ps.setString(1, txtDeleteUser.getText());
                    int op = ps.executeUpdate();
                    if (op > 0) {
                        JOptionPane.showMessageDialog(null, "Exclusão Feita Com Sucesso!");
                        //limpa os componetens
                        txtNome.setText(null);
                        txtTelefone.setText(null);
                        txtLogin.setText(null);
                        txtSenha.setText(null);
                        cbPerfil.setSelectedItem("Selecione");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir!");
                        //limpa os componetens
                        txtNome.setText(null);
                        txtTelefone.setText(null);
                        txtLogin.setText(null);
                        txtSenha.setText(null);
                        cbPerfil.setSelectedItem("Selecione");
                    }

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFone = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblFone = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        cbPerfil = new javax.swing.JComboBox<>();
        btnUserBuscar = new javax.swing.JButton();
        btnUserCreate = new javax.swing.JButton();
        btnUserAtualizar = new javax.swing.JButton();
        btnUserDeletar = new javax.swing.JButton();
        lblBuscaUsuario = new javax.swing.JLabel();
        txtBuscaUsuario = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        lblAvizo = new javax.swing.JLabel();
        lblDeleteUser = new javax.swing.JLabel();
        txtDeleteUser = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblNome.setText("Nome ");

        lblFone.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblFone.setText("Telefone ");

        lblLogin.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblLogin.setText("Login *");

        lblSenha.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblSenha.setText("Senha *");

        lblPerfil.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblPerfil.setText("Perfil ");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "admin", "user" }));

        btnUserBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/buscar-user-icone.png"))); // NOI18N
        btnUserBuscar.setToolTipText("Buscar Usuário");
        btnUserBuscar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnUserBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserBuscarActionPerformed(evt);
            }
        });

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/add-user-icone.png"))); // NOI18N
        btnUserCreate.setToolTipText("Adicionar Novo Usuário");
        btnUserCreate.setPreferredSize(new java.awt.Dimension(64, 64));
        btnUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserCreateActionPerformed(evt);
            }
        });

        btnUserAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/update-user.png"))); // NOI18N
        btnUserAtualizar.setToolTipText("Atualizar Usuário");
        btnUserAtualizar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnUserAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAtualizarActionPerformed(evt);
            }
        });

        btnUserDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/delete-user-icone.png"))); // NOI18N
        btnUserDeletar.setToolTipText("Deletar Usuário");
        btnUserDeletar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnUserDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeletarActionPerformed(evt);
            }
        });

        lblBuscaUsuario.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblBuscaUsuario.setText("Usuário");

        txtBuscaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaUsuarioMouseClicked(evt);
            }
        });
        txtBuscaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaUsuarioActionPerformed(evt);
            }
        });

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        lblAvizo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblAvizo.setText("* Campos Obrigatórios Para Adicionar Novos Usuários");

        lblDeleteUser.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblDeleteUser.setText("Usuário");

        txtDeleteUser.setText("Usuario que deseja Excluir");
        txtDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDeleteUserMouseClicked(evt);
            }
        });
        txtDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(lblAvizo)
                .addGap(282, 282, 282))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFone)
                        .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBuscaUsuario)
                    .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDeleteUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(btnUserBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnUserAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(btnUserDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtLogin)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeleteUser)))
                    .addComponent(txtNome))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblAvizo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin)
                    .addComponent(lblFone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerfil)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaUsuario)
                    .addComponent(txtBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeleteUser)
                    .addComponent(txtDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        setBounds(0, 0, 859, 562);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnUserBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserBuscarActionPerformed
        //ao clicar nesse botão vai buscar um usuario e mostrar os dados dele no formulario
        if (txtBuscaUsuario.getText().equals("Usuario que Procura")) {
            JOptionPane.showMessageDialog(null, "Cade o Usuario ?");
        } else {
            buscaUser();
        }
    }//GEN-LAST:event_btnUserBuscarActionPerformed

    private void btnUserCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserCreateActionPerformed
        //ao clicar no botão de criar um novo usuario vai, adiconar um novo usuario no DB
        insertUser();
    }//GEN-LAST:event_btnUserCreateActionPerformed

    private void btnUserAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAtualizarActionPerformed
        //altera cadastro de um usuario
        updateUser();
    }//GEN-LAST:event_btnUserAtualizarActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtBuscaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaUsuarioActionPerformed
        //ao clicar na caixa some  o texto
        txtBuscaUsuario.setText(null);
    }//GEN-LAST:event_txtBuscaUsuarioActionPerformed

    private void txtBuscaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaUsuarioMouseClicked
        //ao clicar na caixa some  o texto
        txtBuscaUsuario.setText(null);
    }//GEN-LAST:event_txtBuscaUsuarioMouseClicked

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void txtDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDeleteUserMouseClicked
        txtDeleteUser.setText(null);
    }//GEN-LAST:event_txtDeleteUserMouseClicked

    private void btnUserDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeletarActionPerformed
        deleteUser();
    }//GEN-LAST:event_btnUserDeletarActionPerformed

    private void txtDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeleteUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUserAtualizar;
    private javax.swing.JButton btnUserBuscar;
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserDeletar;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JLabel lblAvizo;
    private javax.swing.JLabel lblBuscaUsuario;
    private javax.swing.JLabel lblDeleteUser;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtBuscaUsuario;
    private javax.swing.JTextField txtDeleteUser;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}

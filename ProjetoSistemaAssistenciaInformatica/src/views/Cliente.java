package views;

import dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;
//importando a API(biblioteca) rs2xml.jar para ajudar, a fazer uma maneira de pesquisa avançada, para poder obter clientes, cadastrados de uma maneira mais rapida. e eficiente. utilizando uma API externa.
import net.proteanit.sql.DbUtils;



public class Cliente extends javax.swing.JInternalFrame {

    //variaveis essenciais
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;

    public Cliente() {
        initComponents();
        //ja inicia uma conexão automatica com o banco de dados
        conexao = ModuloConexao.conector();
    }

    //metodo que vai adicionar clientes
    private void adicionarClientes() {
        //consulta sql
        String sql = "INSERT INTO tbl_clientes(nome,referencia_endereco,cep,cidade,estado,telefone,email) VALUES                        (?,?,?,?,?,?,?);";
        try {
            //preparando consulta
            ps = conexao.prepareStatement(sql);
            //setando dados do cliente na consulta
            ps.setString(1, txtNomeCliente.getText());
            ps.setString(2, txtRefEnderecoCliente.getText());
            ps.setString(3, txtCepCliente.getText());
            ps.setString(4, txtCidadeCliente.getText());
            ps.setString(5, txtEstadoCliente.getText());
            ps.setString(6, txtTelefoneCliente.getText());
            ps.setString(7, txtEmailCliente.getText());
            //fazendo uma validação, vendo se os campos obrigatorios foram prenchidos
            if (txtNomeCliente.getText().isEmpty() || txtTelefoneCliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preecha os Campos Obrigatorios Por Favor", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                //executando consulta
                int adicionado = ps.executeUpdate();
                //consulta executada com sucesso retorna um numero(esse numero e o tanto de linhas inseridas, ou buscadas no                    banco de dados)
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente Inserido Com Sucesso", "Tudo Ok!", JOptionPane.YES_OPTION);
                    //e se deu tudo certo, limpa todos os campos prenchidos no frame
                    txtNomeCliente.setText(null);
                    txtRefEnderecoCliente.setText(null);
                    txtCepCliente.setText(null);
                    txtCidadeCliente.setText(null);
                    txtEstadoCliente.setText(null);
                    txtTelefoneCliente.setText(null);
                    txtEmailCliente.setText(null);
                } else {
                    //caso não insera nenhuma linha no banco, ou caso não tenha achado nada retorna 0
                    JOptionPane.showMessageDialog(null, "Erro ao Inserir Cliente", "Atenção!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Acessar Banco, Ao inserir Clientes " + e);
        }
    }
    
    
    //metodo de buscar clientes, pelo nome, aplicando um filtro de busca
    private void buscarClientes() {
        //consulta sql, que vai buscar um cliente, pelo nome, aplicado o filtro de nome, isso e ele so fornece a primeira letra         do nome e vou trazer todos os nomes baseado so na primeira letra forncecida. nomes parecidos. ao informado.
        String sql = "SELECT * FROM tbl_clientes WHERE nome LIKE ?;";  
        try {
             ps = conexao.prepareStatement(sql);
             //setando o filtro na consulta + o operador '%'(que significa, busca os caracteres informados antes dele que no                 caso e o enterroga, e o resto de caracteres não informados que vierem não importa).
             ps.setString(1,txtBuscaCliente.getText() + "%");
             //executando a consulta
             rs = ps.executeQuery();
             //usando um recurso, da bibliioteca externa rs2xml.jar para prencher a tabela na janela, que vai mostrar os                     clientes encontrados, com o filtro aplicado.
             tblMostraClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao Buscar Clientes No BD" + e);
        }
    }
    
    
    //metodo que vai prenche os campos do formulario, com apenas um clique do mouse encima de um cliente existente na tabela de     mostrar clientes
    public void setar_campos() {
     //a linha abaixo retorna a linha escolida na tabela com um clique   
     int linhaEscolhida = tblMostraClientes.getSelectedRow();
     //a linha abaixo pega a linha escolhida na tabela mostra cliente  e os respectivos dados nas colunas da tabela mostra           cliente, e seta esses dados no formulario.
     txtNomeCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,1).toString());
     txtRefEnderecoCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,2).toString());
     txtCepCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,3).toString());
     txtCidadeCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,4).toString());
     txtEstadoCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,5).toString());
     txtTelefoneCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,6).toString());
     txtEmailCliente.setText(tblMostraClientes.getModel().getValueAt(linhaEscolhida,7).toString());
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscaCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostraClientes = new javax.swing.JTable();
        lblNomeCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lblCepCliente = new javax.swing.JLabel();
        lblReferenciaEnderecoCliente = new javax.swing.JLabel();
        txtRefEnderecoCliente = new javax.swing.JTextField();
        lblCidadeCliente = new javax.swing.JLabel();
        txtCidadeCliente = new javax.swing.JTextField();
        lblEstadoCliente = new javax.swing.JLabel();
        txtEstadoCliente = new javax.swing.JTextField();
        lblTelefoneCliente = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        txtEmailCliente = new javax.swing.JTextField();
        btnInsertCliente = new javax.swing.JButton();
        btnAlterarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        txtCepCliente = new javax.swing.JFormattedTextField();
        txtTelefoneCliente = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        txtBuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/pesquisar-cliente.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(128, 128));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel2.setText("* Campos Obrigatorios a Serem Preenchidos");

        tblMostraClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMostraClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostraClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMostraClientes);

        lblNomeCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblNomeCliente.setText("Nome Cliente * ");

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        lblCepCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblCepCliente.setText("CEP");

        lblReferenciaEnderecoCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblReferenciaEnderecoCliente.setText("Referencia  Para  Encontrar  Endereço");

        lblCidadeCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblCidadeCliente.setText("Cidade");

        lblEstadoCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblEstadoCliente.setText("Estado");

        lblTelefoneCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblTelefoneCliente.setText("Telefone *");

        lblEmailCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblEmailCliente.setText("E-Mail");

        btnInsertCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/inserir-cli-btn.png"))); // NOI18N
        btnInsertCliente.setToolTipText("Cadastrar Um Novo Cliente");
        btnInsertCliente.setPreferredSize(new java.awt.Dimension(72, 72));
        btnInsertCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertClienteActionPerformed(evt);
            }
        });

        btnAlterarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/alterar-cliente-btn.png"))); // NOI18N
        btnAlterarCliente.setToolTipText("Alterar Dados Cliente");
        btnAlterarCliente.setPreferredSize(new java.awt.Dimension(64, 64));

        btnExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/delete-icon-btn.png"))); // NOI18N
        btnExcluirCliente.setToolTipText("Excluir Cadastro Cliente");
        btnExcluirCliente.setPreferredSize(new java.awt.Dimension(64, 64));

        try {
            txtCepCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefoneCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCepCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCepCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblReferenciaEnderecoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRefEnderecoCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCidadeCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblEstadoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstadoCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(btnAlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefoneCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmailCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmailCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCepCliente)
                    .addComponent(txtCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferenciaEnderecoCliente)
                    .addComponent(txtRefEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidadeCliente)
                    .addComponent(txtCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCliente)
                    .addComponent(txtEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefoneCliente)
                    .addComponent(lblEmailCliente)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        setBounds(0, 0, 859, 507);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void btnInsertClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertClienteActionPerformed
        //ao clicar no btn de adiconar, vai adicioar clientes.
        adicionarClientes();
    }//GEN-LAST:event_btnInsertClienteActionPerformed

    private void txtBuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyReleased
      //ao ir prenchendo o campo de busca, vai mostrando os clientes encontrados, de acordo com o nome informado no componete         de busca
      buscarClientes();
    }//GEN-LAST:event_txtBuscaClienteKeyReleased

    private void tblMostraClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostraClientesMouseClicked
        //ao clicar na tabela com o mouse encima de uma linha de um cliente existente,vou setar os dados da linha escolhida no          formulario
        setar_campos();
        
    }//GEN-LAST:event_tblMostraClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCliente;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnInsertCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCepCliente;
    private javax.swing.JLabel lblCidadeCliente;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblEstadoCliente;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblReferenciaEnderecoCliente;
    private javax.swing.JLabel lblTelefoneCliente;
    private javax.swing.JTable tblMostraClientes;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JFormattedTextField txtCepCliente;
    private javax.swing.JTextField txtCidadeCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEstadoCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtRefEnderecoCliente;
    private javax.swing.JFormattedTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}

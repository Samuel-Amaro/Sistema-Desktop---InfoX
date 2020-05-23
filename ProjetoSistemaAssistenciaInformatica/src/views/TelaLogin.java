package views;

/*
 * Tela De Login De Funcionarios
 */
//BIBLIOTECAS QUE VOU USAR
import dao.CriptografaSenha;
import java.sql.*;
import dao.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    //variavel que vai armazenar a conexão
    Connection conexao = null;
    //variavel que prepara a consuslta sql 
    PreparedStatement ps = null;
    //variavel que armazena o resulta de uma consulta sql
    ResultSet rs = null;

    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        System.out.println(conexao);
        //se minha conexão com o banco de dados, der certo ou errado vai ter um tipo de status com icones
        //para mostrar
        if (conexao != null) {
            lblStatusDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/dataBase-entrou.png")));
        } else {
            lblStatusDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/errorDatabase.png")));
        }
    }

    //metodo logar, que verifica se a pessoa que esta querendo acessar o sistema tem permissão
    public void logar() {
        //antes de buscar o usuario no banco de dados tenho que criptografar a senha dele para poder comparar e buscar o usuario
        //corretamente
        String senhaCrip = CriptografaSenha.criptografaSenhaMD5(new String(txtSenha.getPassword()));
        //variavel que armazena a istrução sql
        String sql = "SELECT * FROM tbl_usuario WHERE login = ? AND senha = ?;";
        try {
            //preparando a consulta ao banco de dados em função dos dados digitados pelo usuario nas
            //caixas de texto
            ps = conexao.prepareStatement(sql);
            //passando o login e senha informados pelo usuario nas caixas de texto, para a minha consulta
            //sql, buscar esse usuario e ver se ele tem permissão de acesso ao sistema
            ps.setString(1, txtUsuario.getText());
            ps.setString(2, senhaCrip);
            //executando a query
            rs = ps.executeQuery();
            //estrutura de decisão para verificar se o usario existe no sistema e tem acesso
            if (rs.next()) {
                //a linha abaixo obtem  o conteudo do campo perfil da tabela usuario
                String perfil = rs.getString(6);
                //System.out.println(perfil);
                // a estrutura abaixo faz o tratamentodo perfil do usuario
                if (perfil.equals("admin")) {
                    //abrir a tela principal
                    TelaPrincipal p = new TelaPrincipal();
                    p.setVisible(true);
                    //habilita os campos desabilitados
                    TelaPrincipal.menCadItemUsua.setEnabled(true);
                    TelaPrincipal.menRelatorio.setEnabled(true);
                    //mostra o usuario na tela principal
                    TelaPrincipal.lblUsuario.setText(rs.getString(6));
                    //ao um admin logar vai destacar e muda a cor do nome do admin, fica destacado, ao logar
                    TelaPrincipal.lblUsuario.setForeground(Color.blue);
                    //fecha a janela atual de login
                    this.dispose();
                    //fechando a conexão 
                    conexao.close();
                }else{
                    //abrir a tela principal
                    TelaPrincipal p = new TelaPrincipal();
                    p.setVisible(true);
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuarios e/ou senha Invalidos", "Você Não Tem Permissão De Acesso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao Buscar No Banco Dados", JOptionPane.WARNING_MESSAGE);
        }

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblStatusDb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X System - Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblSenha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSenha.setText("Senha");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-login.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setPreferredSize(new java.awt.Dimension(67, 57));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblStatusDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/dataBase-entrou.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatusDb, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusDb, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(458, 276));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //ao clicar no botão executa o metodo logar
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatusDb;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

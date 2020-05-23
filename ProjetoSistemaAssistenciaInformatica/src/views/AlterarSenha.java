package views;

import dao.CriptografaSenha;
import dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Tela onde o admin logado vai poder alterar sua senha, ou de outros usuario.
 */
public class AlterarSenha extends javax.swing.JInternalFrame {
     //variaveis necessarias    
    Connection conexao;
    PreparedStatement ps;
    
    public AlterarSenha() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
   

    //metodo que atualiza a senha de um usuario
    private void updatePassword() {
        //consulta sql
        String sql = "UPDATE tbl_usuario SET senha = ? WHERE login = ?;";
        try {
            ps = conexao.prepareStatement(sql);
            //setando senha criptografada na consulta
            String passCrip = CriptografaSenha.criptografaSenhaMD5(txtNovaSenha.getText());
            ps.setString(1, passCrip);
            //setando o usuario que vai ter a senha atualizada
            ps.setString(2, txtLogin.getText());
            int rt = ps.executeUpdate();
            if (rt > 0) {
                JOptionPane.showMessageDialog(null, "Senha Atualizada Com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Senha Não Foi Atualizada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Senha Não Foi Atualizada " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblSenhaAntiga = new javax.swing.JLabel();
        lblSenhaNova = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenhaAntiga = new javax.swing.JTextField();
        txtNovaSenha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Senha");
        setPreferredSize(new java.awt.Dimension(859, 562));

        lblLogin.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblLogin.setText("Login");

        lblSenhaAntiga.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblSenhaAntiga.setText("Senha-Antiga");

        lblSenhaNova.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblSenhaNova.setText("Senha-Nova");

        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-atualizar-btn.png"))); // NOI18N
        jButton1.setToolTipText("Atualizar Senha");
        jButton1.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSenhaAntiga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSenhaNova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin)
                            .addComponent(txtSenhaAntiga)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaAntiga)
                    .addComponent(txtSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaNova)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setBounds(0, 0, 451, 335);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtLogin.getText().isEmpty() && txtSenhaAntiga.getText().isEmpty() && txtNovaSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Cade os Dados Para Atualizar Senha"); 
        }else{
             updatePassword();
             txtLogin.setText(null);
             txtSenhaAntiga.setText(null);
             txtNovaSenha.setText(null);
             JOptionPane.showMessageDialog(null,"Encerraremos a sessão atual, para poder se logar com a nova senha");
             System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenhaAntiga;
    private javax.swing.JLabel lblSenhaNova;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNovaSenha;
    private javax.swing.JTextField txtSenhaAntiga;
    // End of variables declaration//GEN-END:variables
}

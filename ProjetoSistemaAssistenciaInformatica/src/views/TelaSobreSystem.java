package views;

/*
 * Tela interna do Jdesktop panel para so mostrar informações sobre o sistema.
*/
public class TelaSobreSystem extends javax.swing.JInternalFrame {

   
    public TelaSobreSystem() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Sobre o Sistema");
        setPreferredSize(new java.awt.Dimension(859, 562));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Objetivo Do Sistema: Sistema Tem Finalidade \n De Controlar e emitir Ordens de Serviços\n Baseado Em uma assistencia tecnica de \n perifericos e microcumputadores e notebooks.\n possui uma funcionalidade de ser administrado \n por um gestor(total uso)\n e usuarios(uso restrito), permite cadastrar \n cliente, e emitir relatorios dos serviços,\n controle financeiro.\n\nDesenvolvido: Samuel Amaro, este Perfil do GitHub.\n\nEste Sistema Esta sobre a Licença \nGPL(General Public License). Free Softaware. ");
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Sobre o X - SISTEMA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/logo-licenca-gnu.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logo Licença GPL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setBounds(0, 0, 859, 562);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

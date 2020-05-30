package views;

public class TelaOs extends javax.swing.JInternalFrame {

   
    public TelaOs() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlInformationOS = new javax.swing.JPanel();
        lblNumeroOS = new javax.swing.JLabel();
        lblDataOS = new javax.swing.JLabel();
        txtNumeroOs = new javax.swing.JTextField();
        txtDataOS = new javax.swing.JTextField();
        rdbOrcamento = new javax.swing.JRadioButton();
        rdbOrdemServicoOs = new javax.swing.JRadioButton();
        lblSituacaoEquipamento = new javax.swing.JLabel();
        cbbSitucaoEquipamento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("OS");

        pnlInformationOS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNumeroOS.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblNumeroOS.setText("Nº OS");

        lblDataOS.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblDataOS.setText("DATA");

        txtNumeroOs.setEditable(false);

        txtDataOS.setEditable(false);

        buttonGroup1.add(rdbOrcamento);
        rdbOrcamento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        rdbOrcamento.setText("Orçamento");

        buttonGroup1.add(rdbOrdemServicoOs);
        rdbOrdemServicoOs.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        rdbOrdemServicoOs.setText("Ordem Serviço");

        javax.swing.GroupLayout pnlInformationOSLayout = new javax.swing.GroupLayout(pnlInformationOS);
        pnlInformationOS.setLayout(pnlInformationOSLayout);
        pnlInformationOSLayout.setHorizontalGroup(
            pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationOSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNumeroOs, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumeroOS))
                    .addComponent(rdbOrcamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataOS)
                    .addComponent(lblDataOS)
                    .addComponent(rdbOrdemServicoOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInformationOSLayout.setVerticalGroup(
            pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroOS)
                    .addComponent(lblDataOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbOrcamento)
                    .addComponent(rdbOrdemServicoOs))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblSituacaoEquipamento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblSituacaoEquipamento.setText("Situação Equipamento:");

        cbbSitucaoEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrega OK", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado Pelo Cliente", "Na Bancada", "Retornou" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlInformationOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSituacaoEquipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSitucaoEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(587, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformationOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSituacaoEquipamento)
                    .addComponent(cbbSitucaoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );

        setBounds(0, 0, 904, 526);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSitucaoEquipamento;
    private javax.swing.JLabel lblDataOS;
    private javax.swing.JLabel lblNumeroOS;
    private javax.swing.JLabel lblSituacaoEquipamento;
    private javax.swing.JPanel pnlInformationOS;
    private javax.swing.JRadioButton rdbOrcamento;
    private javax.swing.JRadioButton rdbOrdemServicoOs;
    private javax.swing.JTextField txtDataOS;
    private javax.swing.JTextField txtNumeroOs;
    // End of variables declaration//GEN-END:variables
}

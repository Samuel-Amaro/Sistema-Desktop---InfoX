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
        pnlCliente = new javax.swing.JPanel();
        txtNomeCliente = new javax.swing.JTextField();
        lblIconePesquisar = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblEquipamento = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        lblProblemaEquipamento = new javax.swing.JLabel();
        txtProblemaEquipamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblTecnicoResponsavel = new javax.swing.JLabel();
        txtTecnicoResponsavel = new javax.swing.JTextField();
        lblValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnInserirOs = new javax.swing.JButton();
        btnBuscarOs = new javax.swing.JButton();
        btnAlterarOs = new javax.swing.JButton();
        btnDeletarOs = new javax.swing.JButton();
        btnImprimirOs = new javax.swing.JButton();

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

        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        lblIconePesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/pesquisar.png"))); // NOI18N
        lblIconePesquisar.setPreferredSize(new java.awt.Dimension(64, 64));

        lblIdCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblIdCliente.setText("* ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOME", "TELEFONE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIconePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIdCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente)))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIdCliente)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEquipamento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblEquipamento.setText("* EQUIPAMENTO");

        lblProblemaEquipamento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblProblemaEquipamento.setText("* PROBLEMA");

        jLabel1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel1.setText("DESCRIÇÃO SERVIÇO");

        lblTecnicoResponsavel.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblTecnicoResponsavel.setText("TÉCNICO RESPONSÁVEL");

        lblValorTotal.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblValorTotal.setText("VALOR TOTAL");

        btnInserirOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icon-inserir-os-btn.png"))); // NOI18N
        btnInserirOs.setToolTipText("Inserir Ordem Serviço");
        btnInserirOs.setPreferredSize(new java.awt.Dimension(64, 64));

        btnBuscarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icon-pesquisar-os-btn.png"))); // NOI18N
        btnBuscarOs.setToolTipText("Pesquisar Ordem Serviço");
        btnBuscarOs.setPreferredSize(new java.awt.Dimension(64, 64));

        btnAlterarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/change-os.png"))); // NOI18N
        btnAlterarOs.setToolTipText("Atualizar Ordem Serviço");
        btnAlterarOs.setPreferredSize(new java.awt.Dimension(64, 64));

        btnDeletarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/delete-document.png"))); // NOI18N
        btnDeletarOs.setToolTipText("Deletar Uma Ordem Serviço");
        btnDeletarOs.setPreferredSize(new java.awt.Dimension(64, 64));

        btnImprimirOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/print-os.png"))); // NOI18N
        btnImprimirOs.setToolTipText("Imprimir OS");
        btnImprimirOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirOs.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlInformationOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSituacaoEquipamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbSitucaoEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquipamento)
                            .addComponent(lblProblemaEquipamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquipamento)
                            .addComponent(txtProblemaEquipamento)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTecnicoResponsavel)
                            .addComponent(btnInserirOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(btnAlterarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeletarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(btnImprimirOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTecnicoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorTotal)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInformationOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSituacaoEquipamento)
                            .addComponent(cbbSitucaoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipamento)
                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProblemaEquipamento)
                    .addComponent(txtProblemaEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTecnicoResponsavel)
                    .addComponent(txtTecnicoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInserirOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletarOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimirOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setBounds(0, 0, 904, 526);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarOs;
    private javax.swing.JButton btnBuscarOs;
    private javax.swing.JButton btnDeletarOs;
    private javax.swing.JButton btnImprimirOs;
    private javax.swing.JButton btnInserirOs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSitucaoEquipamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDataOS;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblIconePesquisar;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblNumeroOS;
    private javax.swing.JLabel lblProblemaEquipamento;
    private javax.swing.JLabel lblSituacaoEquipamento;
    private javax.swing.JLabel lblTecnicoResponsavel;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlInformationOS;
    private javax.swing.JRadioButton rdbOrcamento;
    private javax.swing.JRadioButton rdbOrdemServicoOs;
    private javax.swing.JTextField txtDataOS;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumeroOs;
    private javax.swing.JTextField txtProblemaEquipamento;
    private javax.swing.JTextField txtTecnicoResponsavel;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}

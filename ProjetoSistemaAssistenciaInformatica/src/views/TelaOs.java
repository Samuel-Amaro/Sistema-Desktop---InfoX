package views;

//bibliotecas necessarias para desenvolver a tela OS
import dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; //vai usar a tabela para prenchimento de clientes automaticos



public class TelaOs extends javax.swing.JInternalFrame {

    //variaveis necessarias e essenciais
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    //variavel abaixo armazena o resutado do radioButon selecionado
    private String tipo;
  
    public TelaOs() {
        initComponents();
        //criando uma conexão com o banco de dados
        conexao = ModuloConexao.conector();
    }
   
    //metodo de pesquisar clientes na area de clientes, vai ser um metodo que vai possuir uma pesquisa avançada, usando uma biblioteca externa para            auxiliar na pesquisa
    private void pesquisar_cliente() {
    //consulta SQL avançada, que tem como filtragem o nome do cliente, onde so informando o nome do cliente, vai trazer nomes semelhentes ou parecidos ao       informado na consulta
    String sql = "SELECT id_cliente,nome,telefone FROM tbl_clientes WHERE nome like ?;";
        try {
            ps = conexao.prepareStatement(sql);        
            //setando dados na consulta
            ps.setString(1,txtNomeCliente.getText() + "%"); //o % e continuação da consulta SQL
            //executando consulta, se der certo a consulta tem que trazer os nomes de clientes semelhantes ou o proprio nome informado na consulta, se for             encontrado
            rs = ps.executeQuery();
            //apos trazer os nomes, tenho que jogalos na tabela la do cliente na tela para o usuario escolher o cliente certo
            //a linha abaixo so faz jogar os dados na tabela, mas tenho que fazer a tabela ter um evento que ao usuario ir digitando os nomes de cliente a             tabela ja ir trazendo resultados semelhantes ao nome informado
            tblResultadoPesquisaClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Consulta De Clientes Falhou!\n" + e);
        }
    }
    
    //metodo que vai setar campos, metodo que ao usuario escolher um cliente vou setar o campo id, para mostrar qual cliente foi selecionado
    private void setar_campos() {
       //retorna o indice da linha selecionada  na tabela 
       int setar = tblResultadoPesquisaClientes.getSelectedRow();
       //setando o id do cliente selecionado com o evento de clicar com o mouse
       txtIdCliente.setText(tblResultadoPesquisaClientes.getModel().getValueAt(setar,0).toString());
    }
    
    //metodo que vai cadastrar uma ordem serviço no banco de dados
    private void emitir_os() {
      String sql = "INSERT INTO tbl_os (equipamento,problema,descricao,tecnico,valor,id_cliente,tipo_os,situacao_equip) VALUES                                   (?,?,?,?,?,?,?,?);"; 
        try {
            ps = conexao.prepareStatement(sql);
            //setando dados na consulta
            ps.setString(1,txtEquipamento.getText());
            ps.setString(2,txtProblemaEquipamento.getText());
            ps.setString(3,txtDescricao.getText());
            ps.setString(4,txtTecnicoResponsavel.getText());
            ps.setString(5,txtValorTotal.getText());
            //tratando uma exceção na conversão de string para int
            try {
                ps.setInt(6,Integer.parseInt(txtIdCliente.getText()));
            } catch (NumberFormatException e) {
                     JOptionPane.showMessageDialog(null,"Prencha os campos obrigatorios");
            }
            ps.setString(7, tipo);
            ps.setString(8,cbbSitucaoEquipamento.getSelectedItem().toString());
            //fazendo validação dos campos obrigatorios vendo se foram preenchidos
            if ((txtEquipamento.getText().isEmpty()) || (txtProblemaEquipamento.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null,"Prencha os campos obrigatorios\n");
            } else {
                   int ad = ps.executeUpdate();
                   if(ad > 0) {
                      JOptionPane.showMessageDialog(null,"OS emitida Com Sucesso!");
                      //limpando os campos
                      txtNomeCliente.setText(null);
                      txtIdCliente.setText(null);
                      txtEquipamento.setText(null);
                      txtProblemaEquipamento.setText(null);
                      txtDescricao.setText(null);
                      txtTecnicoResponsavel.setText(null);
                      txtValorTotal.setText(null);
                   }else{
                       JOptionPane.showMessageDialog(null,"OS não foi emitida!");
                   }
            }
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"Inserção da Nova OS Falhou!\n" + e);
        }
    }
    
    //metodo para pesquisar uma ordem de serviço
    private void pesquisar_os() {
       //a linha abaixo cria uma entrada do tipo JoptionPane, onde eu recebo essa entrada o resultado da entrada para buscar a OS.
       //vai mostrar uma caixa de dialogo de pergunta, solicitando uma entrada do usuario.
       String numero_os = JOptionPane.showInputDialog("Numero Da OS");
       //consulta sql
       String sql = "SELECT * FROM tbl_os WHERE id_os = " + numero_os;
        try {
            //preparando consulta
            ps = conexao.prepareStatement(sql);
            //excutando consulta
            rs = ps.executeQuery();
            //vendo se existe a os
            if (rs.next()) {
                //significa que o banco de dados encontro um registro no banco de dados e retornou com uma linha do banco de dados
                //setando o resultado nas caixas para mostrar a OS encontrada
                txtNumeroOs.setText(String.valueOf(rs.getInt(1)));
                txtDataOS.setText(rs.getString(2));
                txtEquipamento.setText(rs.getString(3));
                txtProblemaEquipamento.setText(rs.getString(4));
                txtDescricao.setText(rs.getString(5));
                txtTecnicoResponsavel.setText(rs.getString(6));
                txtValorTotal.setText(rs.getString(7));
                txtIdCliente.setText(rs.getString(8));
                //setando os radiosButos, aqui na linha abaixo obtenho o tipo de OS
                String rbsTipoOs = rs.getString(9);
                //verifico que tipo de OS e, e seto no radioButon
                if (rbsTipoOs.equals("Orçamento")) {
                    //deixa o radio buton marcado
                    rdbOrcamento.setSelected(true);
                    //atualizo a varivel tipo para quando for atualizar ou excluir
                    tipo = "Orçamento";
                } else {
                    rdbOrdemServicoOs.setSelected(true);
                    tipo = "Ordem Serviço";
                }
                cbbSitucaoEquipamento.setSelectedItem(rs.getString(10));
                //a partir daqui tratando os erros mais comuns que podem surgir, aqui nas linhas abaixos esta desativando funções que podem interferir e                   mudar uma OS econtrada, isso e vai acabar mudando as informações da os encontrada, tipo as informações de uma OS existente, vão ser                        mudadas se essas funções permanecerem ativas enquanto estiver usando a parte de pesquisar OS, essa funções voltam a ser reativas quando                    for adicionar uma nova OS ou quando for Alterar
                //para poder evitar um erro comun, vou desabilitar o botão de adicionar uma OS nova
                btnInserirOs.setEnabled(false);
                //e outro e de mudar o cliente vinculado a os Encontrada na hora de pesquisar
                txtNomeCliente.setEnabled(false);
                //deixando a tabela invisel  para o usuario não poder mecher na tabela
                tblResultadoPesquisaClientes.setVisible(false);
            } else {
                   JOptionPane.showMessageDialog(null,"OS não Cadastrada");
            }
        }catch(SQLSyntaxErrorException t) {
              JOptionPane.showMessageDialog(null,"OS inválida!" + t);
        } 
        catch (SQLException e) {
                 JOptionPane.showMessageDialog(null,"Ocorreu uma falha ao encontrar a OS informada!\n" + e);
        }
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
        tblResultadoPesquisaClientes = new javax.swing.JTable();
        lblEquipamento = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        lblProblemaEquipamento = new javax.swing.JLabel();
        txtProblemaEquipamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
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
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

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
        rdbOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOrcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbOrdemServicoOs);
        rdbOrdemServicoOs.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        rdbOrdemServicoOs.setText("Ordem Serviço");
        rdbOrdemServicoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOrdemServicoOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInformationOSLayout = new javax.swing.GroupLayout(pnlInformationOS);
        pnlInformationOS.setLayout(pnlInformationOSLayout);
        pnlInformationOSLayout.setHorizontalGroup(
            pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationOSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationOSLayout.createSequentialGroup()
                        .addComponent(rdbOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbOrdemServicoOs))
                    .addGroup(pnlInformationOSLayout.createSequentialGroup()
                        .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeroOs, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumeroOS))
                        .addGroup(pnlInformationOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformationOSLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDataOS))
                            .addGroup(pnlInformationOSLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(lblDataOS)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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

        txtNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeClienteKeyReleased(evt);
            }
        });

        lblIconePesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/pesquisar.png"))); // NOI18N
        lblIconePesquisar.setPreferredSize(new java.awt.Dimension(64, 64));

        lblIdCliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lblIdCliente.setText("* ID");

        txtIdCliente.setEditable(false);

        tblResultadoPesquisaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResultadoPesquisaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadoPesquisaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultadoPesquisaClientes);

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
                        .addComponent(txtIdCliente)
                        .addGap(10, 10, 10)))
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

        txtValorTotal.setText("0");

        btnInserirOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icon-inserir-os-btn.png"))); // NOI18N
        btnInserirOs.setToolTipText("Inserir Ordem Serviço");
        btnInserirOs.setPreferredSize(new java.awt.Dimension(64, 64));
        btnInserirOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirOsActionPerformed(evt);
            }
        });

        btnBuscarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icon-pesquisar-os-btn.png"))); // NOI18N
        btnBuscarOs.setToolTipText("Pesquisar Ordem Serviço");
        btnBuscarOs.setPreferredSize(new java.awt.Dimension(64, 64));
        btnBuscarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOsActionPerformed(evt);
            }
        });

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
                        .addComponent(txtDescricao))
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
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClienteKeyReleased
        //chamando o metodo pesquisar cliente
        pesquisar_cliente();
    }//GEN-LAST:event_txtNomeClienteKeyReleased

    private void tblResultadoPesquisaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoPesquisaClientesMouseClicked
        //chamando o metodo setar
        setar_campos();
    }//GEN-LAST:event_tblResultadoPesquisaClientesMouseClicked

    private void rdbOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOrcamentoActionPerformed
        //atribuindo um texto a variavel tipo, se o radiobtn desse evento for selecionado
        tipo = "Orçamento";
    }//GEN-LAST:event_rdbOrcamentoActionPerformed

    private void rdbOrdemServicoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOrdemServicoOsActionPerformed
        //atribuindo um texto a variavel tipo, se o radiobtn desse evento for selecionado
        tipo = "Ordem Serviço";
    }//GEN-LAST:event_rdbOrdemServicoOsActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //evento que ao abrir o frame ou carregar o frame ou posso mandar ele fazer uma ação automatica por aqui
        //ao abrir o form marcar o radioButton orçamento
        rdbOrcamento.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnInserirOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirOsActionPerformed
        //ao clicar no botão vai emitir uma os
        emitir_os();
    }//GEN-LAST:event_btnInserirOsActionPerformed

    private void btnBuscarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOsActionPerformed
        //ao clicar no botão de pesquisar uma OS
        pesquisar_os();
    }//GEN-LAST:event_btnBuscarOsActionPerformed


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
    private javax.swing.JTable tblResultadoPesquisaClientes;
    private javax.swing.JTextField txtDataOS;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumeroOs;
    private javax.swing.JTextField txtProblemaEquipamento;
    private javax.swing.JTextField txtTecnicoResponsavel;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}

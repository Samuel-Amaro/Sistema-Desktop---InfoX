package views;

import dao.ModuloConexao;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/*
 * Tela Principal Do Sistema
 */
public class TelaPrincipal extends javax.swing.JFrame {

    //criando variaveis essenciais para usar 
    Connection conexao;

    public TelaPrincipal() {
        initComponents();
        //isntanciado uma nova conexão com o banco de dados
        conexao = ModuloConexao.conector();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblIcone = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menCadItemUsua = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menRelatorio = new javax.swing.JMenu();
        itemMenuRelatorioServicos = new javax.swing.JMenuItem();
        itemMenuRelatorioCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X - Sistema Para Controle De OS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        desktop.setPreferredSize(new java.awt.Dimension(859, 562));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 902, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/logo-Projeto-Java -redimensionado-certa.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        lblUsuario.setText("Usuario");

        lblData.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblData.setText("Data");

        jMenu1.setText("Cadastro");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-cliente-certo.png"))); // NOI18N
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-os.png"))); // NOI18N
        jMenuItem2.setText("Ordem Serviço");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menCadItemUsua.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menCadItemUsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-usuario.png"))); // NOI18N
        menCadItemUsua.setText("Usuarios");
        menCadItemUsua.setEnabled(false);
        menCadItemUsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadItemUsuaActionPerformed(evt);
            }
        });
        jMenu1.add(menCadItemUsua);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-senha-item.png"))); // NOI18N
        jMenuItem3.setText("Alterar Senha");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        menRelatorio.setText("Relatório");
        menRelatorio.setEnabled(false);

        itemMenuRelatorioServicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        itemMenuRelatorioServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-servico.png"))); // NOI18N
        itemMenuRelatorioServicos.setText("Serviços");
        itemMenuRelatorioServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuRelatorioServicosActionPerformed(evt);
            }
        });
        menRelatorio.add(itemMenuRelatorioServicos);

        itemMenuRelatorioCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        itemMenuRelatorioCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/relatorio-clientes.png"))); // NOI18N
        itemMenuRelatorioCliente.setText("Clientes");
        itemMenuRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuRelatorioClienteActionPerformed(evt);
            }
        });
        menRelatorio.add(itemMenuRelatorioCliente);

        jMenuBar1.add(menRelatorio);

        jMenu3.setText("Ajuda");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-ajuda.png"))); // NOI18N
        jMenuItem5.setText("Sobre");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Opções");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones_imagens/icone-sair.png"))); // NOI18N
        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcone)
                    .addComponent(lblUsuario)
                    .addComponent(lblData))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblUsuario)
                .addGap(47, 47, 47)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lblIcone)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1204, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //ao clicar no item cliente vai abrir o crud dos clientes
        Cliente c = new Cliente();
        c.setVisible(true);
        desktop.add(c);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //evento de quando a tela for ativida, vou mostrar a data atual do sistema, na label 
        Date data = new Date();
        //mostrando a data na label, e formatando a data antes de mostrar
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //ao clicar na opção sair, vai aparecer uma confirmação de que se realmente deseja sair.
        //exibe uma caixa de dialogo com sim ou não
        int resposta = JOptionPane.showConfirmDialog(null, "Realmente Deseja Sair ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.OK_OPTION);
        if (resposta == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //ao clicar na opção sobre, vai chamar a tela sobre, e mostrar as informações sobre o sistema e licença
        TelaSobreSystem s = new TelaSobreSystem();
        s.setVisible(true);
        desktop.add(s);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menCadItemUsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadItemUsuaActionPerformed
        //ao clicar no item usuario do menu cadastro, vai aparecer a tela CRUD de manipulação de usuarios,
        //onde so adminstrador tem permissão de manipular
        TelaUsuario t = new TelaUsuario();
        t.setVisible(true);
        //a tela CRUD de usuario vai ficar dentro do JdesktopPanel, isso e uma tela interna 
        desktop.add(t);
    }//GEN-LAST:event_menCadItemUsuaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //ao clicar no item alterar senha, vai alterar sua senha
        AlterarSenha s = new AlterarSenha();
        s.setVisible(true);
        desktop.add(s);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //ao clicar no item de os, abre a funcionalidades de uma OS
        TelaOs os = new TelaOs();
        os.setVisible(true);
        desktop.add(os);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemMenuRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuRelatorioClienteActionPerformed
        //ao clicar no item cliente do menu relatorio, vai gerar o relatorio dos clientes cadastrados, na assistencia tecnica
        //vai gerar um relatorio de clientes, usando a integração do framework jasper report com o java aqui netbens
        //a logica e clicou em gerar relatorio clientes, faço confirmação, se relamente quiser, vou mostrar o relatorio para o clinte.
        //a geração do relatorio e usando a integração do ireport com o java, a ferramenta de geração de relatorios do banco de dados
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Mesmo, Gerar o Relatório de Clientes ?", "Confirma Geração Do Relatório", JOptionPane.YES_NO_OPTION);
        //se escolheu a opção sim
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imprimindo o relatorio com o framework jasper Ireport
            try {
                //usando a classe JasperPrint(esta nas bibliotecas incluidas no projeto) para preparar impressão do relatorio de clientes
                JasperPrint imprimiRel = JasperFillManager.fillReport("C:/Users/SAMUE/Documents/Projeto-Java-Sistema-Info-X-2020-Casa-original/Relatorios-Gerados-Ireport/relatorio-clientes.jasper", null, conexao);
                //exibindo o relatório usando a classe JasperView(esta nas bibliotecas incluidas no projeto) para mostrar o relatorio para o cliente
                JasperViewer.viewReport(imprimiRel, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Erro ao imprimir Relatório de Clientes!");
            }
        }

    }//GEN-LAST:event_itemMenuRelatorioClienteActionPerformed

    private void itemMenuRelatorioServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuRelatorioServicosActionPerformed
        //outro opção do menu relatorio que vai gerar um relatorio completo de serviços
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Mesmo, Gerar o Relatório de Serviços ?", "Confirma Geração Do Relatório", JOptionPane.YES_NO_OPTION);
        //se escolheu a opção sim
        if (confirma == JOptionPane.YES_NO_OPTION) {
            //imprimindo o relatorio com o framework jasper Ireport
            try {
                //usando a classe JasperPrint(esta nas bibliotecas incluidas no projeto) para preparar impressão do relatorio de clientes
                JasperPrint imprimiRel = JasperFillManager.fillReport("C:/Users/SAMUE/Documents/Projeto-Java-Sistema-Info-X-2020-Casa-original/Relatorios-Gerados-Ireport/relatorio_servicos.jasper", null, conexao);
                //exibindo o relatório usando a classe JasperView(esta nas bibliotecas incluidas no projeto) para mostrar o relatorio para o cliente
                JasperViewer.viewReport(imprimiRel, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Erro ao imprimir Relatório de Serviços!");
            }
        }
    }//GEN-LAST:event_itemMenuRelatorioServicosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem itemMenuRelatorioCliente;
    private javax.swing.JMenuItem itemMenuRelatorioServicos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblIcone;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JMenuItem menCadItemUsua;
    public static javax.swing.JMenu menRelatorio;
    // End of variables declaration//GEN-END:variables
}

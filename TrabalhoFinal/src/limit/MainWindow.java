/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limit;

import control.ControlePrincipal;
import util.Util;

/**
 *
 * @author Rodrigo Maia
 */
public class MainWindow extends javax.swing.JFrame {
    private ControlePrincipal ctrPrincipal;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(ControlePrincipal pCtrPrincipal) {
        ctrPrincipal = pCtrPrincipal;
        initComponents();        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBarMainWindow = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        menuItemComissionado = new javax.swing.JMenuItem();
        menuItemContratado = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuCadastros.setText("Cadastrar");

        menuItemComissionado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemComissionado.setText("Comissionado");
        menuItemComissionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemComissionadoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemComissionado);

        menuItemContratado.setText("Contratado");
        jMenuCadastros.add(menuItemContratado);

        jMenuBarMainWindow.add(jMenuCadastros);

        jMenuVendas.setText("Realizar vendas");
        jMenuBarMainWindow.add(jMenuVendas);

        jMenuRelatorios.setText("Relatorios");

        jMenuItem4.setText("Faturamento Total");
        jMenuRelatorios.add(jMenuItem4);

        jMenuItem5.setText("Lucro Total");
        jMenuRelatorios.add(jMenuItem5);

        jMenuItem3.setText("Relação de Imóveis Vendidos");
        jMenuRelatorios.add(jMenuItem3);

        jMenuItem6.setText("Relação de Imóveis Encalhados ");
        jMenuRelatorios.add(jMenuItem6);

        jMenuItem7.setText("Faturamento de Cada Corretor");
        jMenuRelatorios.add(jMenuItem7);

        jMenuItem8.setText("Valor Pago a Cada Corretor");
        jMenuRelatorios.add(jMenuItem8);

        jMenuItem9.setText("Corretor do Mês");
        jMenuRelatorios.add(jMenuItem9);

        jMenuBarMainWindow.add(jMenuRelatorios);

        setJMenuBar(jMenuBarMainWindow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemComissionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemComissionadoActionPerformed
       
        ctrPrincipal.abrirJanelaCadastro(Util.CADASTRO_COMISSIONADO);
    }//GEN-LAST:event_menuItemComissionadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarMainWindow;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JMenuItem menuItemComissionado;
    private javax.swing.JMenuItem menuItemContratado;
    // End of variables declaration//GEN-END:variables
}

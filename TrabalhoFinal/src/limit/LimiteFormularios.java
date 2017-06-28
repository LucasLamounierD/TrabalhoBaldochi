/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limit;

import util.*;
import control.*;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Corretor;

/**
 *
 * @author linux
 */
public class LimiteFormularios extends javax.swing.JFrame {

    /**
     * Creates new form LimiteFormularios
     */
    private String selectionForm;
    private ControlePrincipal objControlePrin;

    public LimiteFormularios(ControlePrincipal pCtr) {
        objControlePrin = pCtr;
        this.setVisible(true);
        initComponents();
    }

    public LimiteFormularios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAno = new javax.swing.JComboBox<>();
        jButtonGerarRelatorio = new javax.swing.JButton();
        panelExibicaoRel = new javax.swing.JPanel();
        relatorioFaturamento = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();

        jTableVendasDoMes = new javax.swing.JTable();
        painelResultadoTotal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelValorFinal = new javax.swing.JLabel();
        jPanelLucroImob = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldLucroImob = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaVendasCorretorMes1 = new javax.swing.JTable();
        RelatorioGeral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRel = new javax.swing.JTable();
        RelatorioCorretorDoMes = new javax.swing.JPanel();
        nomeCorretor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CRECICCorretor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaVendasCorretorMes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 708));
        setPreferredSize(new java.awt.Dimension(820, 700));
        setSize(new java.awt.Dimension(820, 700));

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.setPreferredSize(new java.awt.Dimension(485, 400));

        Menu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu:"));

        jLabel1.setText("Mês");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel2.setText("Ano:");

        String[] str2 = new String[28];
        int cont2 = 0, anoAtual;
        Date data = new Date();
        anoAtual = data.getYear() + 1900;
        for(int i = anoAtual ; i >= 1990 ; i--){ str2[cont2] = "" + i; cont2++;  }
        jComboBoxAno.setModel(new javax.swing.DefaultComboBoxModel(str2));

        jButtonGerarRelatorio.setText("Gerar");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerarRelatorio))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelExibicaoRel.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório:"));
        panelExibicaoRel.setMaximumSize(new java.awt.Dimension(32767, 800));
        panelExibicaoRel.setLayout(new java.awt.CardLayout());

        jTableVendasDoMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Vendedor", "Valor da venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableVendasDoMes);

        painelResultadoTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("TOTAL:");

        jLabelValorFinal.setBackground(new java.awt.Color(183, 183, 183));

        javax.swing.GroupLayout painelResultadoTotalLayout = new javax.swing.GroupLayout(painelResultadoTotal);
        painelResultadoTotal.setLayout(painelResultadoTotalLayout);
        painelResultadoTotalLayout.setHorizontalGroup(
            painelResultadoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadoTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        painelResultadoTotalLayout.setVerticalGroup(
            painelResultadoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadoTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelResultadoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelResultadoTotalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelValorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout relatorioFaturamentoLayout = new javax.swing.GroupLayout(relatorioFaturamento);
        relatorioFaturamento.setLayout(relatorioFaturamentoLayout);
        relatorioFaturamentoLayout.setHorizontalGroup(
            relatorioFaturamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relatorioFaturamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelResultadoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(relatorioFaturamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(relatorioFaturamentoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        relatorioFaturamentoLayout.setVerticalGroup(
            relatorioFaturamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, relatorioFaturamentoLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(painelResultadoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(relatorioFaturamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(relatorioFaturamentoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        panelExibicaoRel.add(relatorioFaturamento, "Faturamento Total");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lucro:"));

        jTextFieldLucroImob.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldLucroImob.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        jTextFieldLucroImob.setEnabled(false);

        jLabel7.setText("RS:");

        TabelaVendasCorretorMes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TabelaVendasCorretorMes1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLucroImob, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLucroImob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLucroImobLayout = new javax.swing.GroupLayout(jPanelLucroImob);
        jPanelLucroImob.setLayout(jPanelLucroImobLayout);
        jPanelLucroImobLayout.setHorizontalGroup(
            jPanelLucroImobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLucroImobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLucroImobLayout.setVerticalGroup(
            jPanelLucroImobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLucroImobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelExibicaoRel.add(jPanelLucroImob, "Lucro Total");

        tabelaRel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaRel);

        javax.swing.GroupLayout RelatorioGeralLayout = new javax.swing.GroupLayout(RelatorioGeral);
        RelatorioGeral.setLayout(RelatorioGeralLayout);
        RelatorioGeralLayout.setHorizontalGroup(
            RelatorioGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        RelatorioGeralLayout.setVerticalGroup(
            RelatorioGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioGeralLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelExibicaoRel.add(RelatorioGeral, "Generic");

        nomeCorretor.setEditable(false);

        jLabel4.setText("Nome do Corretor");

        CRECICCorretor.setEditable(false);

        jLabel5.setText("CRECIC:");

        TabelaVendasCorretorMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TabelaVendasCorretorMes);

        jLabel6.setText("Vendas Realizadas pelo Corretor do mês:");

        javax.swing.GroupLayout RelatorioCorretorDoMesLayout = new javax.swing.GroupLayout(RelatorioCorretorDoMes);
        RelatorioCorretorDoMes.setLayout(RelatorioCorretorDoMesLayout);
        RelatorioCorretorDoMesLayout.setHorizontalGroup(
            RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                        .addGroup(RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nomeCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CRECICCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        RelatorioCorretorDoMesLayout.setVerticalGroup(
            RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RelatorioCorretorDoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRECICCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RelatorioCorretorDoMesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelExibicaoRel.add(RelatorioCorretorDoMes, "Corretor do Mês");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelExibicaoRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelExibicaoRel, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed

        //PEGA OS VALORES DE MES E ANO PARA BUSCAR AS VENDAS
        int mes = jComboBox1.getSelectedIndex();
        int ano = Integer.parseInt(jComboBoxAno.getItemAt(jComboBoxAno.getSelectedIndex()));

        //Gerencia qual processamento será feito quando clicado o botão
        if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_FATURAMENTO_TOTAL)) {//Faturamento total
            geraRelatorioFaturamento(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_LUCRO_TOTAL)) {
            geraRelatorioLucro(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_RELACAO_DE_IMOVEIS_VENDIDOS)) {
            geraRelatorioImoveisVendidos(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_RELACAO_DE_IMOVEIS_ENCALHADOS)) {
            geraRelatorioImoveisEncalhados(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_FATURAMENTO_POR_CORRETOR)) {
            geraRelatorioFaturamentoPorCorretor(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_VALOR_PAGO_PARA_CADA_CORRETOR)) {
            geraRelatorioValorPagoCorretores(mes, ano);
        } else if (jButtonGerarRelatorio.getActionCommand().equals(Util.REL_CORRETOR_DO_MES)) {
            geraRelatorioCorretorMes(mes, ano);
        }
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    //Gera relatorio de faturamento
    private void geraRelatorioFaturamento(int mes, int ano) {
        //RECEBE O VALOR TOTAL DAS VENDAS E FAZ O PREENCHIMENTO DA TABELA NA FUNÇÃO
        DecimalFormat decFor = new DecimalFormat("R$ 0.00");//Classe para conversão decimal
        float total = objControlePrin.getObjControleVendas().buscaVendasMes(mes, ano, jTableVendasDoMes);

        //MOSTRA O VALOR TOTAL DAS VENDAS
        jLabelValorFinal.setText("" + decFor.format(total));
    }

    private void geraRelatorioLucro(int mes, int ano) {
        jTextFieldLucroImob.setText(objControlePrin.getObjControleVendas().calcularLucroTotal(mes, ano, TabelaVendasCorretorMes1));
    }

    //Gera relatorio de Imoveis Vendidos
    private void geraRelatorioImoveisVendidos(int mes, int ano) {
        objControlePrin.getObjControleVendas().buscaImoveisVendidos(mes, ano, tabelaRel);
    }

    private void geraRelatorioImoveisEncalhados(int mes, int ano) {
        objControlePrin.getObjControleImovel().buscaImoveisEncalhados(mes, ano, tabelaRel);
    }

    private void geraRelatorioFaturamentoPorCorretor(int mes, int ano) {
        objControlePrin.getObjControleVendas().faturamentoCadaCorretor(mes, ano, tabelaRel);
    }

    private void geraRelatorioValorPagoCorretores(int mes, int ano) {
        objControlePrin.getObjControleVendas().valorPagoCorretor(mes, ano, tabelaRel);
    }

    private void geraRelatorioCorretorMes(int mes, int ano) {
        Corretor c = objControlePrin.getObjControleVendas().corretorDoMes(mes, ano, TabelaVendasCorretorMes);
        if (c != null) {
            nomeCorretor.setText(c.getNome());
            CRECICCorretor.setText(c.getCrecic());
        } else {
            nomeCorretor.setText("");
            CRECICCorretor.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CRECICCorretor;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel RelatorioCorretorDoMes;
    private javax.swing.JPanel RelatorioGeral;
    private javax.swing.JTable TabelaVendasCorretorMes;
    private javax.swing.JTable TabelaVendasCorretorMes1;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelValorFinal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLucroImob;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableVendasDoMes;
    private javax.swing.JTextField jTextFieldLucroImob;
    private javax.swing.JTextField nomeCorretor;
    private javax.swing.JPanel painelResultadoTotal;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelExibicaoRel;
    private javax.swing.JPanel relatorioFaturamento;
    private javax.swing.JTable tabelaRel;
    // End of variables declaration//GEN-END:variables

    //Metodo que defini qual relatorio vai ser exibido. O relatorio vai ser escolhido atraves das constantes.
    public void setWhichReportView(String relView) {
        this.setTitle(relView);//Defini Titulo da janela atraves do painel definido
        CardLayout cl = (CardLayout) panelExibicaoRel.getLayout();
        selectionForm = relView;
        cleanFrame();
        //Avalia qual relatorio será exibido   
        if (relView.equals(Util.REL_LUCRO_TOTAL)
                || relView.equals(Util.REL_FATURAMENTO_TOTAL)
                || relView.equals(Util.REL_CORRETOR_DO_MES)) {
            cl.show(panelExibicaoRel, relView);//Exibi o painel de visualização do relatorio escolhido        
        } else {
            cl.show(panelExibicaoRel, "Generic");//Exibi painel generico que serve para varios Relatorios
        }
        //   cl.show(panelExibicaoRel, relView);//Exibi o painel de visualização do relatorio escolhido
        jButtonGerarRelatorio.setActionCommand(relView);//defini qual processo vai ser executando quando botão gerar for apertado

    }

    public void cleanFrame() {
        DefaultTableModel df = (DefaultTableModel) tabelaRel.getModel();
        df.setColumnCount(0);
        df.setRowCount(0);
        df = (DefaultTableModel) jTableVendasDoMes.getModel();
        df.setColumnCount(0);
        df.setRowCount(0);
        jComboBoxAno.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
    }

}

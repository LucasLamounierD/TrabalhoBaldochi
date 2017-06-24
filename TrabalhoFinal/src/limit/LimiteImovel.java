package limit;

import control.ControleImovel;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import util.Util;

public class LimiteImovel extends javax.swing.JFrame {

    private ControleImovel ctrImovel;
    
    //Construtor do Imovel
    public LimiteImovel(ControleImovel pCtrImovel) {
        ctrImovel = pCtrImovel;
        initComponents();
    }
    /**{
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescrição = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeProp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        JFormattedData = new javax.swing.JFormattedTextField();
        jTextFieldPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de imóvel");
        setResizable(false);

        jLabel1.setText("Tipo:");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Casa", "Apartamento", "Sala comercial", "Lote", "Chácara", "Sítio", "Fazenda" }));

        jLabel2.setText("Codigo");

        jLabel3.setText("Descrição:");

        jTextAreaDescrição.setColumns(20);
        jTextAreaDescrição.setLineWrap(true);
        jTextAreaDescrição.setRows(5);
        jTextAreaDescrição.setWrapStyleWord(true);
        jTextAreaDescrição.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextAreaDescrição);

        jLabel4.setText("Nome do proprietário:");

        jLabel5.setText("Preço:");

        jLabel6.setText("R$");

        jLabel7.setText("Data:");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        JFormattedData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jTextFieldPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jTextFieldPreco.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodigo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxTipo, 0, 274, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeProp)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldPreco))
                                            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(JFormattedData))
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFormattedData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCadastrar)
                            .addComponent(jButtonCancelar))
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Caso seja apertado o botão Cadastrar será pego as informações que estão nos Jtext, e irá passa-las para o controle e será validado lá
    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        System.out.println("Clicado");
        String msg="";
        try {
            if(jButtonCadastrar.getActionCommand().equals("Create")){
            //Passando ao controle os valores dos campos para o cadastro e tratado uma evetual exception
                ctrImovel.cadImovel(jTextFieldCodigo.getText(),
                                    jComboBoxTipo.getSelectedItem().toString(),
                                    jTextAreaDescrição.getText(),
                                    jTextFieldNomeProp.getText(),
                                    jTextFieldPreco.getText(),
                                    JFormattedData.getText()
                                    );              
                JOptionPane.showMessageDialog(rootPane, "Imóvel cadastrado com sucesso",
                "SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                
            }else if(jButtonCadastrar.getActionCommand().equals("Edit")){
                ctrImovel.editImovel(jTextFieldNomeProp.getText(),
                                     jTextFieldPreco.getText(),
                                     new Date(JFormattedData.getText()),
                                     jTextAreaDescrição.getText());
                JOptionPane.showMessageDialog(rootPane, "Imóvel Editado com sucesso",
                "SUCESSO",JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
            
        }catch (Exception ex) {//Mensagem de erro.
            JOptionPane.showMessageDialog(rootPane,ex.getMessage(),"Erro ao cadastrar imóvel",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed
    
    //Caso seja apertado botão cancelar a janela será fechada
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();     
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField JFormattedData;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescrição;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNomeProp;
    private javax.swing.JFormattedTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables

     public void setValueField(String pCodigo,String pTipo,String pNomeProp,
                                float pPreco,Date pData,String descricao ) {
         
                
        Locale local = new Locale("pt","Br");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
         
         
        jTextFieldCodigo.setText(pCodigo);
        jComboBoxTipo.setSelectedItem(pTipo);
        jTextFieldNomeProp.setText(pNomeProp);
        jTextFieldPreco.setText(""+pPreco);        
        JFormattedData.setText(df.format(pData));         
        jTextAreaDescrição.setText(descricao);
    }
   
    //Limpa campos dajanela
    public void resetFields(){
        jTextFieldPreco.setText("");
        jTextFieldNomeProp.setText("");
        jTextFieldCodigo.setText("");
        jComboBoxTipo.setSelectedIndex(0);
        jTextAreaDescrição.setText("");
        JFormattedData.setText("");
    }
     
    public void setTypeOperation(int opType) {
        if(opType == Util.OP_CREATE){
            this.enableFieldsRequired(true);
            jButtonCadastrar.setText("Cadastrar");
            jButtonCadastrar.setActionCommand("Create");
        }else if(opType == Util.OP_EDIT){
            this.enableFieldsRequired(false);
            jButtonCadastrar.setText("Concluir");
            jButtonCadastrar.setActionCommand("Edit");
        }
    }

    private void enableFieldsRequired(boolean status) {
        jTextFieldCodigo.setEnabled(status);
        jComboBoxTipo.setEnabled(status);
    }
}

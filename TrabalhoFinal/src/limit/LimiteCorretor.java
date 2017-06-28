package limit;


import control.ControleCorretor;
import java.text.DateFormat;
import java.util.Locale;
import javax.swing.*;
import util.Util;


public class LimiteCorretor extends javax.swing.JFrame {
    
    private ControleCorretor ctrCorretor;
    //Construtor
    public LimiteCorretor(ControleCorretor pCtrCorretor) {
        ctrCorretor = pCtrCorretor;
        initComponents();
        
    }
    
    //Definindo qual é o tipo de Corretor que será cadastrado
    public void setSelectedComboTipoCorretor(int ent){
        jComboTipoCorretor.setSelectedIndex(ent);
    }
    
    //Defini valores para cada do formulario
    public void setValueField(int tipoCorretor, String nome, String CRECIC,
                                 String comissao, String dataAdmissao, String salario){
        
        this.setSelectedComboTipoCorretor(tipoCorretor);
        jTextNome.setText(nome);
        jTextCrecic.setText(CRECIC);
        jTextComissao.setText(comissao);
        TextData.setText(dataAdmissao);
        fieldValorSalario.setText(salario);        
    }
    
    //Defini quais campo estarão disponiveis para edição
    public void setEnabledField(boolean tipoCorretor, boolean nome, boolean CRECIC,
                                 boolean comissao, boolean dataAdmissao, boolean salario){
       
        jComboTipoCorretor.setEnabled(tipoCorretor);
        jTextNome.setEditable(nome);
        jTextCrecic.setEditable(CRECIC);
        jTextComissao.setEditable(comissao);
        TextData.setEditable(dataAdmissao);
        fieldValorSalario.setEditable(salario);        
    }    
     
    public void cleanFields(){
        this.setValueField(0, "", "","","","");
    }
    
    public void setTypeOperation(int type) {
        if(type == Util.OP_CREATE){
            jBtnSubmit.setText("Cadastrar");
            jBtnSubmit.setActionCommand("create");
        }else if(type == Util.OP_EDIT){
            jBtnSubmit.setText("Concluir");
            jBtnSubmit.setActionCommand("edit");
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCrecic = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextComissao = new javax.swing.JTextField();
        jBtnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboTipoCorretor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TextData = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldValorSalario = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/jframeicon.png")).getImage());
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("%");

        jLabel3.setText("Comissão:");

        jTextCrecic.setToolTipText("Informe o CRECIC do corretor");

        jLabel2.setText("CRECIC:");

        jTextNome.setToolTipText("Informe o nome do corretor");

        jLabel1.setText("Nome:");

        jTextComissao.setText("0");
        jTextComissao.setToolTipText("Informe a comissão do corretor");
        jTextComissao.setEnabled(false);

        jBtnSubmit.setText("Cadastrar");
        jBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSubmitActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo:");

        jComboTipoCorretor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contratado", "Comissionado" }));
        jComboTipoCorretor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboTipoCorretorItemStateChanged(evt);
            }
        });

        jLabel6.setText("Data de Admissao:");

        TextData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel7.setText("Valor Salario:");

        fieldValorSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCrecic)
                    .addComponent(jTextNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboTipoCorretor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33)
                                .addComponent(TextData, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnSubmit)
                                .addGap(19, 19, 19)
                                .addComponent(jBtnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(fieldValorSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboTipoCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCrecic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldValorSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSubmit)
                    .addComponent(jBtnCancelar))
                .addContainerGap())
        );

        jTextNome.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSubmitActionPerformed
        if(evt.getActionCommand().equals("create")){
            try {//Passando ao controle os valores dos campos para o cadastro e tratando uma evetual exception
               ctrCorretor.cadCorretor(jComboTipoCorretor.getSelectedIndex(),
                                       jTextNome.getText(),
                                       jTextCrecic.getText(),
                                       jTextComissao.getText(),
                                       TextData.getText(),
                                       fieldValorSalario.getText()
                                       );

               JOptionPane.showMessageDialog(this, "Corretor cadastrado com sucesso",
                                            "SUCESSO",JOptionPane.INFORMATION_MESSAGE);            
               this.dispose();

           } catch (Exception ex) {//Mensagem de erro.
               JOptionPane.showMessageDialog(this, "Erro ao cadastrar corretor\n\n"
                                            + ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
           } 
        }else{
            try {//Passando ao controle os valores dos campos para o cadastro e tratando uma evetual exception
               ctrCorretor.editCorretor(jTextComissao.getText(),fieldValorSalario.getText());

               JOptionPane.showMessageDialog(this, "Corretor editado com sucesso",
                                            "SUCESSO",JOptionPane.INFORMATION_MESSAGE);            
               this.dispose();

           } catch (Exception ex) {//Mensagem de erro.
               JOptionPane.showMessageDialog(this, "Erro ao editar corretor\n\n"
                                            + ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
           } 
        }
    }//GEN-LAST:event_jBtnSubmitActionPerformed

    private void jComboTipoCorretorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboTipoCorretorItemStateChanged
        if(jComboTipoCorretor.getSelectedIndex()==0){
            jTextComissao.setEnabled(false);
            TextData.setEnabled(true);
            fieldValorSalario.setEnabled(true);
        }else if(jComboTipoCorretor.getSelectedIndex()==1){
            jTextComissao.setEnabled(true);
            TextData.setEnabled(false);
            fieldValorSalario.setEnabled(false);
        }
        System.out.println("foi");
    }//GEN-LAST:event_jComboTipoCorretorItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField TextData;
    private javax.swing.JFormattedTextField fieldValorSalario;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnSubmit;
    private javax.swing.JComboBox<String> jComboTipoCorretor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextComissao;
    private javax.swing.JTextField jTextCrecic;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables

 
}

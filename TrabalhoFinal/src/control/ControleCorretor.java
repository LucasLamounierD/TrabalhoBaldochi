package control;

import limit.LimiteCorretor;
import model.Comissionado;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import util.Util;

public class ControleCorretor {

    private LimiteCorretor lmtCorretor;
    private Vector<Corretor> vecCorretor = new Vector();
    private ControlePrincipal ctrPrincipal;
    private DefaultTableModel tableCorretoresModel;
    private int IndexBeingEditedNow;
    //Constantes
    public final static int OP_CONTRATADO = 0;
    public final static int OP_COMISSIONADO = 1;    
    public final static int OP_CREATE = 0;
    public final static int OP_EDIT = 1;

    public ControleCorretor(ControlePrincipal pCtrPrincipal) throws Exception{//Construtor do ControleCorretor
        ctrPrincipal = pCtrPrincipal;
        lmtCorretor = new LimiteCorretor(this);//Instacia uma janela para o cadastro
        desserializaCorretor();
        instTableCorretoresModel();
    }

    //Metodo recebe o menu selecionado e decidi qual tipo de Corretor vai ser cadastrado
    void abrirJanelaCadastro(int ent) {
        lmtCorretor.cleanFields();
        lmtCorretor.setEnabledField(true, true, true, true, true, true);
        lmtCorretor.setSelectedComboTipoCorretor(ent);
        lmtCorretor.setTypeOperation(OP_CREATE);
        lmtCorretor.setVisible(true);
    }
    
    /*Metodo Chama a mesma janela do cadastro e preeche o formulario como valores validos
    para que haja a edição dos campos autotizado
    */
    void abrirJanelaEditar(int IndexRow) {
        IndexBeingEditedNow = IndexRow;
        Corretor tempCorr = vecCorretor.get(IndexRow);
        if(tempCorr instanceof Comissionado ){//Se for comissionado            
            lmtCorretor.setValueField(OP_COMISSIONADO,tempCorr.getNome()
                                                     ,tempCorr.getCrecic()
                                                     ,""+((Comissionado) tempCorr).getComissao()
                                                     , "", "");            
            //Desabilita edição de todos os campos, exceto o campo de valor de comissao
            lmtCorretor.setEnabledField(false,false,false,true,false,false);
            
        }else if(tempCorr instanceof Contratado ){//Se for contratado
            lmtCorretor.setValueField(OP_CONTRATADO,tempCorr.getNome()
                                                   ,tempCorr.getCrecic()
                                                   ,"1"
                                                   ,((Contratado) tempCorr).getDataAdmissao().toString()
                                                   ,""+((Contratado) tempCorr).getSalarioFixo());
            //Desabilita edição de todos os campos, exceto o campo de valor de salario
            lmtCorretor.setEnabledField(false,false,false,false,false,true);
        }        
        lmtCorretor.setTypeOperation(OP_EDIT);
        lmtCorretor.setVisible(true);
    }

    
    //Função de cadastro de comissionado
    public void cadCorretor(int pTipoCorr,String pNome, String pCrecic,
                            String pComissao,String pData,String pVlrSalario) 
                                                            throws Exception {
        //Fazendo conversões das variaveis
        float comissao = 0;
        if(!pComissao.isEmpty())//Verificando se a string não e vazia
               comissao = Float.parseFloat(pComissao);//Convertendo
        
        float salario=0;
        //Convertendo salario
        if(!pVlrSalario.isEmpty()){//Verificando se a string não é vazia
            //Instaciando classe que possibilitará fazer conversões de String com virgula
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            try {
                salario = nf.parse(pVlrSalario).floatValue();//realizando conversão
            } catch (ParseException ex) {
                Logger.getLogger(LimiteCorretor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

         if(OP_COMISSIONADO==pTipoCorr){//Validando campos mais especificos e chamando construtor do comissionado
            
            Comissionado c = new Comissionado(pNome,pCrecic,comissao);
            vecCorretor.add(c);
            //Adiciona na tabela da janela principal o corretor. 
            tableCorretoresModel.addRow(new Object[]{c.getNome(),c.getCrecic(),"Comissionado"});
            
         }else{//Validando campos mais especificos e chamando construtor do contratado
            
            Contratado c =new Contratado(pNome,pCrecic,salario,pData);
            vecCorretor.add(c); 
            salva();
            //Adiciona na tabela da janela principal o corretor.
            tableCorretoresModel.addRow(new Object[]{c.getNome(),c.getCrecic(),"Contratado"});
            
         }
    } 
    
    public void editCorretor(String comissao, String salario) {
       
        float vlrSalario=0;
        if(!salario.isEmpty()){//Verificando se a string não é vazia
            //Instaciando classe que possibilitará fazer conversões de String com virgula
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            try {
                vlrSalario = nf.parse(salario).floatValue();//realizando conversão
            } catch (ParseException ex) {
                Logger.getLogger(LimiteCorretor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        float vlrComissao = 0;
        if(!comissao.isEmpty())//Verificando se a string não e vazia
               vlrComissao = Float.parseFloat(comissao);//Convertendo
        
        Corretor c = vecCorretor.get(IndexBeingEditedNow);
        
        if(c instanceof Contratado){
            
        }else if(c instanceof Comissionado){
            
        }
        
    }

    public void instTableCorretoresModel(){
        
        tableCorretoresModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int colunm){
                return false;
            }
        };
        
        tableCorretoresModel.addColumn("Corretor");
        tableCorretoresModel.addColumn("CRECIC");
        tableCorretoresModel.addColumn("TIPO");
        
        for(Corretor c : vecCorretor ){
            if(c  instanceof Comissionado){
                tableCorretoresModel.addRow(new Object[]{c.getNome(),c.getCrecic(),"Comissionado"});
            }else if(c  instanceof Contratado){
                tableCorretoresModel.addRow(new Object[]{c.getNome(),c.getCrecic(),"Contratado"});
            }
        }
    }

    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecCorretor);
        objOS.flush();
        objOS.close();
    }

    private void desserializaCorretor() throws Exception {
        File objFile = new File("corretores.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("corretores.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecCorretor = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void salva() {
        try {
            serializaCorretor();
        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo.\n");
        }
    }

    public Vector getVecCorretor() {
        return vecCorretor;
    }

    public ControlePrincipal getCtrPrincipal() {
        return ctrPrincipal;
    }

    public void finalize() throws Exception {
        serializaCorretor();
    }

    public DefaultTableModel getTableCorretoresModel() {
        return tableCorretoresModel;
    }
    
}

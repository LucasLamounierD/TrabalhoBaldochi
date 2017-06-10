package control;


import limit.LimiteCorretor;
import model.Comissionado;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contratado;
import model.Corretor;
import util.Util;

public class ControleCorretor {
    private LimiteCorretor lmtCorretor;
    private ArrayList<Corretor> vecCorretor = new ArrayList<Corretor>();
    
    //Constantes
    public final static int OP_CONTRATADO =0;
    public final static int OP_COMISSIONADO =1;

    public ControleCorretor(){//Construtor do ControleCorretor
        lmtCorretor = new LimiteCorretor(this);//Instacia uma janela para o cadastro
      //  desserializaCorretor();
    }
    
    //Função recebe o menu selecionado e decidi qual tipo de Corretor vai ser cadastrado
    void abrirJanelaCadastro(int ent) {
        lmtCorretor.setSelectedComboTipoCorretor(ent);
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
        
        
         if(pNome.equals("")){//Validação dos campos, caso estiver incorreto lança um Exception
            throw new Exception("Campo nome não foi preechido!");  
         }else if(pCrecic.equals("")){
            throw new Exception("Campo CRECIC não foi preechido!"); 
         }else if(OP_COMISSIONADO==pTipoCorr){//Validando campos mais especificos e chamando construtor do comissionado
            if (comissao<1 || comissao>3){
              throw new Exception("Valor Invalido no campo Comissão!"); 
            }else{//Se todos dados corretos cadastra Comissionados
               vecCorretor.add( new Comissionado(pNome,pCrecic,comissao)); 
            }
         }else{//Validando campos mais especificos e chamando construtor do contratado
            if (pData.isEmpty()){
                throw new Exception("Preecha campo Data de admissão com um valor valido!"); 
            }else if(salario<900){
                throw new Exception("Preecha campo Valor Salario com um valor valido!"); 
            }
            else{//Se todos dados corretos cadastra Comissionados
               vecCorretor.add( new Contratado(pNome,pCrecic,comissao,new Date((long)salario))); 
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
            vecCorretor = (ArrayList) objIS.readObject();
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

    public ArrayList getVecCorretor() {
        return vecCorretor;
    }

    public void finalize() throws Exception {
        serializaCorretor();
    }
}

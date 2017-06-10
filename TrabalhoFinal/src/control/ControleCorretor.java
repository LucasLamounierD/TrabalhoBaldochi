package control;


import limit.LimiteComissionado;
import model.Contratado;
import model.Comissionado;
import java.io.*;
import java.util.*;
import util.Util;

public class ControleCorretor {
    private LimiteComissionado lmtCorretor;
    private Vector vecCorretor = new Vector();

    public ControleCorretor(){//Construtor do ControleCorretor
        lmtCorretor = new LimiteComissionado(this);//Instacia uma janela para o cadastro
      //  desserializaCorretor();
    }
    
    //Função recebe o menu selecionado e decidi qual tipo de Corretor vai ser cadastrado
    void abrirJanelaCadastro(int ent) {
        if(ent == Util.CADASTRO_COMISSIONADO){ 
            lmtCorretor.setVisible(true);
        }
    }    

    //Função de cadastro de comissionado
    public void cadComissionado(String pNome, String pCrecic,float pComissao) throws Exception {
        
         if(pNome.equals("")){//Validação dos campos, caso estiver incorreto lança um Exception
            throw new Exception("Campo nome não foi preechido!");  
         }else if(pCrecic.equals("")){
            throw new Exception("Campo CRECIC não foi preechido!"); 
         }else if (pComissao<=1 || pComissao>=3){
              throw new Exception("Valor Invalido no campo Comissão!"); 
         }else{//Se todos dados corretos cadastra Comissionados
            vecCorretor.add( new Comissionado(pNome,pCrecic,pComissao)); 
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

    public void finalize() throws Exception {
        serializaCorretor();
    }
}

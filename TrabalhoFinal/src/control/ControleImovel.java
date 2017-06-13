package control;

import model.Imovel;
import limit.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControleImovel {

    private Imovel entImovel;
    private Vector vecImovel = new Vector();
    private LimiteImovel limImovel;
    private ControlePrincipal ctrPrincipal;

    public ControleImovel(ControlePrincipal pCtrPrincipal) {

        ctrPrincipal = pCtrPrincipal;
        limImovel = new LimiteImovel(this);//Instacia uma janela para o cadastro
        
    }

    private void serializaImovel() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecImovel);
        objOS.flush();
        objOS.close();
    }

    private void desserializaImovel() throws Exception {
        File objFile = new File("imoveis.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecImovel = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    void abrirJanelaCadastroImovel() {

        limImovel.setVisible(true);
        
    }
    
    public void cadImovel(String pCod,String pTipo,String pDescrição, String pNomeProp, String pPreço, String pData)throws Exception{
        
        //declarando variaveis auxiliares para conversao e cadastro
        
        float preço = 0;
        SimpleDateFormat dataVenda = null;
        
        //fazendo a conversão das variaveis      
        if(!pPreço.isEmpty()){
            preço = Float.parseFloat(pPreço);
        }
        
        if(!pData.isEmpty()){
            dataVenda = new SimpleDateFormat(pData);
        }
        
        //validação dos campos String
        
        if(!pCod.equals("")){
            throw new Exception("Informe o código do imóvel.");
        }
        
        if(pTipo.equals("")){
            throw new Exception("Informe o tipo do imóvel.");
        }
        
        if(pNomeProp.equals("")){
            throw new Exception("Informe o nome do proprietário.");
        }
        
        entImovel = new Imovel(pCod, pTipo, pDescrição, pNomeProp, preço, dataVenda);
        vecImovel.add(entImovel);
        
    }

    private void salva() {

        try {
            serializaImovel();
        } catch (Exception e) {
            System.out.println("Erro ao manipular arquivo.\n");
        }

    }

    public Imovel getEntImovel() {
        return entImovel;
    }

    public Vector getVecImovel() {
        return vecImovel;
    }

}

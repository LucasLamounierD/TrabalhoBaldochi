package control;

import model.Imovel;
import limit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import util.Util;

public class ControleImovel {

    //Declaração das variavéis
    private Vector<Imovel> vecImovel = new Vector<>();
    private LimiteImovel limImovel;
    private ControlePrincipal ctrPrincipal;
    private DefaultTableModel tableImoveisModel;
    private int IndexBeingEditedNow;

    //Construtor do controle de Imovel
    public ControleImovel(ControlePrincipal pCtrPrincipal) throws Exception {
        //Passa o controle recebido para a variável ctrPrincipal
        ctrPrincipal = pCtrPrincipal;
        limImovel = new LimiteImovel(this);//Instacia uma janela para o cadastro
        desserializaImovel();
        instTableImoveisModel();
    }

    //Metodo que será o responsavél por deixar visível a janela
    void abrirJanelaCadastroImovel() {
        limImovel.resetFields();
        limImovel.setTypeOperation(Util.OP_CREATE);
        limImovel.setVisible(true);
    }
    //Metodo que será o responsavél por deixar visível a janela
    void abrirJanelaEditorImovel(int index){
        IndexBeingEditedNow = index;
        Imovel i = vecImovel.get(index);
        
        limImovel.setValueField(i.getCodigo(),i.getTipo(),i.getNomePropietario(),
                                i.getPreco(),i.getDataCad(),i.getDescricao());
        limImovel.setTypeOperation(Util.OP_EDIT);
        limImovel.setVisible(true);
    }
    
    //Metodo que irá remover um imóvel
    void removeImovel(int pIndex){
        vecImovel.remove(pIndex);
        tableImoveisModel.removeRow(pIndex);
        salva();
    }

    //Metodo que será responsável pelo recebimento dos dados informados no limite
    public void cadImovel(String pCod, String pTipo, String pDescricao, String pNomeProp, String pPreco, String pData) throws Exception {
        //declarando variaveis auxiliares para conversao e cadastro
        float preço = 0;
        //fazendo a conversão das preco   
        if (!pPreco.isEmpty()) {
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            preço = nf.parse(pPreco).floatValue();
        }  
        //Instanciado Objeto e adicionando ao vetor
        Imovel i = new Imovel(pCod, pTipo, pDescricao, pNomeProp, preço, pData);
        vecImovel.add(i);
        tableImoveisModel.addRow(new Object[]{i.getCodigo(),i.getTipo(),i.getPreco(),i.getNomePropietario()});
        salva();
    }

    //Metodo que será responsavel por editar o imovel selecionado
    public void editImovel(String pNomeProp,String pPreco,Date pData,String descricao) throws Exception{
        Imovel i = vecImovel.get(IndexBeingEditedNow);
        float preco = Util.convFloatComVirgula(pPreco);        
        
        i.setNomePropietario(pNomeProp);        
        i.setPreco(preco);
        i.setDescricao(descricao);
        salva();
    }
    
    //Serializa o Array de Imovel, o passando para o arquivo imoveis.dat
    private void serializaImovel() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecImovel);
        objOS.flush();
        objOS.close();
    }

    //Desserializa os dados que estão no arquivo imoveis.dat, e coloca os dados no ArrayList
    private void desserializaImovel() throws Exception {
        File objFile = new File("imoveis.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecImovel = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    
    //Metodo que tentara o salvar os dados no arquivo, caso não consiga irá mostrar uma mensagem de erro 
    private void salva() {
        try {
            serializaImovel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar o arquivo", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void instTableImoveisModel() {

        tableImoveisModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colunm) {
                return false;
            }
        };

        tableImoveisModel.addColumn("CODIGO");
        tableImoveisModel.addColumn("TIPO");
        tableImoveisModel.addColumn("PREÇO");
        tableImoveisModel.addColumn("PROPRIETÁRIO");

        for (Imovel i : vecImovel) {
            tableImoveisModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreco()), i.getNomePropietario()});
        }
    }

    public DefaultTableModel getTableCorretoresModel() {
        return tableImoveisModel;
    }

    public void finalize() throws Exception {
        serializaImovel();
    }
    
     public Vector getVecImovel() {
        return vecImovel;
    }

    public ControlePrincipal getCtrPrincipal() {
        return ctrPrincipal;
    }

}

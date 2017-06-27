package control;

import model.Imovel;
import limit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import util.Util;
import util.MyTableModel;

public class ControleImovel {

    //Declaração das variavéis
    private Vector<Imovel> vecImovel;
    private LimiteImovel limImovel;
    private ControlePrincipal ctrPrincipal;
    
    private MyTableModel tableImoveisModel;
    private DefaultComboBoxModel comboBoxTipoImoveisDispModel;
    private int IndexBeingEditedNow;
    private int ultimoCodigoGerado;

    //Construtor do controle de Imovel
    public ControleImovel(ControlePrincipal pCtrPrincipal) throws Exception {
        vecImovel = new Vector();
        comboBoxTipoImoveisDispModel = new DefaultComboBoxModel ();
        //Passa o controle recebido para a variável ctrPrincipal
        ctrPrincipal = pCtrPrincipal;        
        limImovel = new LimiteImovel(this);//Instacia uma janela para o cadastro
        desserializaImovel();
        lerUltimoCodGerado();
        instTableImoveisModel();
    }

    //Metodo que será o responsavél por deixar visível a janela
    void abrirJanelaCadastroImovel() {
        limImovel.resetFields();
        limImovel.setValueField(""+(ultimoCodigoGerado+1),"","",0,null,"");        
        limImovel.setTypeOperation(Util.OP_CREATE);
        limImovel.setVisible(true);
    }
    
    //Metodo que será o responsavél por deixar visível a janela
    void abrirJanelaEditorImovel(String chave){
        IndexBeingEditedNow = buscaIndiceListaImovel(chave);
        Imovel i = vecImovel.get(IndexBeingEditedNow);
        
        limImovel.setValueField(i.getCodigo(),i.getTipo(),i.getNomePropietario(),
                                i.getPreco(),i.getDataCad(),i.getDescricao());
        limImovel.setTypeOperation(Util.OP_EDIT);
        limImovel.setVisible(true);
    }
    //Metodo recebe um codigo e usa como chave de busca
    public int buscaIndiceListaImovel(String chaveCodigo){
        for(int i=0;i<vecImovel.size();i++){
            if(vecImovel.get(i).getCodigo().equals(chaveCodigo)){
                return i;
            }
        }
        return -1;
    }
    
    //Metodo que irá remover um imóvel
    void removeImovel(String chave){
        int i= buscaIndiceListaImovel(chave);
        if(i>-1){
            vecImovel.remove(i);
            salva();
            updateTableImoveis(comboBoxTipoImoveisDispModel.getSelectedItem().toString(),true);            
            return;
        } 
    }

    //Metodo que será responsável pelo recebimento dos dados informados no limite
    public void cadImovel(String pTipo, String pDescricao, String pNomeProp, String pPreco, String pData) throws Exception {
        //declarando variaveis auxiliares para conversao e cadastro
        float preço = 0;
        //fazendo a conversão das preco   
        preço = Util.convFloatComVirgula(pPreco);
        //Instanciado Objeto e adicionando ao vetor
        Imovel i = new Imovel(""+(++ultimoCodigoGerado), pTipo, pDescricao, pNomeProp, preço, pData);
        vecImovel.add(i);
        salva();
        updateTableImoveis(comboBoxTipoImoveisDispModel.getSelectedItem().toString(),true);
    }

    //Metodo que será responsavel por editar o imovel selecionado
    public void editImovel(String pNomeProp,String pPreco,String pData,String descricao) throws Exception{
        Imovel i = vecImovel.get(IndexBeingEditedNow);
        float preco = Util.convFloatComVirgula(pPreco);        
        
        i.setNomePropietario(pNomeProp);        
        i.setPreco(preco);
        i.setDescricao(descricao);
        i.setDataCad(pData);
        salva();
        updateTableImoveis(comboBoxTipoImoveisDispModel.getSelectedItem().toString(),false);
    }   
    
    private void salvaUltimoCodGerado(){
         //Abrindo arquivo e salvando ultimo codigo gerado
        FileOutputStream fileUltimoCodigoGerado;       
        try {//Se o houve algum erro ele não grava a informação
            fileUltimoCodigoGerado = new FileOutputStream("conf.dat");
            ObjectOutputStream objUltimoCodigoGerado = new ObjectOutputStream(fileUltimoCodigoGerado);
            objUltimoCodigoGerado.writeInt(ultimoCodigoGerado);
            objUltimoCodigoGerado.flush();
            objUltimoCodigoGerado.close();
        } catch (Exception ex) {
            return;
        }        
    }
    
    private void lerUltimoCodGerado(){
        File objFile = new File("conf.dat");
        if (objFile.exists()) {           
            try {//Se houver algum erro o ultimo codigo gerado sera 0
                FileInputStream objFileIS = new FileInputStream("conf.dat");
                ObjectInputStream objIS;
                objIS = new ObjectInputStream(objFileIS);
                ultimoCodigoGerado = objIS.readInt();
                objIS.close();
            } catch (IOException ex) {
                ultimoCodigoGerado=0;
            }            
        }else{//Se o arquivo não existir ultimi codigo gerado também será 0
            ultimoCodigoGerado=0;
        } 
    }
    
    //Serializa o Array de Imovel, o passando para o arquivo imoveis.dat
    private void serializaImovel() throws Exception { 
        //Abrindo arquivo salvando imoveis e fechado o arquivo
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
    
    //Retorna imoveis que estejam á mais de 6 meses esperando por uma venda, para o relatorio
    public void buscaImoveisEncalhados(int mes, int ano, JTable tabelaExibicao) {        
        MyTableModel tableModel = new MyTableModel();
        //Inseri colunas na tabela
        tableModel.addColumn("CODIGO");
        tableModel.addColumn("TIPO");
        tableModel.addColumn("PREÇO");
        tableModel.addColumn("PROPRIETÁRIO");
        
         Locale local = new Locale("pt","br");
         Calendar dataReq = Calendar.getInstance(local);
         dataReq.set(ano,mes,0);//Seta mes se ano escolhido nos filtros do relatorio
         dataReq.add(Calendar.MONTH, -6);//Diminui 6 meses da data escolhida.
         Date dataFiltro = dataReq.getTime();//Guarda data de filtro
                
        //percorre lista de Imoveis
        for(Imovel i : vecImovel){            
            if(dataFiltro.compareTo(i.getDataCad())==1){//Se a data de cadastro do imovel vier antes da data de filtro 
                //Inseri na tabela os dados sobre o imovel
                tableModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreco()), i.getNomePropietario()});
            }
        }
        
        tabelaExibicao.setModel(tableModel);
    }

    //Cria a model da tabela e analisa quais tipos de imoveis estão disponiveis
    public void instTableImoveisModel() {         
        //Desabilita a edição dos campos da tabela
        tableImoveisModel = new MyTableModel();
        //Adiciona as colunas
        tableImoveisModel.addColumn("CODIGO");
        tableImoveisModel.addColumn("TIPO");
        tableImoveisModel.addColumn("PREÇO");
        tableImoveisModel.addColumn("PROPRIETÁRIO");

        //Analisa imoveis disponiveis
        comboBoxTipoImoveisDispModel.addElement("Todos");
        for (Imovel i : vecImovel) {            
            if(comboBoxTipoImoveisDispModel.getIndexOf(i.getTipo())==-1){
                comboBoxTipoImoveisDispModel.addElement(i.getTipo());
            }            
            tableImoveisModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreco()), i.getNomePropietario()});
        }
    }
    
    public void updateTableImoveis(String filterType,boolean updateModelTypeToo){             
        
        tableImoveisModel.setRowCount(0);  
        
        if(updateModelTypeToo){
            ctrPrincipal.getObjLimPrincipal().setActiveEventChangeFiltroTipoDeImovel(false);
            comboBoxTipoImoveisDispModel.removeAllElements();
            comboBoxTipoImoveisDispModel.addElement("Todos");
        }       
        
        for(Imovel i: vecImovel){            
            if(updateModelTypeToo && comboBoxTipoImoveisDispModel.getIndexOf(i.getTipo())==-1){
                comboBoxTipoImoveisDispModel.addElement(i.getTipo());
            }
            
           if(filterType.equals("Todos")){
               tableImoveisModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreco()), i.getNomePropietario()});
           } if(i.getTipo().equals(filterType)){
               tableImoveisModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreco()), i.getNomePropietario()});
           } 
        }
        
        if(updateModelTypeToo){
            ctrPrincipal.getObjLimPrincipal().setActiveEventChangeFiltroTipoDeImovel(true);
            ctrPrincipal.getObjLimPrincipal().setSelectedFiltroTipoImoveis(filterType);
        }
        
    }
    
    public void finalize() throws Exception {
        serializaImovel();
        salvaUltimoCodGerado();
    }  
    

    public DefaultTableModel getTableCorretoresModel() {
        return tableImoveisModel;
    }

    public Vector getVecImovel() {
        return vecImovel;
    }

    public ControlePrincipal getCtrPrincipal() {
        return ctrPrincipal;
    }

    public DefaultComboBoxModel getComboBoxTipoImoveisDispModel() {
        return comboBoxTipoImoveisDispModel;
    }    
}

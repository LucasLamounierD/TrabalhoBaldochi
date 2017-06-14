package control;

import model.Imovel;
import limit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ControleImovel {

    //Declaração das variavéis
    private Vector<Imovel> vecImovel = new Vector<>();
    private LimiteImovel limImovel;
    private ControlePrincipal ctrPrincipal;
    private DefaultTableModel tableImoveisModel;

    //Construtor do controle de Imovel
    public ControleImovel(ControlePrincipal pCtrPrincipal) throws Exception {
        //Passa o controle recebido para a variável ctrPrincipal
        ctrPrincipal = pCtrPrincipal;
        limImovel = new LimiteImovel(this);//Instacia uma janela para o cadastro
        desserializaImovel();
        instTableCorretoresModel();
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

    //Metodo que será o responsavél por deixar visível a janela
    void abrirJanelaCadastroImovel() {

        limImovel.setVisible(true);
    }

    //Metodo que será responsável pelo recebimento dos dados informados no limite
    public void cadImovel(String pCod, String pTipo, String pDescrição, String pNomeProp, String pPreço, String pData) throws Exception {

        //declarando variaveis auxiliares para conversao e cadastro
        float preço = 0;

        //fazendo a conversão das variaveis      
        if (!pPreço.isEmpty()) {
            preço = Float.parseFloat(pPreço);
            if (preço < 2000) {
                throw new Exception("Informe um valor realista.");
            }
        } else {
            throw new Exception("Informe o preço do imóvel.");
        }

        if (pData.isEmpty()) {
            throw new Exception("Informe a data do imóvel.");
        }

        //validação dos campos String
        if (pCod.equals("")) {
            throw new Exception("Informe o código do imóvel.");
        }

        if (pTipo.equals("")) {
            throw new Exception("Informe o tipo do imóvel.");
        }

        if (pDescrição.equals("")) {
            throw new Exception("Informe a descrição do imóvel.");
        }

        if (pNomeProp.equals("")) {
            throw new Exception("Informe o nome do proprietário.");
        }

        vecImovel.add(new Imovel(pCod, pTipo, pDescrição, pNomeProp, preço, new Date(pData)));
        tableImoveisModel.addRow(new Object[]{pCod, pTipo, pPreço, pNomeProp});
        salva();

    }

    //Metodo que tentara o salvar os dados no arquivo, caso não consiga irá mostrar uma mensagem de erro 
    private void salva() {
        try {
            serializaImovel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar o arquivo", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void instTableCorretoresModel() {

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
            tableImoveisModel.addRow(new Object[]{i.getCodigo(), i.getTipo(), String.valueOf(i.getPreço()), i.getNomePropietario()});
        }
    }

    public DefaultTableModel getTableCorretoresModel() {
        return tableImoveisModel;
    }

    public void finalize() throws Exception {
        serializaImovel();
    }

}

package model;

import java.io.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Imovel implements Serializable{

    private String codigo;
    private String tipo;
    private String descricao;
    private String nomePropietario;
    private float preco;
    private Date dataCad;

    public Imovel(String pCod, String pTipo, String pDescricao, String pNomePropietario, float pPreco, String pDataCad) throws Exception {
        
        if (pCod.isEmpty()) {//Validando informações recibidas no argumento
            throw new Exception("Informe o código do imóvel.");
        }
        if (pTipo.equals(" ")) {
            throw new Exception("Informe o tipo do imóvel.");
        }
        if(pDataCad.isEmpty()){
            throw new Exception("Informe a data de entrada.");
        }
                
        codigo = pCod;
        tipo = pTipo;
        this.setNomePropietario(pNomePropietario);
        this.setDescricao(pDescricao);        
        this.setPreco(pPreco);
        this.setDataCad(pDataCad);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String pDescricao) throws Exception {        
        if (pDescricao.equals("")) {//Validando dados de entrada
            throw new Exception("Informe a descrição do imóvel.");
        }
        
        this.descricao = pDescricao;
    }

    public String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(String pNomePropietario) throws Exception {
        
        if (pNomePropietario.length()<2) {//Validando dados de entrada
            throw new Exception("Informe o nome do proprietário.");
        }
        
        this.nomePropietario = pNomePropietario;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float pPreco) throws Exception {        
        if (pPreco < 2000) {//Validando dados de entrada
            throw new Exception("Informe um valor realista.");
        }        
        this.preco = pPreco;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        Locale local = new Locale("pt","Br");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
        try {
            this.dataCad = df.parse(dataCad);
        } catch (ParseException ex) {
            Logger.getLogger(Imovel.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

}

package model;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

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
        dataCad = new Date(pDataCad);
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

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

}

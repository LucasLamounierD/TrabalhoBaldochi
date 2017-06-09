package model;


import java.util.*;

public class Imovel {

    private String codigo;
    private String tipo;
    private String descricao;
    private String nomePropietario;
    private float preço;
    private Date dataCad;

    public Imovel(String pCod, String pTipo, String pDescricao, String pNomePropietario, float pPreço, Date pDataCad) {
        codigo = pCod;
        tipo = pTipo;
        descricao = pDescricao;
        nomePropietario = pNomePropietario;
        preço = pPreço;
        dataCad = pDataCad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

}

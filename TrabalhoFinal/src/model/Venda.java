package model;


import java.io.Serializable;
import model.Corretor;
import java.util.*;

public class Venda implements Serializable{

    private float valorReal;
    private String nomeComprador;
    private Date dataVenda;
    private Corretor nomeCorretor;
    private Imovel imovelVendido;

    public Venda(Imovel pImovelVendido,Corretor pNomeCorretor, String pNomeComprador, Date pDataVenda, float pValorReal) {
        valorReal = pValorReal;
        nomeComprador = pNomeComprador;
        dataVenda = pDataVenda;
        nomeCorretor = pNomeCorretor;
        imovelVendido = pImovelVendido;
    }

    public float getValorReal() {
        return valorReal;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Corretor getNomeCorretor() {
        return nomeCorretor;
    }
    
    public Imovel getImovelVendido() {
        return imovelVendido;
    }

}

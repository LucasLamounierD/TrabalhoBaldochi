package model;


import model.Corretor;
import java.util.*;

public class Venda {

    private float valorReal;
    private String nomeComprador;
    private Date dataVenda;
    private Corretor nomeCorretor;

    public Venda(Corretor pNomeCorretor, String pNomeComprador, Date pDataVenda, float pValorReal) {
        valorReal = pValorReal;
        nomeComprador = pNomeComprador;
        dataVenda = pDataVenda;
        nomeCorretor = pNomeCorretor;
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

}

package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import model.Corretor;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Venda implements Serializable {

    private float valorReal;
    private String nomeComprador;
    private Date dataVenda;
    private Corretor nomeCorretor;
    private Imovel imovelVendido;

    public Venda(Imovel pImovelVendido, Corretor pNomeCorretor, String pNomeComprador, String pDataVenda, float pValorReal) {
        valorReal = pValorReal;
        nomeComprador = pNomeComprador;
        setDataVenda(pDataVenda);
        nomeCorretor = pNomeCorretor;
        imovelVendido = pImovelVendido;
    }

    public void setDataVenda(String pDataVenda) {
        Locale local = new Locale("pt", "Br");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
        try {
            this.dataVenda = df.parse(pDataVenda);
        } catch (ParseException ex) {
            Logger.getLogger(Imovel.class.getName()).log(Level.SEVERE, null, ex);
        }

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

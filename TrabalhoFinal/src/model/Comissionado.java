package model;


import java.io.*;


public class Comissionado extends Corretor {

    private float comissao;

    public Comissionado(String pNome, String pCrecic,float pComissao) throws Exception {
        super(pNome, pCrecic);
        this.setComissao(pComissao);
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float pComissao) throws Exception {
        if (pComissao<1 || pComissao>3){
            throw new Exception("Valor Invalido no campo Comissão!"); 
        }
        
        this.comissao = pComissao;
    }

}

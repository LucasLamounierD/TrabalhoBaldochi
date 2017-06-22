package model;


import java.io.*;


public class Comissionado extends Corretor {

    private float comissao;

    public Comissionado(String pNome, String pCrecic,float pComissao) throws Exception {
        super(pNome, pCrecic);
        
        if (pComissao<1 || pComissao>3){
            throw new Exception("Valor Invalido no campo Comissão!"); 
        }

        comissao = pComissao;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

}

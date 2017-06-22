package model;


import java.util.*;

public class Contratado extends Corretor {

    private  float salarioFixo;
    private Date dataAdmissao;
    private static float comissao = 1 / 100;

    public Contratado(String pNome,String pCrecic, float pSalarioFixo, String pDataAdmissao) throws Exception{
        super(pNome,pCrecic);
        
        if (pDataAdmissao.isEmpty()){
            throw new Exception("Preecha campo Data de admissão com um valor valido!"); 
        }else if(pSalarioFixo<900){
            throw new Exception("Preecha campo Valor Salario com um valor valido!"); 
        }
        
        
        salarioFixo = pSalarioFixo;
        dataAdmissao = new Date(pDataAdmissao);        
    }

    public float getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(float salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

}

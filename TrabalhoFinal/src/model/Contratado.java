package model;


import java.util.*;

public class Contratado extends Corretor {

    private  float salarioFixo;
    private Date dataAdmissao;
    private static float comissao = 1 / 100;

    public Contratado(String pNome,String pCrecic, float pSalarioFixo, Date pDataAdmissao) throws Exception{
        super(pNome,pCrecic);
 
        this.setSalarioFixo(pSalarioFixo);
        dataAdmissao = pDataAdmissao;        
    }

    public float getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(float salarioFixo) throws Exception {
        if(salarioFixo<900){
            throw new Exception("Preecha campo Valor Salario com um valor valido!"); 
        }       
        this.salarioFixo = salarioFixo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    
}

package model;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contratado extends Corretor {

    private  float salarioFixo;
    private Date dataAdmissao;
    private static float comissao = 1 / 100;

    public Contratado(String pNome,String pCrecic, float pSalarioFixo, String pDataAdmissao) throws Exception{
        super(pNome,pCrecic);
 
        this.setSalarioFixo(pSalarioFixo);
        this.setDataAdmissao(pDataAdmissao);
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

    public void setDataAdmissao(String pDataAdmissao) {
        Locale local = new Locale("pt","Br");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
        
        try {
            this.dataAdmissao = df.parse(pDataAdmissao);
        } catch (ParseException ex) {
            Logger.getLogger(Contratado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

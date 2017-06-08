
import java.util.*;

public class Contratado extends Corretor {

    public float salarioFixo;
    public Date dataAdmissao;
    public static float comissao = 1 / 100;

    public Contratado(String pNome,String pCrecic, float pSalarioFixo, Date pDataAdmissao){

        super(pNome,pCrecic);
        salarioFixo = pSalarioFixo;
        dataAdmissao = pDataAdmissao;
        
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


import java.io.*;


public class Comissionado extends Corretor implements Serializable{

    float comissao;

    public Comissionado(String pNome, String pCrecic,float pComissao) {
        super(pNome, pCrecic);
        comissao = pComissao;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

}

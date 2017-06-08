
import java.util.*;

public class Venda {

    float valorReal;
    String nomeComprador = new String("");
    Date dataVenda;
    Corretor nomeCorretor;

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

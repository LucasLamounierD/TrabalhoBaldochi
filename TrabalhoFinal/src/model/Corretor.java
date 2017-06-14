package model;

import java.io.Serializable;

public class Corretor implements Serializable {

    private String nome;
    private String crecic;

    public Corretor(String pNome, String pCrecic) {
        nome = pNome;
        crecic = pCrecic;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrecic() {
        return crecic;
    }

    public void setCrecic(String crecic) {
        this.crecic = crecic;
    }

}

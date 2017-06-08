
public class Corretor {

    String nome = new String("");
    String crecic = new String("");

    public Corretor(String pNome,String pCrecic) {

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

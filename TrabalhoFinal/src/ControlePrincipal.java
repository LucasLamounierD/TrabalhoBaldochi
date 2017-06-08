
import javax.swing.JOptionPane;

public class ControlePrincipal {

    private ControleCorretor objControleCorretor;
    private ControleImovel objControleImovel;
    private ControleVendas objControleVendas;

    public ControlePrincipal() {
        try {
            objControleCorretor = new ControleCorretor();
            objControleImovel = new ControleImovel();
            objControleVendas = new ControleVendas();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }

    }

    public boolean cadastraCorretorComissionado(Comissionado c) {

        if (c != null && c.getNome() != "" && c.getCrecic() != "" && c.getComissao() != 0.0f){
        
        objControleCorretor.cadComissionado(c);
        
        return true;
        
        }else
            
            return false;

    }

//    public ControleCorretor getObjControleCorretor() {
//        return objControleCorretor;
//    }
//
//    public ControleImovel getObjControleImovel() {
//        return objControleImovel;
//    }
//
//    public ControleVendas getObjControleVendas() {
//        return objControleVendas;
//    }

    public void finalize() {
        try {
            objControleCorretor.finalize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

}

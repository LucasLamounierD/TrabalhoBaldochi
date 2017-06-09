package control;


import limit.LimitePrincipal;
import control.ControleCorretor;
import model.Comissionado;
import javax.swing.JOptionPane;

public class ControlePrincipal {
    private LimitePrincipal objLimPrincipal;
    
    private ControleCorretor objControleCorretor;
    private ControleImovel objControleImovel;
    private ControleVendas objControleVendas;

    public ControlePrincipal() {   
        objLimPrincipal = new LimitePrincipal(this);
        try {
            objControleCorretor = new ControleCorretor();
            objControleImovel = new ControleImovel();
            objControleVendas = new ControleVendas();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }

       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                objLimPrincipal = new LimitePrincipal(this);
                objLimPrincipal.setVisible(true);
            }
        });*/
        
        objLimPrincipal.setVisible(true);
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
    
    public static void main (String [] args){
        ControlePrincipal main = new ControlePrincipal();
    }

}

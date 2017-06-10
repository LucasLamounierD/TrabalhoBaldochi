package control;

import control.ControleCorretor;
import model.Comissionado;
import javax.swing.JOptionPane;
import limit.MainWindow;
import util.Util;

public class ControlePrincipal {
    private MainWindow objLimPrincipal;
    
    private ControleCorretor objControleCorretor;
    private ControleImovel objControleImovel;
    private ControleVendas objControleVendas;

    public ControlePrincipal() {   
        objLimPrincipal = new MainWindow(this);//Instacia a janela(limite)
        
        try{
         objControleCorretor = new ControleCorretor();
        }catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        try {//Instacia Controles
            objControleCorretor = new ControleCorretor();
            objControleImovel = new ControleImovel();
            objControleVendas = new ControleVendas();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        
        objLimPrincipal.setVisible(true);//Deixa janela visivel
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaCadastro(int janela){
        if(janela == Util.CADASTRO_COMISSIONADO){//Se for comissionado
            objControleCorretor.abrirJanelaCadastro(Util.CADASTRO_COMISSIONADO); 
        }
    }

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

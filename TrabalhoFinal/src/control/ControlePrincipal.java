package control;

import control.ControleCorretor;
import javax.swing.JOptionPane;
import limit.MainWindow;
import util.Util;

public class ControlePrincipal {
    private MainWindow objLimPrincipal;    
    private ControleCorretor objControleCorretor;
    private ControleImovel objControleImovel;
    private ControleVendas objControleVendas;

    public ControlePrincipal() {   
        try{
         objControleCorretor = new ControleCorretor(this);
         objControleImovel = new ControleImovel(this);
        }catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        try {//Instacia Controles
         //   objControleCorretor = new ControleCorretor();
            //objControleImovel = new ControleImovel();
            //objControleVendas = new ControleVendas();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        
        objLimPrincipal = new MainWindow(this);//Instacia a janela(limite)
        objLimPrincipal.setVisible(true);//Deixa janela visivel
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaCadastro(int janela){
        objControleCorretor.abrirJanelaCadastro(janela);        
    }

    public void updateTableCorretores() {//Metodo que atualiza a tabela de corrretores
        objLimPrincipal.preencheTabelaCorretores();
    }

    public void finalize() {
        try {
            objControleCorretor.finalize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void abrirJanelaCadastroImovel(){
        
        objControleImovel.abrirJanelaCadastroImovel();
        
    }
    
    public static void main (String [] args){
        ControlePrincipal main = new ControlePrincipal();
    }

    public ControleCorretor getObjControleCorretor() {
        return objControleCorretor;
    }

    public ControleImovel getObjControleImovel() {
        return objControleImovel;
    }

    public ControleVendas getObjControleVendas() {
        return objControleVendas;
    }

    
    

}

package control;

import control.ControleCorretor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import limit.MainWindow;
import util.Util;

public class ControlePrincipal {
    private MainWindow objLimPrincipal;    
    private ControleCorretor objControleCorretor;
    private ControleImovel objControleImovel;
    private ControleVendas objControleVendas;

    public ControlePrincipal() {   
        try {//Instacia Controles
            objControleCorretor = new ControleCorretor(this);
            objControleImovel = new ControleImovel(this);
            objControleVendas = new ControleVendas();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        
        objLimPrincipal = new MainWindow(this);//Instacia a janela(limite)
        initTableCorretores();
        objLimPrincipal.setVisible(true);//Deixa janela visivel
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaCadastro(int janela){
        objControleCorretor.abrirJanelaCadastro(janela);        
    }

    public void initTableCorretores() {
        //Recebe do controller corretor a model da tabela
        DefaultTableModel tableCorretoresModel = objControleCorretor.getTableCorretoresModel();
        objLimPrincipal.setModelTableCorretores(tableCorretoresModel);
        //defini como model da tabela a model recebida do controller corretor.
    }

    public void finalize() {
        try {
            objControleCorretor.finalize();
            objControleImovel.finalize();
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

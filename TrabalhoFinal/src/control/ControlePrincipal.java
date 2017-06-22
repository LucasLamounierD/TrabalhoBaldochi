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
            objControleVendas = new ControleVendas(this);
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
        
        objLimPrincipal = new MainWindow(this);//Instacia a janela(limite)
        initTableCorretores();
        initTableImoveis();
        objLimPrincipal.setVisible(true);//Deixa janela visivel
    }
    
    //Inicializa campos da yabela de Imoveis
    public void initTableImoveis(){
        //Recebe do controller imovel a model da tabela
        DefaultTableModel tableImoveisModel = objControleImovel.getTableCorretoresModel();
        objLimPrincipal.setModelTableImoveis(tableImoveisModel);
        //defini como model da tabela a model recebida do controller imovel.
        
    }

    //Inicializa campos da tabela de Corretores
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
            objControleVendas.finalize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaCadastroCorretor(int janela){
        objControleCorretor.abrirJanelaCadastro(janela);        
    }
    
    public void abrirJanelaCadastroImovel(){
        objControleImovel.abrirJanelaCadastroImovel();
    }
    
    public void abrirJanelaCadastroVenda(){
        objControleVendas.abrirJanelaVenda();
    }
    
    public void abrirJanelaEditorImoveis(int selectedRow) {
        objControleImovel.abrirJanelaCadastroImovel();
    }
    
    public void abrirJanelaRealizarPagamento(){
        objControleVendas.abrirJanelaPagamento();
    }
    
    public void abrirJanelaFormFaturamento(){
        objControleVendas.calculaFaturamento();
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaEditorCorretor(int linhaIndex){
        objControleCorretor.abrirJanelaEditar(linhaIndex);        
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

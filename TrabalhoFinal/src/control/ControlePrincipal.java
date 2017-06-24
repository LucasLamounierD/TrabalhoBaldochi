package control;

import control.ControleCorretor;
import java.util.Vector;
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
            System.out.println("Erro na abertura de arquivo!");
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
       //defini como model da tabela a model recebida do controle imovel.
        objLimPrincipal.setModelTableImoveis(tableImoveisModel);
        //Carregando tipos de Imoveis
        objLimPrincipal.setTipoDeImoveis(objControleImovel.getComboBoxTipoImoveisDispModel());
    }
    
    public void removeImovel(String valueAt) {
        objControleImovel.removeImovel(valueAt);
    }

    //Inicializa campos da tabela de Corretores
    public void initTableCorretores() {
        //Recebe do controller corretor a model da tabela
        DefaultTableModel tableCorretoresModel = objControleCorretor.getTableCorretoresModel();
        //defini como model da tabela a model recebida do controller corretor.
        objLimPrincipal.setModelTableCorretores(tableCorretoresModel);
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
    
    public void abrirJanelaEditorImoveis(String selectedRow) {
        objControleImovel.abrirJanelaEditorImovel(selectedRow);
    }
    
    public void abrirJanelaRealizarPagamento(){
        objControleVendas.abrirJanelaPagamento();
    }
    
    public void abrirJanelaFormFaturamento(){
        //ABRE A JANELA PARA MOSTRAR O FATURAMENTO DE UM MES
        objControleVendas.janelaFaturamento(1);//O NUMERO 1 É UTILIZADO PARA SELEÇÃO
                                               //DA JANELA NO LIMITE
    }
    
    //Gerencia qual opção de menu o usuario acionou e chama o controle responsavel 
    public void abrirJanelaEditorCorretor(int linhaIndex){
        objControleCorretor.abrirJanelaEditar(linhaIndex);        
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

    public MainWindow getObjLimPrincipal() {
        return objLimPrincipal;
    }    
    
    
    public static void main (String [] args){
        ControlePrincipal main = new ControlePrincipal();
    }

    

    

    


}

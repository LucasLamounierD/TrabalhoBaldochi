package control;

import model.Venda;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import limit.*;
import model.*;
import util.Util;

public class ControleVendas {

    //Declaração das variavéis 
    private Venda entVenda;
    private ArrayList<Venda> listaVenda;
    private LimiteVendas limVendas;
    private LimiteFormularios objLimiteFormulario;
    private ControlePrincipal ctrPrincipal;
    private LimitePagamento limPag;

    //Controle de Vendas
    public ControleVendas(ControlePrincipal pCtrPrincipal) throws Exception {
        listaVenda = new ArrayList<Venda>();
        ctrPrincipal = pCtrPrincipal;
        limVendas = new LimiteVendas(this);
        limPag = new LimitePagamento(this);
        desserializaVenda();
    }

      //Metodo que deixará a view visível
    public void abrirJanelaVenda() {
        limVendas.iniciaArrays(ctrPrincipal.getObjControleImovel().getVecImovel(), ctrPrincipal.getObjControleCorretor().getVecCorretor());
        limVendas.setVisible(true);
    }

    public void abrirJanelaPagamento() {
        limPag.iniciaArrays(ctrPrincipal.getObjControleCorretor().getVecCorretor());
        limPag.setVisible(true);
    }


    //Metodo que será o responsável por pegar os dados recebidos na view e fazer a verificação dos mesmos, e coloca-los no arraylist de vendas, que posteriormente será serializado
    public void cadVenda(int pIndexCodImovel, int pIndexCorretor, String pNome, String pData, String pPreco) throws Exception {
        //declarando variaveis auxiliares para conversao e cadastro
        float preco = 0;

        if (!pPreco.isEmpty()) {
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            preco = nf.parse(pPreco).floatValue();
            if (preco < 2000) {
                throw new Exception("Informe um valor realista.");
            }
        } else {
            throw new Exception("Informe o preço do imóvel.");
        }

        if (pData.isEmpty()) {
            throw new Exception("Informe a data do imóvel.");
        }

        if (pNome.equals("")) {
            throw new Exception("Informe o nome do proprietário.");
        }

        Corretor corretor = (Corretor) ctrPrincipal.getObjControleCorretor().getVecCorretor().elementAt(pIndexCorretor);
        Imovel imovel = (Imovel) ctrPrincipal.getObjControleImovel().getVecImovel().elementAt(pIndexCodImovel);
        //No momento em que cadastrar uma venda automaticamente irá retirar da lista de imóveis o imóvel vendido
        
        listaVenda.add(new Venda(imovel,corretor,pNome,pData, preco));
        ctrPrincipal.getObjControleImovel().removeImovel(imovel.getCodigo());
        salva();
    }

    //Metodo que calcula o salário mensal de um corretor
    public double pagCorretorMes(int pMes, int pAno, Corretor pCorretor) {
        double salarioMensal = 0;
        //Vai percorrer a lista de vendas
        for (Venda v : listaVenda) {
            //Recebe a data da venda e a transforma em int para poder realizar a comparação
            Date data = v.getDataVenda();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(data.getTime()));
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH)+1;

            if (ano == pAno && pCorretor.getNome().equals(v.getNomeCorretor().getNome())) {
                //Caso o mes seja igual ao da venda calcula para comissionado e para contratado
                if (mes == pMes) {
                    if (pCorretor instanceof Comissionado) {
                        salarioMensal += v.getValorReal() * ((Comissionado) pCorretor).getComissao()/100;
                    } else {
                        salarioMensal += v.getValorReal() * (0.01);
                    }
                }
            }
        }

        //Adiciona o salário fixo caso o corretor seja contratado
        if (pCorretor instanceof Contratado) {
            salarioMensal += ((Contratado) pCorretor).getSalarioFixo();
        }

        return salarioMensal;
    }

    //Metodo que calcula o salário anual de um corretor
    public double pagCorretorAnual(int pMes, int pAno, Corretor pCorretor) {
        double salarioAnual = 0;
        
        //Vai percorrer a lista de vendas
        for (Venda v : listaVenda) {
            //Recebe a data da venda e a transforma em int para poder realizar a comparação
            Date data = v.getDataVenda();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(data.getTime()));
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH)+1;
            if (ano == pAno && pCorretor.getNome().equals(v.getNomeCorretor().getNome())) {
                 //Aqui realiza a soma do vendedor para saber seus ganhos anuais
                if (pCorretor instanceof Comissionado) {
                    salarioAnual += v.getValorReal() * ((Comissionado) pCorretor).getComissao()/100;
                } else {
                    salarioAnual += v.getValorReal() * (0.01);
                }
            }
        }
        
         //Adiciona o salário fixo caso o corretor seja contratado
        if (pCorretor instanceof Contratado) {
            salarioAnual += pMes * ((Contratado) pCorretor).getSalarioFixo();
        }
        
        return salarioAnual;
    }

    //Metodo que irá serializar os dados de venda e irá coloca-los no arquivo vendas.dat 
    private void serializaVenda() throws Exception {
        //Vai realizar as conversões necessárias para conseguir escrever os dados que estão na listaVenda
        FileOutputStream objFileOS = new FileOutputStream("vendas.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaVenda);
        objOS.flush();
        objOS.close();
    }

    //Metodo que desserializará os dados do arquivo vendas.dat
    private void desserializaVenda() throws Exception {
        File objFile = new File("vendas.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("vendas.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaVenda = (ArrayList<Venda>) objIS.readObject();
            objIS.close();
        }
    }

    //Metodo que tentará serializar, caso não de irá tratar a exceção
    private void salva() {
        try {
            serializaVenda();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha na serialização", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void janelaFaturamento(String pFrame) {
        objLimiteFormulario = new LimiteFormularios(this);
        objLimiteFormulario.setWhichReportView(Util.REL_FATURAMENTO_TOTAL);
    }

    public float buscaVendasMes(int pMes, int pAno, JTable tabelaVenda) {

        ArrayList<Venda> vendasMes = new ArrayList();
        float valorVendas = 0;

        //ADICIONA AS VENDAS QUE SÃO DO MES E ANO INFORMADO A UM ARRAY TEMPORARIO
        for (Venda v : listaVenda) {
            System.out.println(v.getDataVenda());
            if (((v.getDataVenda().getYear() + 1900) == pAno) && ((v.getDataVenda().getMonth()) == pMes)) {
                System.out.println("+"+v.getValorReal());
                vendasMes.add(v);
                valorVendas += v.getValorReal();//FAZ O CALCULO DO VALOR TOTAL DE VENDAS PARA EXIBIÇÃO

            }

        }

        //SETA O MODELO DA TABELA PARA INSERÇÃO DAS VENDAS
        DefaultTableModel t = (DefaultTableModel) tabelaVenda.getModel();

        //LIMPA O QUE HAVIA NA TABELA PASSADA PARA RENOVAR OS VALORES
        t.setNumRows(0);

        //ADICIONA NA TABELA AS VENDAS DO MES QUE ESTAO NO ARRAY AUXILIAR
        for (Venda v : vendasMes) {
            t.addRow(new Object[]{v.getImovelVendido().getCodigo(), v.getNomeCorretor().getNome(), v.getValorReal()});
        }
        //t.addRow(new Object[]{"foi", "foi", "foi"});
        return valorVendas;//RETORNA O VALOR TOTAL DAS VENDAS PARA EXIBIR COMO TOTAL NO PAINEL

    }

    public void finalize() throws Exception {
        serializaVenda();
    }

    //Metodo get de venda
    public Venda getEntVenda() {
        return entVenda;
    }

    //Metodo get do arraylist de venda
    public ArrayList getArrayListVenda() {
        return listaVenda;
    }

    public ControlePrincipal getCtrPrincipal() {
        return ctrPrincipal;
    }

}

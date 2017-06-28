package control;

import model.Venda;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import limit.*;
import model.*;
import util.MyTableModel;

public class ControleVendas {

    //Declaração das variavéis 
    private Venda entVenda;
    private ArrayList<Venda> listaVenda;
    private LimiteVendas limVendas;
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

        listaVenda.add(new Venda(imovel, corretor, pNome, pData, preco));
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
            int mes = cal.get(Calendar.MONTH) + 1;

            if (ano == pAno && pCorretor.getNome().equals(v.getNomeCorretor().getNome())) {
                //Caso o mes seja igual ao da venda calcula para comissionado e para contratado
                if (mes == pMes) {
                    if (pCorretor instanceof Comissionado) {
                        salarioMensal += v.getValorReal() * ((Comissionado) pCorretor).getComissao() / 100;
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
            int mes = cal.get(Calendar.MONTH) + 1;
            if (ano == pAno && pCorretor.getNome().equals(v.getNomeCorretor().getNome())) {
                //Aqui realiza a soma do vendedor para saber seus ganhos anuais
                if (pCorretor instanceof Comissionado) {
                    salarioAnual += v.getValorReal() * ((Comissionado) pCorretor).getComissao() / 100;
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

    //Metodo para retornar o valor pago a todos os corretores para calculo do lucro
    public float calcularLucroTotal(int pMes, int pAno, JTable tabelaModelo) {

        float valorTotalSalarios = 0;
        float valorTotalFaturamento = 0;
        Corretor c;

        for (Venda v : listaVenda) {

            //ENTRA AQUI SE OS MESES E ANOS CORRESPONDEREM AOS DA PESQUISA
            if (v.getDataVenda().getMonth() == pMes && v.getDataVenda().getYear() + 1900 == pAno) {

                c = v.getNomeCorretor();

                //ANALISA QUAL TIPO DE CORRETOR, PARA FAZER OS CALCULOS DO VALOR TOTAL
                if (c instanceof Comissionado) {
                    valorTotalSalarios += v.getValorReal() * (((Comissionado) c).getComissao() / 100);
                }
                if (c instanceof Contratado) {
                    valorTotalSalarios += ((Contratado) c).getSalarioFixo() + (0.01 * v.getValorReal());
                }

            }

        }

        for (Venda v : listaVenda) {
            if (((v.getDataVenda().getYear() + 1900) == pAno) && ((v.getDataVenda().getMonth()) == pMes)) {
                valorTotalFaturamento += (v.getValorReal() * 5) / 100;//FAZ O CALCULO DO VALOR TOTAL DE VENDAS PARA EXIBIÇÃO
            }
        }

        MyTableModel t = new MyTableModel();

        t.addColumn("Codigo");
        t.addColumn("Tipo");
        t.addColumn("Valor Real");
        t.addColumn("Valor Faturado");
        t.addColumn("Valor pago Corretor");

        for (Venda v : listaVenda) {

            c = v.getNomeCorretor();

            if (c instanceof Comissionado) {
                t.addRow(new Object[]{v.getImovelVendido().getCodigo(), v.getImovelVendido().getTipo(),
                    v.getValorReal(), (v.getValorReal() * 5 / 100), (v.getValorReal()*((Comissionado) c).getComissao()/100)});
            }
            if (c instanceof Contratado) {
                t.addRow(new Object[]{v.getImovelVendido().getCodigo(), v.getImovelVendido().getTipo(),
                    v.getValorReal(), (v.getValorReal() * 5 / 100), (v.getValorReal()*0.01)});
            }

        }

        tabelaModelo.setModel(t);

        return valorTotalFaturamento - valorTotalSalarios;

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
    
    public float buscaVendasMes(int pMes, int pAno, JTable tabelaVenda) {
        ArrayList<Venda> vendasMes = new ArrayList();
        float valorVendas = 0;
        //ADICIONA AS VENDAS QUE SÃO DO MES E ANO INFORMADO A UM ARRAY TEMPORARIO
        for (Venda v : listaVenda) {
            if (((v.getDataVenda().getYear() + 1900) == pAno) && ((v.getDataVenda().getMonth()) == pMes)) {
                vendasMes.add(v);
                valorVendas += (v.getValorReal() * 5) / 100;//FAZ O CALCULO DO VALOR TOTAL DE VENDAS PARA EXIBIÇÃO
            }
        }

        //INSTANCIA UM MODELO DA TABELA PARA INSERÇÃO DAS VENDAS
        MyTableModel t = new MyTableModel();

        t.addColumn("Codigo Imovel");
        t.addColumn("Nome do Corretor");
        t.addColumn("Valor Real");
        t.addColumn("Valor do Faturamento");

        //LIMPA O QUE HAVIA NA TABELA PASSADA PARA RENOVAR OS VALORES
        t.setNumRows(0);

        //ADICIONA NA TABELA AS VENDAS DO MES QUE ESTAO NO ARRAY AUXILIAR
        for (Venda v : vendasMes) {
            t.addRow(new Object[]{v.getImovelVendido().getCodigo(), v.getNomeCorretor().getNome(),
                v.getValorReal(), (v.getValorReal() * 5 / 100)});
        }
        tabelaVenda.setModel(t);
        return valorVendas;//RETORNA O VALOR TOTAL DAS VENDAS PARA EXIBIR COMO TOTAL NO PAINEL
    }
    
    //Metodo que ira criar a Table com os imóveis vendidos 
    public void buscaImoveisVendidos(int pMes, int pAno, JTable tabelaVenda) {
        MyTableModel modelTable = new MyTableModel();
        //Adiciona as colunas
        modelTable.addColumn("Codigo Imovel");
        modelTable.addColumn("Tipo do Imovel");
        modelTable.addColumn("Nome Prop.");
        modelTable.addColumn("Valor Original");
        modelTable.addColumn("Nome Comprador");
        modelTable.addColumn("Nome do Corretor");
        modelTable.addColumn("Valor Real");
        //Formatação do valor
        DecimalFormat decFor = new DecimalFormat("R$ 0.00");//Classe para conversão decimal
        //Adiciona os imóveis na tabela
        for (Venda v : listaVenda) {
            if (((v.getDataVenda().getYear() + 1900) == pAno) && ((v.getDataVenda().getMonth()) == pMes)) {
                modelTable.addRow(new Object[]{v.getImovelVendido().getCodigo(),
                    v.getImovelVendido().getTipo(),
                    v.getImovelVendido().getNomePropietario(),
                    decFor.format(v.getImovelVendido().getPreco()),
                    v.getNomeComprador(),
                    v.getNomeCorretor().getNome(),
                    decFor.format(v.getValorReal())});
            }
        }
        tabelaVenda.setModel(modelTable);
    }
    
    //Metodo para calcular o faturamento de um corretor para certo mês
    public double calculaFaturamentoCorretorMes(int pMes, int pAno, Corretor pCorretor) {
        double faturamento = 0;
        //Vai percorrer a lista de vendas
        for (Venda v : listaVenda) {
            //Recebe a data da venda e a transforma em int para poder realizar a comparação
            Date data = v.getDataVenda();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(data.getTime()));
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);

            if (ano == pAno && pCorretor.getNome().equals(v.getNomeCorretor().getNome())) {
                //Caso o mes seja igual ao da venda calcula para comissionado e para contratado
                if (mes == pMes) {
                    faturamento += v.getValorReal() * 5 / 100;
                }
            }
        }

        return faturamento;
    }
    
    //Metodo para a criação da Table de faturamento de cada Corretor
    public void faturamentoCadaCorretor(int pMes, int pAno, JTable tabelaCorretor) {
        MyTableModel table = new MyTableModel();
        //Adiciona as colunas
        table.addColumn("CRECIC");
        table.addColumn("Corretor");
        table.addColumn("Valor");
        
        DecimalFormat decFor = new DecimalFormat("R$ 0.00");//Classe para conversão decimal
        //Adiciona os corretores a cada linha
        for (Object c : ctrPrincipal.getObjControleCorretor().getVecCorretor()) {
            table.addRow(new Object[]{((Corretor) c).getCrecic(),
                ((Corretor) c).getNome(),
                decFor.format(calculaFaturamentoCorretorMes(pMes, pAno, ((Corretor) c)))});
        }
        
        tabelaCorretor.setModel(table);
    }
    
    //Metodo para valor pago para cadas corretor
    public void valorPagoCorretor(int pMes, int pAno, JTable tabelaCorretor) {
        MyTableModel table = new MyTableModel();
        //Adiciona as colunas
        table.addColumn("CRECIC");
        table.addColumn("Corretor");
        table.addColumn("Valor Pago");
        DecimalFormat decFor = new DecimalFormat("R$ 0.00");//Classe para conversão decimal
        //Adiciona os corretores
        for (Object c : ctrPrincipal.getObjControleCorretor().getVecCorretor()) {
            table.addRow(new Object[]{((Corretor) c).getCrecic(),
                ((Corretor) c).getNome(),
                decFor.format(pagCorretorMes(pMes + 1, pAno, ((Corretor) c)))});
        }

        tabelaCorretor.setModel(table);
    }
    
    //Metodo para obter o corretor do mês
    public Corretor corretorDoMes(int pMes, int pAno, JTable tabelaCorretor) {

        MyTableModel table = new MyTableModel();
        float faturamentoMaior = 0;
        Corretor funcDoMes = null;
        //Adiciona as colunas
        table.addColumn("Tipo");
        table.addColumn("Valor da venda");
        table.addColumn("Data da venda");
        table.addColumn("Comprador");
        DecimalFormat decFor = new DecimalFormat("R$ 0.00");//Classe para conversão decimal
        //Obtem o vendedor do mês
        for (Object c : ctrPrincipal.getObjControleCorretor().getVecCorretor()) {

            if (calculaFaturamentoCorretorMes(pMes, pAno, (Corretor) c) > faturamentoMaior) {

                faturamentoMaior = (float) calculaFaturamentoCorretorMes(pMes, pAno, (Corretor) c);
                funcDoMes = (Corretor) c;

            }

        }
        //Se não for null ele retorna os dados do corretor do mês
        if (funcDoMes != null) {

            for (Venda v : listaVenda) {

                if (v.getNomeCorretor().getCrecic().equals(funcDoMes.getCrecic())) {

                    table.addRow(new Object[]{v.getImovelVendido().getTipo(), decFor.format(v.getValorReal()),
                        v.getDataVenda().getDate() + "/" + (v.getDataVenda().getMonth() + 1) + "/" + (v.getDataVenda().getYear() + 1900),
                        v.getNomeComprador()});

                }

            }

            tabelaCorretor.setModel(table);

            return funcDoMes;

        }
        
        tabelaCorretor.setModel(table);

        return null;

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

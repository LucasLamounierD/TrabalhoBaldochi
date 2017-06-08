
import java.io.*;
import java.util.*;

public class ControleVendas {

    private Venda entVenda;
    private Vector vecVenda = new Vector();

    public ControleVendas() {

    }

    private void serializaVenda() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("vendas.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecVenda);
        objOS.flush();
        objOS.close();
    }

    private void desserializaVenda() throws Exception {
        File objFile = new File("vendas.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("vendas.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecVenda = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void salva() {

        try {
            serializaVenda();
        } catch (Exception e) {
            System.out.println("Erro ao manipular arquivo.\n");
        }

    }

    public Venda getEntVenda() {
        return entVenda;
    }

    public Vector getVecVenda() {
        return vecVenda;
    }

}

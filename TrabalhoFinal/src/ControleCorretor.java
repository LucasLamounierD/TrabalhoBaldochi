
import java.io.*;
import java.util.*;

public class ControleCorretor {

    private Comissionado entComissionado;
    private Contratado entContratado;
    private Vector vecCorretor = new Vector();
    private LimiteComissionado objLimiteCorretor;

    public ControleCorretor() throws Exception {
        desserializaCorretor();
    }

    public void cadComissionado(Comissionado c) {

            entComissionado = new Comissionado(c.nome,c.crecic,c.comissao);
            vecCorretor.add(entComissionado);
            salva();

    }

    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecCorretor);
        objOS.flush();
        objOS.close();
    }

    private void desserializaCorretor() throws Exception {
        File objFile = new File("corretores.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("corretores.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecCorretor = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void salva() {

        try {
            serializaCorretor();
        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo.\n");
        }

    }

    public Comissionado getEntCorretor() {
        return entComissionado;
    }

    public Vector getVecCorretor() {
        return vecCorretor;
    }

    public void finalize() throws Exception {
        serializaCorretor();
    }

}

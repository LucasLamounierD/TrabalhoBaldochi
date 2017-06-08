
import java.io.*;
import java.util.*;

public class ControleImovel {

    private Imovel entImovel;
    private Vector vecImovel = new Vector();

    public ControleImovel(){
        
        
        
    }
    
        private void serializaImovel() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecImovel);
        objOS.flush();
        objOS.close();
    }

    private void desserializaImovel() throws Exception {
        File objFile = new File("imoveis.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecImovel = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void salva() {

        try {
            serializaImovel();
        } catch (Exception e) {
            System.out.println("Erro ao manipular arquivo.\n");
        }

    }
    
    public Imovel getEntImovel() {
        return entImovel;
    }

    public Vector getVecImovel() {
        return vecImovel;
    }
    
}

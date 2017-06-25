package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    public final static int CADASTRO_COMISSIONADO = 1;
    public final static int CADASTRO_CONTRATADO = 0;
    public final static int OP_CREATE = 0;
    public final static int OP_EDIT = 1;
    public final static String FATURAMENTO = "Faturamento";
    public final static String LUCRO = "Lucro";
    public final static String FUNCIONARIO_DO_MES = "FunMes";
    
    public final static String REL_FATURAMENTO_TOTAL = "Faturamento Total";
    public final static String REL_LUCRO_TOTAL = "Lucro Total";
    public final static String REL_RELACAO_DE_IMOVEIS_VENDIDOS = "Relação de Imoveis Vendidos";
    public final static String REL_RELACAO_DE_IMOVEIS_ENCALHADOS = "Relação de Imoveis Encalhados";
    public final static String REL_FATURAMENTO_POR_CORRETOR = "Faturamento por Corretor";
    public final static String REL_VALOR_PAGO_PARA_CADA_CORRETOR = "O valor pago a cada corretor";
    public final static String REL_CORRETOR_DO_MES = "Corretor do Mês";
    
    //Metodo para converter String com virgula em float;
    public static float convFloatComVirgula(String valorText){
        float valor=0;
        if (!valorText.isEmpty()) {
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            try {
                valor = nf.parse(valorText).floatValue();
            } catch (ParseException ex) {
                valor=0;
            }
        } 
        return valor;
    }
}

import Compilador.GeradorDeCodigo;
import Utilitarios.Arquivos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoolCompiler {
    public static void main(String[] args) {
        if(!ValidaArgumentos(args))
            return;

        var texto = Arquivos.LerArquivo(args[0]);

        var geradorDeCodigo = new GeradorDeCodigo(texto);

        Arquivos.EscreverArquivo(args[1], geradorDeCodigo.GerarByteCode());

        System.out.println("Bytecode gerado com sucesso::" + args[1]);
    }

    private static boolean ValidaArgumentos(String[] args){
        if(args.length != 2) {
            System.out.println("numero de argumentos especificado invalido");
            return false;
        }

        Pattern padraoExtencaoCodigo = Pattern.compile(".+\\.bool");
        Pattern padraoExtencaoCompilado = Pattern.compile(".+\\.cbool");
        Matcher combinadorExtencaoCodigo = padraoExtencaoCodigo.matcher(args[0]);
        Matcher combinadorExtencaoCompilado = padraoExtencaoCompilado.matcher(args[1]);
        if(!combinadorExtencaoCodigo.find() || !combinadorExtencaoCompilado.find()) {
            System.out.println("Tipo de arquivo invalido!");
            return false;
        }

        return true;
    }
}

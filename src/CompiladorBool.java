import Utilitarios.Arquivos;

public class CompiladorBool {
    public static void main(String[] args) {
        String NomeArquivo = "Rodrigo.txt";
        Arquivos.CriarArquivo(NomeArquivo);
        Arquivos.EscreverArquivo(NomeArquivo, "Funcionou \n AAAAAAAAAAAAH \n AHHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH AAAAAAAAAAAAAAAAAAAAAAAAAH");
        System.out.println(Arquivos.LerArquivo(NomeArquivo));
    }
}

package Compilador;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeradorDeCodigo {

    private String _codigo;

    public GeradorDeCodigo(String codigo) {
        _codigo = codigo;
    }

    public String GerarByteCode(){
             GerarListaDeAnalise();
             var byteCode = GerarCodigo();

         return byteCode;
    }

    private String GerarCodigo() {
    }

    private void GerarListaDeAnalise() {
        for(int i = 0; VerificarFimDoArquivo(i);i++) {
            var charactere = _codigo.charAt(i);
            if (IgnorarCaractere(charactere))
                continue;

            Pattern padrao = Pattern.compile("^vars");
            Matcher combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()) {
                ObterDeclaracoesDeVariaveis(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^class");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterDeclaracaoDeClasse(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^method");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterDefinicaoDeMetodo(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^begin");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterNodoBegin(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^end-method");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterNodoEndMethod(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^end-class");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterNodoEndClass(_codigo.substring(combinador.end()), i);
                continue;
            }

            padrao = Pattern.compile("^main");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find()){
                ObterNodoMetodoMain(_codigo.substring(combinador.end()), i);
                continue;
            }
            padrao = Pattern.compile("^(?!class|method|begin|self|vars|end|if|return|" +
                                            "eq|ne|lt|le|gt|ge|new|main|io|end-method|end-class|" +
                                            "else|end-if)[a-zA-Z]+");
            combinador = padrao.matcher(_codigo.substring(i));
            if(combinador.find())
                ObterNodoAtribuicaoVariavel(_codigo.substring(i));
        }
    }

    private void ObterNodoAtribuicaoVariavel(String substring) {
    }

    private void ObterNodoMetodoMain(String substring, int i) {
    }

    private void ObterNodoEndClass(String substring, int i) {
    }

    private void ObterNodoEndMethod(String substring, int i) {
    }

    private void ObterNodoBegin(String substring, int i) {
    }

    private void ObterDefinicaoDeMetodo(String substring, int i) {
    }

    private void ObterDeclaracaoDeClasse(String substring, int i) {
    }

    private void ObterDeclaracoesDeVariaveis(String substring, int i) {
    }


    private boolean VerificarFimDoArquivo(int i){
        return i < _codigo.length();
    }

    private boolean IgnorarCaractere(char charactere) {
        char[] characteresIgnorados = {' ', '\n', '\r', '\t' };
        for (char characteresIgnorado : characteresIgnorados) {
            if (characteresIgnorado == charactere) {
                return true;
            }
        }
        return false;
    }
}

package Compilador;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.ListaDeAnalise.Variavel.ComandoVariavelEnums;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoDeclaracaoVariavel;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoVariavel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeradorDeCodigo {
    private NodoBase _nodoInicial;
    private NodoBase _nodoAtual;
    private int _index;
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
        for(_index = 0; VerificarFimDoArquivo(_index);_index++) {
            if (IgnorarCaractere(_codigo.charAt(_index)))
                continue;

            Pattern padrao = Pattern.compile("^vars");
            Matcher combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()) {
                ObterDeclaracoesDeVariaveis(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^class");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterDeclaracaoDeClasse(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^method");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterDefinicaoDeMetodo(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^begin");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterNodoBegin(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^end-method");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterNodoEndMethod(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^end-class");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterNodoEndClass(_codigo.substring(combinador.end()));
                continue;
            }

            padrao = Pattern.compile("^main");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find()){
                ObterNodoMetodoMain(_codigo.substring(combinador.end()));
                continue;
            }
            padrao = Pattern.compile("^(?!class|method|begin|self|vars|end|if|return|" +
                                            "eq|ne|lt|le|gt|ge|new|main|io|end-method|end-class|" +
                                            "else|end-if)[a-zA-Z]+");
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find())
                ObterNodoAtribuicaoVariavel(_codigo.substring(_index));
        }
    }

    private void ObterNodoAtribuicaoVariavel(String substring) {
    }

    private void ObterNodoMetodoMain(String substring) {
    }

    private void ObterNodoEndClass(String substring) {
    }

    private void ObterNodoEndMethod(String substring) {
    }

    private void ObterNodoBegin(String substring) {
    }

    private void ObterDefinicaoDeMetodo(String substring) {
    }

    private void ObterDeclaracaoDeClasse(String substring) {
    }

    private void ObterDeclaracoesDeVariaveis(String substring) {
        Pattern padrao = Pattern.compile("^[a-zA-Z]+]");
        var nodoDeclaracaoVariavel = new NodoDeclaracaoVariavel(_nodoAtual, ComandoVariavelEnums.COMANDO_VARIAVEL_VAR);

        for(int j = 0;substring.charAt(j) != '\n';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(_codigo.substring(j));
            if(combinador.find()){
                nodoDeclaracaoVariavel.AdicionarVariavel(new NodoVariavel(
                        substring.substring(combinador.start(),combinador.end()),
                        ComandoVariavelEnums.COMANDO_VARIAVEL_VAR,
                        nodoDeclaracaoVariavel
                ));
            }
        }
        AdicionarNodo(nodoDeclaracaoVariavel);
    }

    private void AdicionarNodo(NodoBase nodo){
        if(_nodoInicial == null){
            _nodoInicial = nodo;
            _nodoAtual = nodo;
            return;
        }

        AdicionarNodo(nodo, _nodoInicial.RetornarProximoNodo());
    }

    private void AdicionarNodo(NodoBase nodo, NodoBase proximoNodo){
        if(proximoNodo.RetornarProximoNodo() == null){
            proximoNodo.AtribuirProximoNodo(nodo);
            _nodoAtual = nodo;
            return;
        }

        AdicionarNodo(nodo, proximoNodo.RetornarProximoNodo());
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

package Compilador;

import Compilador.Gramatica.ListaDeAnalise.Classe.ComandoClasseEnums;
import Compilador.Gramatica.ListaDeAnalise.Classe.NodoClasse;
import Compilador.Gramatica.ListaDeAnalise.Metodo.ComandoMetodoEnum;
import Compilador.Gramatica.ListaDeAnalise.Metodo.NodoMetodo;
import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.ListaDeAnalise.NodoContainer;
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

    private final String _padraoNome = "^(?!class|method|begin|self|vars|end|if|return|" +
                                        "eq|ne|lt|le|gt|ge|new|main|io|end-method|end-class|" +
                                        "else|end-if)[a-zA-Z]+";

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

            padrao = Pattern.compile(_padraoNome);
            combinador = padrao.matcher(_codigo.substring(_index));
            if(combinador.find())
                ObterNodoVariavel(_codigo.substring(_index));
        }
    }

    private void ObterNodoVariavel(String substring) {
        NodoContainer listaTemp = new NodoContainer(null);

        for(int i = 0;substring.charAt(i) != '\n';i++) {
            Pattern padrao = Pattern.compile("^[a-zA-Z]+\\.[a-zA-Z]+");
            Matcher combinador = padrao.matcher(substring.substring(i));
            if(combinador.find()) {
                ObterNodoGet(
                        listaTemp,
                        substring.substring(combinador.start(), combinador.end()));
                i = combinador.end();
                continue;
            }
        }
    }

    private void ObterNodoGet(NodoContainer nodoListaContainer,String substring){
        Pattern padrao = Pattern.compile("^[a-zA-Z]+\\.");
        Matcher combinador = padrao.matcher(substring);
        if(combinador.find()) {
            var nodo = new NodoVariavel(
                    substring.substring(combinador.start(), combinador.end() - 1),
                    ComandoVariavelEnums.COMANDO_VARIAVEL_GET,
                    nodoListaContainer.ObterNodo()
            );

            if (nodoListaContainer.ObterNodo() == null)
                nodoListaContainer.DefinirNodo(nodo);
            else
                AdicionarNodoListaTemp(nodo, nodoListaContainer.ObterNodo());
        }

        padrao = Pattern.compile("^\\.[a-zA-Z]+");
        combinador = padrao.matcher(substring);
        if(combinador.find()) {
            var nodo = new NodoVariavel(
                    substring.substring(combinador.start()+1, combinador.end()),
                    ComandoVariavelEnums.COMANDO_VARIAVEL_GET,
                    nodoListaContainer.ObterNodo()
            );

            if (nodoListaContainer.ObterNodo() == null)
                nodoListaContainer.DefinirNodo(nodo);
            else
                AdicionarNodoListaTemp(nodo, nodoListaContainer.ObterNodo());
        }
    }

    private void ObterNodoMetodoMain(String substring) {
         AdicionarNodo(new NodoMetodo(
            "main",
            ComandoMetodoEnum.COMANDO_METHOD_DEFINICAO,
            _nodoAtual
        ));
    }

    private void ObterNodoEndClass(String substring) {
        var nodoClass = (NodoClasse)RetornaPrimeiroNodo(NodoClasse.class);
        var nome = nodoClass.ObterNome();

        AdicionarNodo(new NodoClasse(
                nome,
                ComandoClasseEnums.COMANDO_END_CLASS,
                _nodoAtual
        ));
    }

    private void ObterNodoEndMethod(String substring) {
        var nodoMetodo = (NodoMetodo)RetornaPrimeiroNodo(NodoMetodo.class);
        var nome = nodoMetodo.ObterNome();

        AdicionarNodo(new NodoMetodo(
                nome,
                ComandoMetodoEnum.COMANDO_END_METHOD,
                _nodoAtual
        ));
    }

    private void ObterNodoBegin(String substring) {
        var nodoMetodo = (NodoMetodo)RetornaPrimeiroNodo(NodoMetodo.class);
        var nome = nodoMetodo.ObterNome();

        AdicionarNodo(new NodoMetodo(
                nome,
                ComandoMetodoEnum.COMANDO_BEGIN_METHOD,
                _nodoAtual
        ));
    }

    private void ObterDefinicaoDeMetodo(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
        NodoMetodo nodo = null;
        int j;
        for(j = 0; substring.charAt(j) != '(';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(substring.substring(j));
            if(combinador.find()){
                    nodo = new NodoMetodo(
                        substring.substring(combinador.start(), combinador.end()),
                        ComandoMetodoEnum.COMANDO_METHOD_DEFINICAO,
                        _nodoAtual
                );

                AdicionarNodo(nodo);
            }
        }

        for(; substring.charAt(j) != ')';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(substring.substring(j));
            if(combinador.find() && nodo != null){
                nodo.AdicionarAtributo(new NodoVariavel(
                        substring.substring(combinador.start(),combinador.end()),
                        ComandoVariavelEnums.COMANDO_VARIAVEL_ATRIBUTO,
                        nodo
                ));
            }
        }
    }

    private void ObterDeclaracaoDeClasse(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
        for(int j = 0;substring.charAt(j) != '\n';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(substring.substring(j));
            if(combinador.find()){
                var nodo = new NodoClasse(
                        substring.substring(combinador.start(),combinador.end()),
                        ComandoClasseEnums.COMANDO_CLASSE_DEFINICAO,
                        _nodoAtual
                );

                AdicionarNodo(nodo);
                return;
            }
        }
    }

    private void ObterDeclaracoesDeVariaveis(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
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
            proximoNodo.DefinirProximoNodo(nodo);
            _nodoAtual = nodo;
            return;
        }

        AdicionarNodo(nodo, proximoNodo.RetornarProximoNodo());
    }

    private void AdicionarNodoListaTemp(NodoBase nodoAdicionar, NodoBase lista){
        if(lista.RetornarProximoNodo() == null){
            lista.DefinirProximoNodo(nodoAdicionar);
            nodoAdicionar.DefinirNodoAnterior(lista);
            return;
        }

        AdicionarNodoListaTemp(nodoAdicionar, lista.RetornarProximoNodo());
    }

    private NodoBase RetornaPrimeiroNodo(Class<?> tipo){
        if(_nodoAtual == null)
            return null;

        return RetornaPrimeiroNodo(tipo,_nodoAtual);
    }

    private NodoBase RetornaPrimeiroNodo(Class<?> tipo, NodoBase nodo){
        if(tipo == nodo.getClass())
            return nodo;

        return RetornaPrimeiroNodo(tipo,_nodoAtual.RetornarNodoAnterior());
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

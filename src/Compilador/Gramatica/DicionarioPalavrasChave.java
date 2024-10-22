package Compilador.Gramatica;

import Compilador.Gramatica.ListaDeAnalise.Classe.ComandoClasseEnums;
import Compilador.Gramatica.ListaDeAnalise.Classe.NodoClasse;
import Compilador.Gramatica.ListaDeAnalise.Constante.NodoConstante;
import Compilador.Gramatica.ListaDeAnalise.Metodo.NodoMetodo;
import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.ListaDeAnalise.Operacoes.NodoOperacao;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoVariavel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DicionarioPalavrasChave {
    private static final String _padraoNomes = "[a-zA-Z]+";
    private static NodoBase _nodoAnterior;

    private  DicionarioPalavrasChave() {
    }

    public static NodoBase ObterNodo(String linha, NodoBase nodoAnterior){
        NodoBase nodo = null;
        _nodoAnterior = nodoAnterior;

        nodo = ValidarVariavel(linha);
        if(nodo =)
        nodo = ValidarClasse(linha);
        nodo = ValidarMetodo(linha);
        nodo = ValidarOperacao(linha);
        nodo = ValidarConstate(linha);

        return null;
    }

    private static NodoOperacao ValidarOperacao(String linha) {

    }

    private static NodoVariavel ValidarVariavel(String linha) {
        Pattern padrao = Pattern.compile("\\s+^var");
        Matcher combinador = padrao.matcher(linha);

        if(combinador.find()){
            return new NodoVariavel(
                    ObterNome(linha.substring(combinador.end())),
                    null,

            );
        }
    }

    private static NodoMetodo ValidarMetodo(String linha) {

    }

    private static NodoConstante ValidarConstate(String linha){

    }

    private static NodoClasse ValidarClasse(String linha) {
        Pattern padrao = Pattern.compile("\\s+^class");
        Matcher combinador = padrao.matcher(linha);
        if(combinador.find())
            return new NodoClasse(
                    ObterNome(linha.substring(combinador.end())),
                    ComandoClasseEnums.COMANDO_CLASSE_DEFINICAO
            );

        padrao = Pattern.compile("\\s+^begin");
        combinador = padrao.matcher(linha);
        if(combinador.find()){
            var nome = ProcurarNome(_nodoAnterior);
            if(nome != null)
                return new NodoClasse(
                        nome,
                        ComandoClasseEnums.COMANDO_BEGIN_CLASS
                );
        }

        padrao = Pattern.compile("\\s+^end-class");
        combinador = padrao.matcher(linha);
        if(combinador.find()){
            var nome = ProcurarNome(_nodoAnterior);
            if(nome != null)
                return new NodoClasse(
                        nome,
                        ComandoClasseEnums.COMANDO_END_CLASS
                );
        }

        padrao = Pattern.compile("new");
        combinador = padrao.matcher(linha);
        if(combinador.find()){
            return new NodoClasse(
                    ObterNome(linha.substring(combinador.end())),
                    ComandoClasseEnums.COMANDO_CLASSE_NEW
            );
        }

        return null;
    }

    private static String ProcurarNome(NodoBase nodo){
        if(nodo.RetornarNodoPai() == null)
            return null;

        if(nodo instanceof NodoMetodo)
            return null;

        if(nodo instanceof NodoClasse){
            var nodoClasse = (NodoClasse)nodo;
            if(nodoClasse.ObterComando() == ComandoClasseEnums.COMANDO_CLASSE_DEFINICAO)
                return nodoClasse.ObterNome();
        }

        return ProcurarNome(nodo.RetornarNodoPai());
    }

    private static String ObterNome(String linha) {
        Pattern padrao = Pattern.compile(_padraoNomes);
        Matcher combinador = padrao.matcher(linha);

        return linha.substring(combinador.start(), combinador.end());
    }
}

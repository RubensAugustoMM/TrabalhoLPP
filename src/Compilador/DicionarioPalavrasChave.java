package Compilador;

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
    static String[] palavrasChave = {"class", "method", "begin", "self", "vars", "end","if","return",
                                        "eq", "ne", "lt", "le", "gt", "ge", "new", "main", "io"};
    static String PadraoNomes = "[a-zA-Z]+";

    private  DicionarioPalavrasChave() {
    }

    public static NodoBase ObterNodo(String linha){
        NodoBase nodo;

        nodo = ValidarClasse(linha);
        nodo = ValidarMetodo(linha);
        nodo = ValidarVariavel(linha);
        nodo = ValidarOperacao(linha);
        nodo = ValidarConstate(linha);

        return nodo;
    }

    private static NodoOperacao ValidarOperacao(String linha) {

    }

    private static NodoVariavel ValidarVariavel(String linha) {
    }

    private static NodoMetodo ValidarMetodo(String linha) {
    }

    private static NodoClasse ValidarClasse(String linha) {
        Pattern padrao = Pattern.compile("^" + palavrasChave[0]);
        Matcher combinador = padrao.matcher(linha);
        combinador.end()

        if(combinador.find())
            return new NodoClasse(, ComandoClasseEnums.COMANDO_CLASSE_NEW);
    }

    private static NodoConstante ValidarConstate(String linha){

    }

    private String RetornaNome(String linha) {
        Pattern padrao = Pattern.compile(PadraoNomes);
        Matcher combinador = padrao.matcher(linha);

        return combinador.pattern();
    }
}

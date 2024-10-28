package Compilador.Gramatica.ListaDeAnalise.Variavel;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoVariavel extends NodoBase {
    private String _nome;
    private NodoVariavel _proximoNodo;

    public NodoVariavel(String nome, ComandoVariavelEnums comando, NodoBase pai) {
        super(pai, comando);
        _nome = nome;
    }

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }

    public NodoVariavel ObterProximoNodo(){
        return _proximoNodo;
    }

    public void DefinirProximoNodo(NodoVariavel nodo){
        _proximoNodo = nodo;
    }
}
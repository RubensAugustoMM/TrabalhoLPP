package Compilador.Gramatica.ListaDeAnalise.Variavel;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoVariavel extends NodoBase {
    private String _nome;
    private Object _valor;
    private ComandoVariavelEnums _comando;

    public NodoVariavel(String nome, Object valor, ComandoVariavelEnums _comando) {
        _nome = nome;
        _valor = valor;
        _comando = _comando;
    }

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }

    public void DefinirValor(Object valor){
        _valor = valor;
    }

    public Object ObterValor(){
        return _valor;
    }

    public String ObterTipo(){
        return _valor.getClass().getSimpleName();
    }
}
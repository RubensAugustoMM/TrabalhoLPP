package Compilador.Gramatica.ListaDeAnalise.Metodo;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoMetodo extends NodoBase {
    private String _nome;
    private  ComandoMetodoEnum _comando;

    public NodoMetodo(String nome, ComandoMetodoEnum comando){
        _nome = nome;
        _comando = comando;
    }

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }
}

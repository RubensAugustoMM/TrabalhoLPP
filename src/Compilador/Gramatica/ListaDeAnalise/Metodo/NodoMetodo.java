package Compilador.Gramatica.ListaDeAnalise.Metodo;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoMetodo extends NodoBase {
    private String _nome;

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }
}

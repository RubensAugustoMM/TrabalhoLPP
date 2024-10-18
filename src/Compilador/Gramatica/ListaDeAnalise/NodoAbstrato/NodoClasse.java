package Compilador.Gramatica.ListaDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoClasse extends NodoBase {
    private String _nome;

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }
}

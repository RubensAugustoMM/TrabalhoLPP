package Compilador.Gramatica.ListaDeAnalise.Classe;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoClasse extends NodoBase {
    private String _nome;
    private ComandoClasseEnums _comando;

    public NodoClasse(String nome, ComandoClasseEnums comando) {
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

package Compilador.Gramatica.ListaDeAnalise.Condicional;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoIf extends NodoBase {
    private int _linhas;
    ComandosCondicionalEnums _comando;

    public NodoIf(int linhas, ComandosCondicionalEnums comando) {
        _linhas = linhas;
        _comando = comando;
    }

    public int ObterNumeroDeLinhas(){
        return _linhas;
    }

    public void DefinirLinhas(int linhas){
        _linhas = linhas;
    }
}

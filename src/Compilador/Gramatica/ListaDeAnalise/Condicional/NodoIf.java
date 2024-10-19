package Compilador.Gramatica.ListaDeAnalise.Condicional;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoIf extends NodoBase {
    private int _linhas;
    ComandosCondicionalEnums comando;

    public int ObterNumeroDeLinhas(){
        return _linhas;
    }

    public void DefinirLinhas(int linhas){
        _linhas = linhas;
    }
}

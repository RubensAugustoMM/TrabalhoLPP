package Compilador.Gramatica.ListaDeAnalise.Condicional;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoIf extends NodoBase {
    private int _linhas;

    public NodoIf(int linhas, ComandosCondicionalEnums comando, NodoBase pai) {
        super(pai, comando);
        _linhas = linhas;
    }

    public int ObterNumeroDeLinhas(){
        return _linhas;
    }

    public void DefinirLinhas(int linhas){
        _linhas = linhas;
    }
}

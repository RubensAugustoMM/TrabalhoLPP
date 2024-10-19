package Compilador.Gramatica.ListaDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoIf extends NodoBase {
    private int _linhas;

    public int ObterNumeroDeLinhas(){
        return _linhas;
    }

    public void DefinirLinhas(int linhas){
        _linhas = linhas;
    }
}

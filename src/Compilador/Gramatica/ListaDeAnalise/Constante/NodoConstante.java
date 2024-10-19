package Compilador.Gramatica.ListaDeAnalise.Constante;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoConstante extends NodoBase {
    private int _valor;

    public int ObterValor(){
        return _valor;
    }

    public void DefinirValor(int valor){
        _valor = valor;
    }
}

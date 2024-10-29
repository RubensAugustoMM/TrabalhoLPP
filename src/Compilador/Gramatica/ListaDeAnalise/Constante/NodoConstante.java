package Compilador.Gramatica.ListaDeAnalise.Constante;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoConstante extends NodoBase {
    private int _valor;

    public NodoConstante(int valor, ComandoConstanteEums comando, NodoBase pai) {
        super(pai, comando);
        _valor = valor;
    }

    public int ObterValor(){
        return _valor;
    }

    public void DefinirValor(int valor){
        _valor = valor;
    }

    @Override
    public String RetornaTextoComando() {
        return "const" + _valor;
    }
}

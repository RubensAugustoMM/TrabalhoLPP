package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public class NodoNumber extends NodoBase {
    private double _numero;

    public double RetornarNumero(){
       return _numero;
    }

    public void DefinirNumero(double numero){
        _numero = numero;
    }
}

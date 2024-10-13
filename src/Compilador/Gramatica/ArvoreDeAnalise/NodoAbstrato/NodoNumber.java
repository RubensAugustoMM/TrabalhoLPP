package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoNumber extends NodoAbstratoBase{
    private double _numero;

    public double RetornarNumero(){
       return _numero;
    }

    public void DefinirNumero(double numero){
        _numero = numero;
    }
}

package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoNumber extends NodoAbstratoBase{
    private double Numero;

    public double RetornarNumero(){
       return Numero;
    }

    public void DefinirNumero(double numero){
        Numero = numero;
    }
}

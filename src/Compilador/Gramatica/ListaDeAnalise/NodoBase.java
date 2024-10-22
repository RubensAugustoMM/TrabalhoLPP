package Compilador.Gramatica.ListaDeAnalise;

import Compilador.Gramatica.ListaDeAnalise.Classe.ComandoClasseEnums;

public class NodoBase {
    private NodoBase _pai;
    private NodoBase _proximoNodo;
    protected Enum _comando;

    public void DefinirNodoPai(NodoBase nodo){
        _pai = nodo;
    }

    public NodoBase RetornarNodoPai(){
        return _pai;
    }


    public Enum ObterComando(){
        return _comando;
    }

    public void DefinirComando(Enum comando){
        _comando = comando;
    }

    public NodoBase RetornarProximoNodo(){
        return _proximoNodo;
    }

    public void AtribuirProximoNodo(NodoBase nodo){
        _proximoNodo = nodo;
    }
}
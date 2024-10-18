package Compilador.Gramatica.ListaDeAnalise;

public class NodoBase {
    private NodoBase _pai;
    private NodoBase _proximoNodo;

    public void DefinirNodoPai(NodoBase nodo){
        _pai = nodo;
    }

    public NodoBase RetornarNodoPai(){
        return _pai;
    }

    public NodoBase RetornarProximoNodo(){
        return _proximoNodo;
    }

    public void AtribuirProximoNodo(NodoBase nodo){
        _proximoNodo = nodo;
    }
}
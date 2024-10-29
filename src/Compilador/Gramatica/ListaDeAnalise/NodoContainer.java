package Compilador.Gramatica.ListaDeAnalise;

public class NodoContainer {
    private NodoBase _nodo;

    public NodoContainer(NodoBase nodo) {
        _nodo = nodo;
    }

    public void DefinirNodo(NodoBase nodo) {_nodo = nodo;}
    public NodoBase ObterNodo() {return _nodo;}
}

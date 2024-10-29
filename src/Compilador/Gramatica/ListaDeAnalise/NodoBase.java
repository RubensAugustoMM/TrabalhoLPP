package Compilador.Gramatica.ListaDeAnalise;

public class NodoBase {
    private NodoBase _nodoAnterior;
    private NodoBase _proximoNodo;
    private Enum _comando;

    public NodoBase(NodoBase pai, Enum comando) {
        pai = _nodoAnterior;
        _proximoNodo = pai;
    }

    public void DefinirNodoAnterior(NodoBase nodo){
        _nodoAnterior = nodo;
    }

    public NodoBase RetornarNodoAnterior(){
        return _nodoAnterior;
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

    public void DefinirProximoNodo(NodoBase nodo){
        nodo.DefinirNodoAnterior(this);
        _proximoNodo = nodo;
    }

    public String RetornaTextoComando(){
        return null;
    }
}
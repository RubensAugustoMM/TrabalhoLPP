package Compilador.Gramatica.ArvoreDeAnalise;

import java.util.List;

public class NodoBase {
    private NodoBase _pai;

    public void DefinirNodoPai(NodoBase nodo){
        _pai = nodo;
    }

    public NodoBase RetornarNodoPai(){
        return _pai;
    }
}

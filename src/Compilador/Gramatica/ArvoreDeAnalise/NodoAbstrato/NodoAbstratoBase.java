package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

import java.util.List;

public class NodoAbstratoBase extends NodoBase {
    private List<NodoBase> _filhos;

    public List<NodoBase> RetornarNodosFilhos(){
        return _filhos;
    }

    public void AdicionarNodoFilho(NodoBase nodo){
        _filhos.add(nodo);
    }

    public boolean ValidarPredicado(){
        return true;
    }

    public boolean ValidarSintaxe(){
        return true;
    }

    public boolean CompararToken(NodoBase nodo, TokenEnums token){
        var nodoTerminal = (NodoTerminal) nodo;
        return nodoTerminal.RetornarTipo() == token;
    }
}

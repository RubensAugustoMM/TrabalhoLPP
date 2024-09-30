package Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.Tokens.TokenEnums;

import java.util.List;

public class NodoTerminal implements NodoBase {
    private NodoBase _pai;
    private TokenEnums _tipo;

    public NodoTerminal(TokenEnums tipo) {
       _tipo = tipo;
    }

    public TokenEnums RetornarTipo(){
        return _tipo;
    }
    @Override
    public List<NodoBase> RetornarNodosFilhos() {
        return null;
    }

    @Override
    public void AdicionarNodoFilho(NodoBase nodo) {
    }

    @Override
    public NodoBase RetornarNodoFilho(int posicao) {
        return null;
    }

    @Override
    public void DefinirNodoPai(NodoBase nodo) {
        _pai = nodo;
    }

    @Override
    public NodoBase RetornarNodoPai() {
        return _pai;
    }
}

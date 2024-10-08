package Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.Tokens.TokenEnums;

import java.util.List;

public class NodoTerminal extends NodoBase {

    private TokenEnums _tipo;

    public NodoTerminal(TokenEnums tipo) {
       _tipo = tipo;
    }

    public TokenEnums RetornarTipo(){
        return _tipo;
    }
}

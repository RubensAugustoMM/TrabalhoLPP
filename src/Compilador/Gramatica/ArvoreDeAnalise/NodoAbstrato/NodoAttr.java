package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoAttr extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho < 4 || tamanho > 6)
            return false;

        if(!(filhos.getFirst() instanceof NodoLhs nodoLhs))
            return false;

        if(!nodoLhs.ValidarSintaxe())
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal nodoTerminal))
            return false;

        if(!CompararToken(nodoTerminal, TokenEnums.OPERADOR_IGUALDADE))
            return false;

        if(tamanho == 4){
            if(!(filhos.get(2) instanceof NodoArg nodoArg))
                return false;

            if(!nodoArg.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal)filhos.get(3);
        }
        else if( tamanho == 6){
            if(!(filhos.get(2) instanceof NodoArgBin nodoArgBin))
                return false;

            if(!nodoArgBin.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoOperacao nodoOperacao))
                return false;

            if(!nodoOperacao.ValidarSintaxe())
                return false;

            if(!(filhos.get(4) instanceof NodoArgBin))
                return false;

            nodoArgBin = (NodoArgBin)filhos.get(4);
            if(!nodoArgBin.ValidarSintaxe())
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal)filhos.get(5);
        } else {
            return false;
        }
        return CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA);
    }
}

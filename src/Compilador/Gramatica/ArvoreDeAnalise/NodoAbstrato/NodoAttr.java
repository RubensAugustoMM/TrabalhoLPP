package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoAttr extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho < 4 || tamanho > 6)
            return false;

        if(!(filhos.get(0) instanceof NodoLhs))
            return false;

        var nodoLhs = (NodoLhs)filhos.get(0);
        if(!nodoLhs.ValidarSintaxe())
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal)filhos.get(1);
        if(nodoTerminal.RetornarTipo() != TokenEnums.OPERADOR_IGUALDADE)
            return false;

        if(tamanho == 4){
            if(!(filhos.get(2) instanceof NodoArg))
                return false;

            var nodoArg = (NodoArg )filhos.get(2);
            if(!nodoArg.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal)filhos.get(3);
        }
        else if( tamanho == 6){
            if(!(filhos.get(2) instanceof NodoArgBin))
                return false;

            var nodoArgBin = (NodoArgBin)filhos.get(2);
            if(!nodoArgBin.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoOperacao))
                return false;

            var nodoOperacao = (NodoOperacao)filhos.get(3);
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
        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}

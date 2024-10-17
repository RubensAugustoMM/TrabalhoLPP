package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoMainBody extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 5 &&
        tamanho != 6)
            return false;

        if(!(filhos.getFirst() instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_BEGIN))
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(1);
        if(!CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA))
            return false;

        if(tamanho == 5){
            if(!(filhos.get(2) instanceof NodoVarsDef nodoVarsDef))
                return false;
            if(!nodoVarsDef.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoMainStmts nodoMainStmts))
                return false;
            if(!nodoMainStmts.ValidarSintaxe())
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(4);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END))
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(5);
        }
        else {
            if(!(filhos.get(2) instanceof NodoMainStmts nodoMainStmts))
                return false;
            if(nodoMainStmts.ValidarSintaxe())
                return false;

            if(!(filhos.get(3) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(3);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END))
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(4);
        }
        return CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END);
    }
}

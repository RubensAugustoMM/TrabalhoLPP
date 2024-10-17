package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoIf extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho < 9 ||
        tamanho > 12)
            return false;

        if(!(filhos.getFirst() instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_IF))
            return false;

        if(!(filhos.get(1) instanceof NodoName))
            return false;

        if(!(filhos.get(2) instanceof NodoComparacao nodoComparacao))
            return false;
        if(!nodoComparacao.ValidarSintaxe())
            return false;

        if(!(filhos.get(3) instanceof NodoName))
            return false;

        if(!(filhos.get(4) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(4);
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_THEN))
            return false;

        if(!(filhos.get(5) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(5);
        if(!CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA))
            return  false;

        if(!(filhos.get(6) instanceof NodoIfStmts nodoIfStmts))
            return false;
        if(!nodoIfStmts.ValidarSintaxe())
            return false;

        if(tamanho == 9){
            if(!(filhos.get(7) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(7);
            if(!CompararToken(nodoTerminal,TokenEnums.PALAVRA_CHAVE_END_IF))
                return false;

            if(!(filhos.get(8) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal)filhos.get(8);
        }
        else if(tamanho == 12){
            if(!(filhos.get(7) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(7);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_ELSE))
                return false;

            if(!(filhos.get(8) instanceof NodoTerminal))
                return false;
            nodoTerminal= (NodoTerminal)filhos.get(8);
            if(!CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA))
                return false;

            if(!(filhos.get(9) instanceof NodoIfStmts))
                return false;
            nodoIfStmts = (NodoIfStmts)filhos.get(9);
            if(!nodoIfStmts.ValidarSintaxe())
                return false;

            if(!(filhos.get(10) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal)filhos.get(10);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END_IF))
                return false;

            if(!(filhos.get(11) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal)filhos.get(11);
        }
        else {
            return false;
        }
        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}

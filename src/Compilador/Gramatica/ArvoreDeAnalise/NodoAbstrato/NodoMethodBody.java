package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoMethodBody extends  NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 5)
            return false;

        if(!(filhos.get(0) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(0);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_BEGIN)
            return false;

        if((filhos.get(1) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(1);
        if(nodoTerminal.RetornarTipo() != TokenEnums.QUEBRA_LINHA)
            return false;

        if(!(filhos.get(2) instanceof NodoBodyStmts))
            return false;

        var nodoBodyStmts = (NodoBodyStmts)filhos.get(2);
        if(!nodoBodyStmts.ValidarSintaxe())
            return false;

        if(!(filhos.get(3) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(3);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_END_METHOD)
            return false;

        if(!(filhos.get(4) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(4);
        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}

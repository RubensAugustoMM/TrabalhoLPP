package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoObjCreation extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 3)
            return false;

        if(!(filhos.get(0) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(0);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_NEW)
            return false;

        if(!(filhos.get(1) instanceof NodoName))
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(2);
        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}
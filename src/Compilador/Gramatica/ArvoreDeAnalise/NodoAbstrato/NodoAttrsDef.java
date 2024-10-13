package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoAttrsDef extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 3)
            return false;

        if(!(filhos.get(0) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(0);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_VARS)
            return false;

        if(!(filhos.get(1) instanceof NodoNameList))
            return false;

        var nodoNameList = (NodoNameList) filhos.get(1);
        if(!nodoNameList.ValidarSintaxe())
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(2);

        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}
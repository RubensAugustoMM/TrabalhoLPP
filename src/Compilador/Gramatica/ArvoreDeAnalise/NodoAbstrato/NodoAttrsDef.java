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

        if(!CompararToken(filhos.get(0), TokenEnums.PALAVRA_CHAVE_VARS))
            return false;

        if(!(filhos.get(1) instanceof NodoNameList nodoNameList))
            return false;

        if(!nodoNameList.ValidarSintaxe())
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal nodoTerminal))
            return false;
        return CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA);
    }
}

package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoMethodHeader extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
        tamanho < 5 ||
        tamanho  > 6)
            return false;

        if(!(filhos.getFirst() instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_METHOD))
            return false;

        if(!(filhos.get(1) instanceof NodoName))
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(2);
        if(!CompararToken(nodoTerminal, TokenEnums.PARENTESES_ESQUERDO))
            return false;

        if(tamanho == 6){
            if(!(filhos.get(3) instanceof NodoNameList nodoNameList))
                return false;
            if(!nodoNameList.ValidarSintaxe())
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(4);
            if(!CompararToken(nodoTerminal, TokenEnums.PARENTESES_DIREITO))
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(5);
        }
        else {
            if(!(filhos.get(3) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(3);
            if(!CompararToken(nodoTerminal, TokenEnums.PARENTESES_ESQUERDO))
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(4);
        }
        return CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA);
    }
}
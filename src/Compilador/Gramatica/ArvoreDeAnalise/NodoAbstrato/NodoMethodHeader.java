package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoMethodHeader extends NodoAbstratoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
        tamanho < 5 ||
        tamanho  > 6)
            return false;

        if(!(filhos.get(0) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(0);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_METHOD)
            return false;

        if(!(filhos.get(1) instanceof NodoName))
            return false;

        var nodoName = (NodoName) filhos.get(1);
        if(!nodoName.ValidarSintaxe())
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(2);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_ESQUERDO)
            return false;


        if(tamanho == 6){
            if(!(filhos.get(3) instanceof NodoNameList))
                return false;

            var nodoNameList = (NodoNameList) filhos.get(3);
            if(!nodoNameList.ValidarSintaxe())
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(4);
            if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_DIREITO)
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(5);
            if(nodoTerminal.RetornarTipo() != TokenEnums.QUEBRA_LINHA)
                return false;
        }
        else {
            if(!(filhos.get(3) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(3);
            if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_ESQUERDO)
                return false;

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(4);
            return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
        }

        return true;
    }
}
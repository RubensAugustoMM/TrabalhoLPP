package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoMethodCall extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho < 6 || tamanho > 7)
            return false;

        if(!(filhos.get(0) instanceof NodoName))
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(1);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PONTO)
            return false;

        if(!(filhos.get(2) instanceof NodoName))
            return false;

        if(!(filhos.get(3) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(3);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_ESQUERDO)
            return false;

        if(tamanho == 6){
            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(4);
            if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_DIREITO)
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(5);
        }
        else {
            if(!(filhos.get(4) instanceof NodoNameList))
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(5);
            if(nodoTerminal.RetornarTipo() != TokenEnums.PARENTESES_DIREITO)
                return false;

            if(!(filhos.get(6) instanceof NodoTerminal))
                return false;

            nodoTerminal = (NodoTerminal) filhos.get(6);
        }
        return nodoTerminal.RetornarTipo() == TokenEnums.QUEBRA_LINHA;
    }
}

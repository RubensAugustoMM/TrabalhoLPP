package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoArg extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty()  || tamanho > 2)
            return false;

        if(filhos.get(0) instanceof NodoNumber)
            return true;

        if(tamanho == 2){
            if(!(filhos.get(0)instanceof NodoName))
                return false;

            if(!(filhos.get(1) instanceof NodoTerminal))
                return false;

            var nodoTerminal = (NodoTerminal) filhos.get(1);
            if(nodoTerminal.RetornarTipo() != TokenEnums.PONTO)
                return false;

            return filhos.get(2) instanceof NodoName;
        }

        if(filhos.get(0) instanceof NodoMethodCall)
            return true;

        if(filhos.get(0) instanceof NodoObjCreation)
            return true;

        return false;
    }
}

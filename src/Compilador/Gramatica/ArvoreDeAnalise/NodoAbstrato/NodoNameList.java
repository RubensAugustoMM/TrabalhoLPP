package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoNameList extends NodoAbstratoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(!(filhos.get(0) instanceof  NodoName))
            return false;

        if(tamanho == 3){
            if(!(filhos.get(1) instanceof NodoTerminal))
                return false;

            var nodoTerminal = (NodoTerminal)filhos.get(1);
            if (nodoTerminal.RetornarTipo() != TokenEnums.VIRGULA) {
                return false;
            }

            if(!(filhos.get(2) instanceof NodoNameList))
                return false;

            var nodoNameList = (NodoNameList) filhos.get(2);
            return nodoNameList.ValidarSintaxe();
        }
        return true;
    }
}
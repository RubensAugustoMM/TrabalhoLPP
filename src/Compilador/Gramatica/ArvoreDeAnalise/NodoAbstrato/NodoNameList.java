package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoNameList extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
         tamanho > 3)
            return false;

        if(!(filhos.getFirst() instanceof  NodoName))
            return false;

        if(tamanho == 3){
            if(!(filhos.get(1) instanceof NodoTerminal nodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(1);
            if (!CompararToken(nodoTerminal, TokenEnums.VIRGULA)) {
                return false;
            }

            if(!(filhos.get(2) instanceof NodoNameList nodoNameList))
                return false;
            nodoNameList = (NodoNameList) filhos.get(2);
            return nodoNameList.ValidarSintaxe();
        }
        else return tamanho == 1;
    }
}
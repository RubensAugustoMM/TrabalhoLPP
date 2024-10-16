package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoBodyStmt extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
            tamanho > 2)
            return false;

        if(filhos.getFirst() instanceof  NodoPrototype nodoPrototype){
            return nodoPrototype.ValidarSintaxe();
        }

        if (filhos.getFirst() instanceof NodoAttr nodoAttr) {
            return nodoAttr.ValidarSintaxe();
        }

        if(filhos.get(0) instanceof NodoIf nodoIf) {
            return nodoIf.ValidarSintaxe();
        }

        if(filhos.get(0) instanceof NodoMethodCall nodoMethodCall){
            return nodoMethodCall.ValidarSintaxe();
        }

        if(tamanho == 2){
            if(!(filhos.get(0) instanceof NodoTerminal nodoTerminal))
                return false;

            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_RETURN))
                return false;

            return filhos.get(1) instanceof NodoName;
        }

        return true;
    }
}

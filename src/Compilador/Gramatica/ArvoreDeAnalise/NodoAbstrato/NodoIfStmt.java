package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoIfStmt extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1 &&
                tamanho != 2)
            return false;

        if(filhos.getFirst() instanceof NodoPrototype nodoPrototype){
            return nodoPrototype.ValidarSintaxe();
        }

        if(filhos.getFirst() instanceof NodoAttr  nodoAttr){
            return nodoAttr.ValidarSintaxe();
        }

        if(filhos.getFirst() instanceof NodoMethodCall nodoMethodCall){
            return nodoMethodCall.ValidarSintaxe();
        }

        if(!(filhos.getFirst() instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_RETURN))
            return false;
        if(tamanho == 2){
            return  filhos.get(1) instanceof NodoName;
        }

        return false;
    }
}

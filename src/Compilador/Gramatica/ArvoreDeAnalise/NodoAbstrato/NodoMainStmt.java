package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public class NodoMainStmt extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        if(filhos.getFirst() instanceof NodoPrototype nodoPrototype ){
            return nodoPrototype.ValidarSintaxe();
        }

        if(filhos.getFirst() instanceof NodoAttr nodoAttr){
            return nodoAttr.ValidarSintaxe();
        }

        if(filhos.getFirst() instanceof NodoIf nodoIf){
            return nodoIf.ValidarSintaxe();
        }

        if(filhos.getFirst() instanceof NodoMethodCall nodoMethodCall){
            return nodoMethodCall.ValidarSintaxe();
        }
        return false;
    }
}

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

        if(filhos.get(0) instanceof  NodoPrototype){
            var nodo = (NodoPrototype) filhos.get(0);
            return nodo.ValidarSintaxe();
        }

        if (filhos.get(0) instanceof NodoAttr) {
            var nodo = (NodoAttr) filhos.get(0);
            return nodo.ValidarSintaxe();
        }

        if(filhos.get(0) instanceof NodoIf) {
            var nodo = (NodoIf) filhos.get(0);
            return nodo.ValidarSintaxe();
        }

        if(filhos.get(0) instanceof NodoMethodCall){
            var nodo = (NodoMethodCall) filhos.get(0);
            return nodo.ValidarSintaxe();
        }

        if(tamanho == 2){
            if(!(filhos.get(0) instanceof NodoTerminal))
                return false;

            if(!CompararToken(filhos.get(0), TokenEnums.PALAVRA_CHAVE_RETURN))
                return false;

            return filhos.get(1) instanceof NodoName;
        }

        return true;
    }
}

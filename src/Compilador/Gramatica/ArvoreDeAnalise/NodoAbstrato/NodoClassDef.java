package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoClassDef extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 6 &&
                tamanho != 7)
            return false;

        if(!(filhos.getFirst() instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_CLASS))
            return false;

        if(!(filhos.get(1) instanceof NodoName))
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(2);
        if(!CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA))
            return false;

        if(tamanho == 7){
            if(!(filhos.get(3) instanceof NodoAttrsDef nodoAttrsDef))
                return false;
            if(!nodoAttrsDef.ValidarSintaxe())
                return false;

            if(!(filhos.get(4) instanceof NodoMethodDefs nodoMethodDefs))
                return false;
            if(!nodoMethodDefs.ValidarSintaxe())
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(5);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END_CLASS))
                return false;

            if(!(filhos.get(6) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(6);
        }
        else{
            if(filhos.get(3) instanceof NodoAttrsDef nodoAttrsDef){
                if(!nodoAttrsDef.ValidarSintaxe())
                    return false;
            }
            else if(filhos.get(3) instanceof NodoMethodDefs nodoMethodDefs){
                if(!nodoMethodDefs.ValidarSintaxe())
                    return false;
            }
            else {
                return false;
            }

            if(!(filhos.get(4) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(4);
            if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_END_CLASS))
                return false;

            if(!(filhos.get(5) instanceof NodoTerminal))
                return false;
            nodoTerminal = (NodoTerminal) filhos.get(5);
        }
        return CompararToken(nodoTerminal, TokenEnums.QUEBRA_LINHA);
    }
}

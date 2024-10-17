package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoPrototype extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 5)
            return false;

        if(!(filhos.getFirst() instanceof NodoName))
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal nodoTerminal))
            return false;
        if(!CompararToken(nodoTerminal, TokenEnums.PONTO))
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(2);
        if(!CompararToken(nodoTerminal, TokenEnums.PALAVRA_CHAVE_PROTOTYPE))
            return false;

        if(!(filhos.get(3) instanceof NodoTerminal))
            return false;
        nodoTerminal = (NodoTerminal) filhos.get(3);
        if(!CompararToken(nodoTerminal, TokenEnums.OPERADOR_IGUALDADE))
            return false;

        return filhos.get(4) instanceof NodoName;
    }
}

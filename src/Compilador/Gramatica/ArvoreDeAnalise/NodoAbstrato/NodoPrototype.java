package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoPrototype extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 5)
            return false;

        if(!(filhos.get(0) instanceof NodoName))
            return false;

        if(!(filhos.get(1) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(1);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PONTO)
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(2);
        if(nodoTerminal.RetornarTipo() != TokenEnums.PALAVRA_CHAVE_PROTOTYPE)
            return false;

        if(!(filhos.get(3) instanceof NodoTerminal))
            return false;

        nodoTerminal = (NodoTerminal) filhos.get(3);
        if(nodoTerminal.RetornarTipo() != TokenEnums.OPERADOR_IGUALDADE)
            return false;

        if(!(filhos.get(4) instanceof NodoName))
            return false;

        return true;
    }
}

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

        if(!CompararToken(filhos.get(1), TokenEnums.PONTO))
            return false;

        if(!(filhos.get(2) instanceof NodoTerminal))
            return false;

        if(!CompararToken(filhos.get(2), TokenEnums.PALAVRA_CHAVE_PROTOTYPE))
            return false;

        if(!(filhos.get(3) instanceof NodoTerminal))
            return false;

        if(!CompararToken(filhos.get(3), TokenEnums.OPERADOR_IGUALDADE))
            return false;

        return filhos.get(4) instanceof NodoName;
    }
}

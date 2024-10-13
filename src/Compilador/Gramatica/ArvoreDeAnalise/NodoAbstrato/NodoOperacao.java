package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoOperacao extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        if(!(filhos.get(0) instanceof NodoTerminal))
            return false;

        var nodoTerminal = (NodoTerminal) filhos.get(0);
        if(nodoTerminal.RetornarTipo() == TokenEnums.OPERADOR_ADICAO)
            return true;

        if(nodoTerminal.RetornarTipo() == TokenEnums.OPERADOR_SUBTRACAO)
            return true;

        if(nodoTerminal.RetornarTipo() == TokenEnums.OPERADOR_MULTIPLICACAO)
            return true;

        return nodoTerminal.RetornarTipo() == TokenEnums.OPERADOR_DIVISAO;
    }
}

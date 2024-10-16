package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoOperacao extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        var nodoTerminal = filhos.getFirst();
        return CompararToken(nodoTerminal, TokenEnums.OPERADOR_ADICAO) ||
                CompararToken(nodoTerminal, TokenEnums.OPERADOR_SUBTRACAO) ||
                CompararToken(nodoTerminal, TokenEnums.OPERADOR_MULTIPLICACAO) ||
                CompararToken(nodoTerminal, TokenEnums.OPERADOR_DIVISAO);
    }
}

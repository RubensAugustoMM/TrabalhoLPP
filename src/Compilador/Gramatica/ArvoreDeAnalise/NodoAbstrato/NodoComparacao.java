package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoComparacao extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        var nodoTerminal = filhos.getFirst();
        return CompararToken(nodoTerminal, TokenEnums.OPERADOR_MAIOR) ||
               CompararToken(nodoTerminal, TokenEnums.OPERADOR_MENOR) ||
               CompararToken(nodoTerminal, TokenEnums.OPERADOR_IGUAL) ||
               CompararToken(nodoTerminal, TokenEnums.OPERADOR_MAIOR_IGUAL) ||
               CompararToken(nodoTerminal, TokenEnums.OPERADOR_MENOR_IGUAL);
    }
}

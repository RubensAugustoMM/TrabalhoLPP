package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoComparacao extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        return CompararToken(filhos.get(0), TokenEnums.OPERADOR_MAIOR) ||
               CompararToken(filhos.get(0), TokenEnums.OPERADOR_MENOR) ||
               CompararToken(filhos.get(0), TokenEnums.OPERADOR_IGUAL) ||
               CompararToken(filhos.get(0), TokenEnums.OPERADOR_MAIOR_IGUAL) ||
               CompararToken(filhos.get(0), TokenEnums.OPERADOR_MENOR_IGUAL);
    }
}

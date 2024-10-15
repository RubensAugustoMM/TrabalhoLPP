package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoOperacao extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        return CompararToken(filhos.get(0), TokenEnums.OPERADOR_ADICAO) ||
                CompararToken(filhos.get(0), TokenEnums.OPERADOR_SUBTRACAO) ||
                CompararToken(filhos.get(0), TokenEnums.OPERADOR_MULTIPLICACAO) ||
                CompararToken(filhos.get(0), TokenEnums.OPERADOR_DIVISAO);
    }
}

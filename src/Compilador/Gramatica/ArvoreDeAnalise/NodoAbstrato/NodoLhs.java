package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoLhs extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho < 1 || tamanho > 3)
            return false;

        if(!(filhos.get(0) instanceof NodoName))
            return false;

        if(tamanho == 3){
            if(!(filhos.get(1) instanceof NodoTerminal))
                return false;

            if(!CompararToken(filhos.get(1), TokenEnums.PONTO))
                return false;

            return filhos.get(0) instanceof NodoName;
        }

        return true;
    }
}

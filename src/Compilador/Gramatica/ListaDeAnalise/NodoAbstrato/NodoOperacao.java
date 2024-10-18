package Compilador.Gramatica.ListaDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.Tokens.TokenEnums;

public class NodoOperacao extends NodoBase {
    private TokenEnums _operacao;

    public TokenEnums ObterOperacao(){
        return _operacao;
    }

    public void DefinirOperacao(TokenEnums operacao){
        _operacao = operacao;
    }
}

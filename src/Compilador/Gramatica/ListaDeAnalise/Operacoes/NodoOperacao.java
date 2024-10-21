package Compilador.Gramatica.ListaDeAnalise.Operacoes;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoOperacao extends NodoBase {
    private TokenEnums _operacao;

    public TokenEnums ObterOperacao(){
        return _operacao;
    }

    public void DefinirOperacao(TokenEnums operacao){
        _operacao = operacao;
    }
}

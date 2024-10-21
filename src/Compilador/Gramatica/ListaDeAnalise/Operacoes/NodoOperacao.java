package Compilador.Gramatica.ListaDeAnalise.Operacoes;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoOperacao extends NodoBase {
    private ComandosOperacoesEnums _operacao;

    public NodoOperacao(ComandosOperacoesEnums operacao) {
        _operacao = operacao;
    }

    public ComandosOperacoesEnums ObterOperacao(){
        return _operacao;
    }

    public void DefinirOperacao(ComandosOperacoesEnums operacao){
        _operacao = operacao;
    }
}

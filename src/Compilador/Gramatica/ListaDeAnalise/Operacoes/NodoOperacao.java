package Compilador.Gramatica.ListaDeAnalise.Operacoes;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoOperacao extends NodoBase {
    public NodoOperacao(ComandosOperacoesEnums operacao, NodoBase pai) {
        super(pai, operacao);
    }
}

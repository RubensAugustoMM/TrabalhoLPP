package Compilador.Gramatica.ListaDeAnalise.Operacoes;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoOperacao extends NodoBase {
    public NodoOperacao(ComandosOperacoesEnums operacao, NodoBase pai) {
        super(pai, operacao);
    }

    @Override
    public String RetornaTextoComando() {
        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";

        if(ObterComando() == ComandosOperacoesEnums.COMANDO_OPERACAO_ADD)
            return "add";
        
        return null;
    }
}

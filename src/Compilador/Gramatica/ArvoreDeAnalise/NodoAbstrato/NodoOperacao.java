package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

import java.util.List;

public class NodoOperacao extends NodoAbstratoBase{
    private TokenEnums _operacao;

    @Override
    public List<NodoBase> RetornarNodosFilhos() {
        return null;
    }

    public TokenEnums RetornarOperacao() {
        return _operacao;
    }

    public void DefinirOperacao(TokenEnums operacao) {
        _operacao = operacao;
    }
}

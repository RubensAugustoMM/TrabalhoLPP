package Compilador.Gramatica.ListaDeAnalise.Condicional;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoIf extends NodoBase {
    private int _linhas;

    public NodoIf(int linhas, ComandosCondicionalEnums comando, NodoBase pai) {
        super(pai, comando);
        _linhas = linhas;
    }

    public int ObterNumeroDeLinhas(){
        return _linhas;
    }

    public void DefinirLinhas(int linhas){
        _linhas = linhas;
    }

    @Override
    public String RetornaTextoComando() {
        if (ObterComando() == ComandosCondicionalEnums.COMANDOS_CONDICIONAL_IF)
            return "if " + _linhas;

        if (ObterComando() == ComandosCondicionalEnums.COMANDO_CONDICIONAL_ELSE)
            return "else " + _linhas;

        return null;
    }
}

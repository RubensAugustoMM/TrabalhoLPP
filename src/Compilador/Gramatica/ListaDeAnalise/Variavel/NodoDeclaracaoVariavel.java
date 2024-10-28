package Compilador.Gramatica.ListaDeAnalise.Variavel;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class NodoDeclaracaoVariavel extends NodoBase {
    private NodoVariavel _variaveis;

    public NodoDeclaracaoVariavel(NodoBase pai, ComandoVariavelEnums comando) {
        super(pai, comando);
    }

    public NodoVariavel RetornarVariaveis(){
        return _variaveis;
    }

    public void AdicionarVariavel(NodoVariavel nodo){
        if(_variaveis == null){
            _variaveis = nodo;
            return;
        }

        AdicionarVariavel(nodo,_variaveis.ObterProximoNodo());
    }

    private void AdicionarVariavel(NodoVariavel nodo, NodoVariavel proximoNodo){
        if(proximoNodo.ObterProximoNodo() == null){
            proximoNodo.DefinirProximoNodo(nodo);
            nodo.DefinirProximoNodo(proximoNodo);
            return;
        }

        AdicionarVariavel(nodo, proximoNodo.ObterProximoNodo());
    }
}

package Compilador.Gramatica.ListaDeAnalise.Metodo;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoVariavel;

public class NodoMetodo extends NodoBase {
    private String _nome;
    private NodoVariavel _atributos;

    public NodoMetodo(String nome, ComandoMetodoEnum comando, NodoBase pai){
        super(pai, comando);
        _nome = nome;
    }

    public void AdicionarAtributo(NodoVariavel atributo){
        if(_atributos == null){
            _atributos = atributo;
            return;
        }

        AdicionarAtributo(atributo, _atributos.RetornarProximoNodo());
    }

    public void AdicionarAtributo(NodoVariavel atributo,NodoBase proximoAtributo){
        if(proximoAtributo.RetornarProximoNodo() == null){
            proximoAtributo.DefinirProximoNodo(atributo);
            atributo.DefinirNodoAnterior(proximoAtributo);
            return;
        }

        AdicionarAtributo(atributo, proximoAtributo.RetornarProximoNodo());
    }

    public String ObterNome(){
        return _nome;
    }

    public void DefinirNome(String nome){
        _nome = nome;
    }
}

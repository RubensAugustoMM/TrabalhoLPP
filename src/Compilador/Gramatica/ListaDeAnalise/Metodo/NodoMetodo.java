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
        if(proximoAtributo == null){
            proximoAtributo = atributo;
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

    private String RetornaAtributos(NodoVariavel nodo){
        if(nodo == null)
            return "";

        if(nodo.RetornarProximoNodo() == null)
            return nodo.ObterNome();

        return nodo.ObterNome() + "," + RetornaAtributos(nodo.ObterProximoNodo());
    }

    @Override
    public String RetornaTextoComando() {
        if(ObterComando() == ComandoMetodoEnum.COMANDO_METODO_CALL)
            return "call " + ObterNome();

        if(ObterComando() == ComandoMetodoEnum.COMANDO_METHOD_DEFINICAO)
            return "method " + ObterNome() + "(" + RetornaAtributos(_atributos) + ")";

        if(ObterComando() == ComandoMetodoEnum.COMANDO_BEGIN_METHOD)
            return "begin ";

        if(ObterComando() == ComandoMetodoEnum.COMANDO_END_METHOD)
            return "end ";

        if(ObterComando() == ComandoMetodoEnum.COMANDO_METODO_RET){
            if(ObterNome() == null)
                return "ret ";

            return "ret " + ObterNome();
        }

        return null;
    }
}

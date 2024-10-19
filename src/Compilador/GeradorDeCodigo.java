package Compilador;

import Compilador.Gramatica.ListaDeAnalise.NodoBase;

public class GeradorDeCodigo {
    private NodoBase _nodoAnterior;
    private NodoBase _nodoAtual;
    private NodoBase _nodoPosterior;

    private String _codigo;

    public GeradorDeCodigo(String codigo) {
        _codigo = codigo;
    }

    public String GerarByteCode(){
         for(int i = 0; VerificarFimDoArquivo(i);i++){
             var charactere = _codigo.charAt(i);

         }
         return null;
    }


    private boolean VerificarFimDoArquivo(int i){
        return i < _codigo.length();
    }
}

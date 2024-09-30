package Compilador.AnalizadorLexico;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

import java.util.Stack;

public class AnalizadorLexico {
    private Stack<NodoBase> _pilha = new Stack<>();

    public Stack<NodoBase> RetornarPilha(){
        return _pilha;
    }

    public void AnalizarToken(){

    }

    public void AnalizarCodigo(String codigo){
        for(int i = 0; VerificarFimDoArquivo(codigo,i);i++){
             char charactere = codigo.charAt(i);

             if(charactere == ' '){
                 continue;
             }

             if(charactere == ){}
        }
    }

    private boolean VerificarFimDoArquivo(String codigo, int i){
        return codigo.length() <= i;
    }
}

package Compilador.AnalizadorLexico;

import Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato.NodoProgram;
import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

import java.util.Stack;

public class AnalizadorLexico {
    private Stack<NodoBase> _pilha = new Stack<>();
    private NodoBase _arvore;
    private NodoBase _nodoAtual;
    private NodoBase _nodoAnterior;

    public Stack<NodoBase> RetornarPilha(){
        return _pilha;
    }

    public NodoBase RetornarArvore(){
        return _arvore;
    }

    public void AnalizarToken(){

    }

    public void AnalizarCodigo(String codigo){
        _arvore = new NodoProgram();
        for(int i = 0; VerificarFimDoArquivo(codigo,i);i++){
             char charactere = codigo.charAt(i);

             if(charactere == ' '){
                 continue;
             }
             if(charactere == ''){}
        }
    }

    private boolean VerificarFimDoArquivo(String codigo, int i){
        return codigo.length() < i;
    }
}

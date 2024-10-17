package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public class NodoProgram extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho == 1){
            if(!(filhos.getFirst() instanceof NodoMainBody nodoMainBody))
                return false;
            return nodoMainBody.ValidarSintaxe();
        }
        if(tamanho == 2){
            if(!(filhos.getFirst() instanceof NodoClassDefs nodoClassDefs))
                return false;
            if(!nodoClassDefs.ValidarSintaxe())
                return false;

            if(!(filhos.get(1) instanceof NodoMainBody nodoMainBody))
                return false;
            return nodoMainBody.ValidarSintaxe();
        }
        return false;
    }
}

package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public class NodoMethodDef extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();
        if(filhos.isEmpty() ||
                tamanho < 2 ||
                tamanho  > 3 )
            return false;

        if(!(filhos.get(0) instanceof NodoMethodHeader nodoMethodHeader))
            return false;

        if(!nodoMethodHeader.ValidarSintaxe())
            return false;

        if (tamanho == 2) {
            if(!(filhos.get(1) instanceof NodoMethodBody nodoMethodBody))
                return false;

            return nodoMethodBody.ValidarSintaxe();
        }else {
            if(!(filhos.get(1) instanceof NodoVarsDef nodoVarsDef))
                return false;

            if(!nodoVarsDef.ValidarSintaxe())
                return false;


            if(!(filhos.get(2) instanceof NodoMethodBody nodoMethodBody))
                return false;

            return nodoMethodBody.ValidarSintaxe();
        }
    }
}
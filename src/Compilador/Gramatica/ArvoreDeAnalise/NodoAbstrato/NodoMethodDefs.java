package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public class NodoMethodDefs extends NodoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
                tamanho > 2
        )
            return false;

        if(filhos.get(0) instanceof NodoMethodDef nodoMethodDef){
            return nodoMethodDef.ValidarSintaxe();
        }

        if(tamanho == 2){
            if(filhos.get(1) instanceof  NodoMethodDefs nodoMethodDefs){
                return nodoMethodDefs.ValidarSintaxe();
            }
        }
        return true;
    }
}

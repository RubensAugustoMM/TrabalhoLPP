package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoMethodDef extends NodoAbstratoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();
        if(filhos.isEmpty())
            return false;

        if(!(filhos.get(0)  instanceof NodoMethodHeader))
            return false;

        var nodoMethodHeader = (NodoMethodHeader)filhos.get(0);
        return nodoMethodHeader.ValidarSintaxe();

        if (tamanho == 2) {
            if(!(filhos.get(1) instanceof NodoMethodBody))
                return false;

            var nodoMethodBody = (NodoMethodBody)filhos.get(1);
            if(!nodoMethodBody.ValidarSintaxe())
                return false;
        }

        if(tamanho == 3){
            if(!(filhos.get(1) instanceof NodoVarsDef))
                return false;

            var nodoVarsDef = (NodoVarsDef)filhos.get(1);
            if(!nodoVarsDef.ValidarSintaxe())
                return false;


            if(!(filhos.get(2) instanceof NodoMethodBody))
                return false;

            var nodoMethodBody = (NodoMethodBody)filhos.get(2);
            return nodoMethodBody.ValidarSintaxe();
        }

        return true;
    }
}
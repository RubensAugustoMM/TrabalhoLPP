package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoClassDefs extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1 &&
        tamanho != 2)
            return false;

        if((!(filhos.getFirst() instanceof NodoClassDef nodoClassDef)))
            return false;
        if(!nodoClassDef.ValidarSintaxe())
            return false;

        if(tamanho == 2){
            if(!(filhos.get(1) instanceof NodoClassDefs nodoClassDefs))
                return false;
            return nodoClassDefs.ValidarSintaxe();
        }
        return true;
    }
}

package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoVarsDef extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        if(!(filhos.getFirst() instanceof NodoAttrsDef nodoAttrsDef))
            return false;
        return nodoAttrsDef.ValidarSintaxe();
    }
}

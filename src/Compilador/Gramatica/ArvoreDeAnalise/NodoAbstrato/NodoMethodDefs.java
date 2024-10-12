package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoMethodDefs extends NodoAbstratoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();

        if(filhos.isEmpty())
            return false;

        var tamanho = filhos.size();

        if(filhos.get(0) instanceof NodoMethodDef){
            var nodoFilho =(NodoMethodDef) filhos.get(0);
            return nodoFilho.ValidarSintaxe();
        }

        if(tamanho == 2){
            if(filhos.get(1) instanceof  NodoMethodDefs){
                var nodoFilho = (NodoMethodDefs) filhos.get(1);
                return nodoFilho.ValidarSintaxe();
            }
        }
        return true;
    }
}

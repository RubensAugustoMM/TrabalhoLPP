package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoMethodDefs extends NodoAbstratoBase {
    @Override
    public boolean ValidarSintaxe() {
        var filhos = super.RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.get(0) instanceof NodoMethodDef){
            var nodoFilho = filhos.get(0);
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

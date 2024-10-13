package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoBodyStmts extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(filhos.isEmpty() ||
            tamanho < 2)
            return false;

        if(!(filhos.get(0) instanceof NodoBodyStmt))
            return false;

        var nodoBodyStmt = filhos.get(0);
        if(!nodoBodyStmt.ValidarSintaxe())
            return false;

        if(tamanho == 2){
            if(!(filhos.get(1) instanceof NodoBodyStmts))
                return false;

            var nodoBodyStmts = (NodoBodyStmts)filhos.get(1);
            return nodoBodyStmts.ValidarSintaxe();
        }
        return true;
    }
}

package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoIfStmts extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1 &&
                tamanho != 2)
            return false;

        if(!filhos.get(0) instanceof NodoIfStmt nodoIfStmt)
            return false;
        if(!nodoIfStmt.ValidarSintaxe())
            return false;

        if(tamanho == 2){
            if(!(filhos.get(1) instanceof NodoIfStmts nodoIfStmts))
                return false;
            return nodoIfStmts.ValidarSintaxe();
        }
        return true;
    }
}

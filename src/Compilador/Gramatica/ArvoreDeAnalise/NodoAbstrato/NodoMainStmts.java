package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoMainStmts extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1 &&
        tamanho != 2)
            return false;

        if(!(filhos.getFirst() instanceof NodoMainStmt nodoMainStmt ))
            return false;
        if(!nodoMainStmt.ValidarSintaxe())
            return false;

        if(tamanho == 2){
            if(!(filhos.get(1) instanceof NodoMainStmts nodoMainStmts))
                return false;
            return nodoMainStmts.ValidarSintaxe();
        }
        return true;
    }
}

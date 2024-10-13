package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

public class NodoArgBin extends NodoAbstratoBase{
    @Override
    public boolean ValidarSintaxe() {
        var filhos = RetornarNodosFilhos();
        var tamanho = filhos.size();

        if(tamanho != 1)
            return false;

        return filhos.get(0) instanceof NodoName;
    }
}

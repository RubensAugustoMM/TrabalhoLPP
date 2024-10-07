package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;

public abstract class NodoAbstratoBase implements NodoBase {

    public abstract java.util.List<NodoBase> RetornarNodosFilhos();

    @Override
    public void AdicionarNodoFilho(NodoBase nodo) {

    }

    @Override
    public NodoBase RetornarNodoFilho(int posicao) {
        return null;
    }

    @Override
    public void DefinirNodoPai(NodoBase nodo) {

    }

    @Override
    public NodoBase RetornarNodoPai() {
        return null;
    }

    public boolean ValidarPredicado(){
        return true;
    }

    public boolean ValidarSintaxe(){
        return false;
    }

    public abstract boolean ValidarSintaxe(NodoAbstratoBase nodo);
}

package Compilador.Gramatica.ArvoreDeAnalise;

import java.util.List;

public interface NodoBase {
    List<NodoBase> RetornarNodosFilhos();

    void AdicionarNodoFilho(NodoBase nodo);

    NodoBase RetornarNodoFilho(int posicao);

    void DefinirNodoPai(NodoBase nodo);

    NodoBase RetornarNodoPai();

}

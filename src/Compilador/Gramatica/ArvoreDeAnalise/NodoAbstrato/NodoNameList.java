package Compilador.Gramatica.ArvoreDeAnalise.NodoAbstrato;

import Compilador.Gramatica.ArvoreDeAnalise.NodoBase;
import Compilador.Gramatica.ArvoreDeAnalise.NodoTerminal.NodoTerminal;
import Compilador.Gramatica.Tokens.TokenEnums;

import java.util.ArrayList;
import java.util.List;

public class NodoNameList extends NodoAbstratoBase {
    private NodoBase _pai;
    private List<NodoBase> _filhos = new ArrayList<NodoBase>();

    @Override
    public java.util.List<NodoBase> RetornarNodosFilhos() {
        return _filhos;
    }

    @Override
    public void AdicionarNodoFilho(NodoBase nodo) {
        _filhos.add(nodo);
    }

    @Override
    public NodoBase RetornarNodoFilho(int posicao) {
        return _filhos.get(posicao);
    }

    @Override
    public void DefinirNodoPai(NodoBase nodo) {
        _pai = nodo;
    }

    @Override
    public NodoBase RetornarNodoPai() {
        return _pai;
    }

    @Override
    public boolean ValidarSintaxe(NodoAbstratoBase nodo) {
        int tamanho = _filhos.size();

        if(tamanho == 2){
            if(_filhos.get(1) instanceof NodoTerminal) {
                var nodoFilho = (NodoTerminal)_filhos.get(1);
                if (nodoFilho.RetornarTipo() != TokenEnums.VIRGULA){
                    return false;
                }
            }
            else{
                return false;
            }
            if(_filhos.get(2) instanceof NodoNameList)
                return ValidarSintaxe((NodoNameList)_filhos.get(2));
        }

        return true;
    }
}

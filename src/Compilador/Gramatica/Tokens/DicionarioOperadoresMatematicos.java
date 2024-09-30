package Compilador.Gramatica.Tokens;

import java.util.HashMap;

public class DicionarioOperadoresMatematicos {
    private final HashMap<String, OperadoresMatematicosEnums> _dicionarioOperadoresMatematicos = new HashMap<String, OperadoresMatematicosEnums>();

    public DicionarioOperadoresMatematicos() {
        _dicionarioOperadoresMatematicos.put("+",OperadoresMatematicosEnums.OPERADOR_ADICAO);
        _dicionarioOperadoresMatematicos.put("-",OperadoresMatematicosEnums.OPERADOR_SUBTRACAO);
        _dicionarioOperadoresMatematicos.put("*",OperadoresMatematicosEnums.OPERADOR_MULTIPLICACAO);
        _dicionarioOperadoresMatematicos.put("/",OperadoresMatematicosEnums.OPERADOR_DIVISAO);
    }

    public OperadoresMatematicosEnums retornarTokenOperadorMatematico(String operador){
        return _dicionarioOperadoresMatematicos.get(operador);
    }
}

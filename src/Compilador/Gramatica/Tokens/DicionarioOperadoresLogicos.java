package Compilador.Gramatica.Tokens;

import java.util.HashMap;


//class onde é associada a string do operador logico ao enum
public final class DicionarioOperadoresLogicos {
    private final HashMap<String, OperadoresLogicosEnums> _dicionarioOperadoresLogicos = new HashMap<String, OperadoresLogicosEnums>();

    public DicionarioOperadoresLogicos() {
        _dicionarioOperadoresLogicos.put("eq", OperadoresLogicosEnums.OPERADOR_IGUAL);
        _dicionarioOperadoresLogicos.put("ne", OperadoresLogicosEnums.OPERADOR_NAO_IGUAL);
        _dicionarioOperadoresLogicos.put("lt", OperadoresLogicosEnums.OPERADOR_MENOR);
        _dicionarioOperadoresLogicos.put("le", OperadoresLogicosEnums.OPERADOR_MENOR_IGUAL);
        _dicionarioOperadoresLogicos.put("gt", OperadoresLogicosEnums.OPERADOR_MAIOR);
        _dicionarioOperadoresLogicos.put("ge", OperadoresLogicosEnums.OPERADOR_MAIOR_IGUAL);
    }

    public OperadoresLogicosEnums retornarTokenOperadorLogico(String string){
        return _dicionarioOperadoresLogicos.get(string);
    }
}
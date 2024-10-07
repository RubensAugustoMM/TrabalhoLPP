package Compilador.Gramatica.Tokens;

import java.util.HashMap;

public final class DicionarioTokens {
    private HashMap<String, TokenEnums> _dicionario = new HashMap<>();

    public DicionarioTokens() {
        _dicionario.put("class", TokenEnums.PALAVRA_CHAVE_CLASS);
        _dicionario.put("end_class", TokenEnums.PALAVRA_CHAVE_END_CLASS);
        _dicionario.put("method", TokenEnums.PALAVRA_CHAVE_METHOD);
        _dicionario.put("begin", TokenEnums.PALAVRA_CHAVE_BEGIN);
        _dicionario.put("end", TokenEnums.PALAVRA_CHAVE_END);
        _dicionario.put("end_method", TokenEnums.PALAVRA_CHAVE_END_METHOD);
        _dicionario.put("new", TokenEnums.PALAVRA_CHAVE_NEW);
        _dicionario.put("if", TokenEnums.PALAVRA_CHAVE_IF);
        _dicionario.put("end_if", TokenEnums.PALAVRA_CHAVE_END_IF);
        _dicionario.put("return", TokenEnums.PALAVRA_CHAVE_RETURN);
        _dicionario.put("io", TokenEnums.PALAVRAS_CHAVE_IO);
        _dicionario.put("=", TokenEnums.OPERADOR_IGUALDADE);
        _dicionario.put("+", TokenEnums.OPERADOR_ADICAO);
        _dicionario.put("-", TokenEnums.OPERADOR_SUBTRACAO);
        _dicionario.put("*", TokenEnums.OPERADOR_MULTIPLICACAO);
        _dicionario.put("/", TokenEnums.OPERADOR_DIVISAO);
        _dicionario.put("ge", TokenEnums.OPERADOR_MAIOR_IGUAL);
        _dicionario.put("eq", TokenEnums.OPERADOR_IGUAL);
        _dicionario.put("ne", TokenEnums.OPERADOR_NAO_IGUAL);
        _dicionario.put("lt", TokenEnums.OPERADOR_MENOR);
        _dicionario.put("le", TokenEnums.OPERADOR_MENOR_IGUAL);
        _dicionario.put("gt", TokenEnums.OPERADOR_MAIOR);
        _dicionario.put("\n", TokenEnums.QUEBRA_LINHA);
        _dicionario.put("(", TokenEnums.PARENTESES_ESQUERDO);
        _dicionario.put(")", TokenEnums.PARENTESES_DIREITO);
        _dicionario.put(",", TokenEnums.VIRGULA);
    }

    public  TokenEnums RetornarTipo(String str) {
        return _dicionario.get(str);
    }
}

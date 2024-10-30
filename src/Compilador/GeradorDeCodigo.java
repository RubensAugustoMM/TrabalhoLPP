package Compilador;

import Compilador.Gramatica.ListaDeAnalise.Classe.ComandoClasseEnums;
import Compilador.Gramatica.ListaDeAnalise.Classe.NodoClasse;
import Compilador.Gramatica.ListaDeAnalise.Metodo.ComandoMetodoEnum;
import Compilador.Gramatica.ListaDeAnalise.Metodo.NodoMetodo;
import Compilador.Gramatica.ListaDeAnalise.NodoBase;
import Compilador.Gramatica.ListaDeAnalise.NodoContainer;
import Compilador.Gramatica.ListaDeAnalise.Variavel.ComandoVariavelEnums;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoDeclaracaoVariavel;
import Compilador.Gramatica.ListaDeAnalise.Variavel.NodoVariavel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeradorDeCodigo {
    private NodoBase _nodoInicial;
    private NodoBase _nodoAtual;
    private int _index;
    private String _codigo;

    private final String _padraoNome = "^(?!class|method|begin|self|vars|end|if|return|" +
                                        "eq|ne|lt|le|gt|ge|new|main|io|end-method|end-class|" +
                                        "else|end-if)[a-zA-Z[^\\s]]+";

    public GeradorDeCodigo(String codigo) {
        _codigo = codigo;
    }

    public String GerarByteCode(){
             GerarListaDeAnalise();
             var byteCode = GerarCodigo(_nodoInicial);

         return byteCode;
    }

    private String GerarCodigo(NodoBase nodo) {
        if(nodo == null)
            return "";

        if(nodo.RetornarProximoNodo() == null)
            return nodo.RetornaTextoComando() + "\n";

        return nodo.RetornaTextoComando() +"\n"+ GerarCodigo(nodo.RetornarProximoNodo());
    }


    private void GerarListaDeAnalise() {
        for(_index = 0; VerificarFimDoArquivo(_index);_index++) {
            if (IgnorarCaractere(_codigo.charAt(_index)))
                continue;

            Pattern padrao = Pattern.compile("^vars");
            Matcher combinadorVars = padrao.matcher(_codigo.substring(_index));
            if(combinadorVars.find()) {
                ObterDeclaracoesDeVariaveis(_codigo.substring(combinadorVars.end()+_index));
                _index += combinadorVars.end();
                continue;
            }

            padrao = Pattern.compile("^class");
            Matcher combinadorClass = padrao.matcher(_codigo.substring(_index));
            if(combinadorClass.find()){
                ObterDeclaracaoDeClasse(_codigo.substring(combinadorClass.end()+_index));
                _index += combinadorClass.end();
                continue;
            }

            padrao = Pattern.compile("^method");
            Matcher combinadorMethod = padrao.matcher(_codigo.substring(_index));
            if(combinadorMethod.find()){
                ObterDefinicaoDeMetodo(_codigo.substring(combinadorMethod.end()+_index));
                _index += combinadorMethod.end();
                continue;
            }

            padrao = Pattern.compile("^begin");
            Matcher combinadorBegin = padrao.matcher(_codigo.substring(_index));
            if(combinadorBegin.find()){
                ObterNodoBegin(_codigo.substring(combinadorBegin.end()+_index));
                _index += combinadorBegin.end();
                continue;
            }

            padrao = Pattern.compile("^end-method");
            Matcher combinadorEndMethod = padrao.matcher(_codigo.substring(_index));
            if(combinadorEndMethod.find()){
                ObterNodoEndMethod(_codigo.substring(combinadorEndMethod.end()+_index));
                _index += combinadorEndMethod.end();
                continue;
            }

            padrao = Pattern.compile("^end-class");
            Matcher combinadorEndClass = padrao.matcher(_codigo.substring(_index));
            if(combinadorEndClass.find()){
                ObterNodoEndClass(_codigo.substring(combinadorEndClass.end()+_index));
                _index += combinadorEndClass.end();
                continue;
            }

            padrao = Pattern.compile("^main");
            Matcher combinadorMain = padrao.matcher(_codigo.substring(_index));
            if(combinadorMain.find()){
                ObterNodoMetodoMain();
                _index += combinadorMain.end();
                continue;
            }

            padrao = Pattern.compile("^return");
            Matcher combinadorReturn = padrao.matcher(_codigo.substring(_index));
            if(combinadorReturn.find()){
                ObterNodoMetodoReturn(_codigo.substring(combinadorReturn.end()+_index));
                _index += combinadorReturn.end();
                continue;
            }

            padrao = Pattern.compile(_padraoNome);
            Matcher combinadorPadraoNome = padrao.matcher(_codigo.substring(_index));
            if(combinadorPadraoNome.find()){
                ObterNodoVariavel(_codigo.substring(_index));
                _index += combinadorPadraoNome.end();
            }
        }
    }

    private void ObterNodoMetodoReturn(String substring) {
        for(int i=0;substring.charAt(i)!= '\n';i++){
            Pattern padrao = Pattern.compile(_padraoNome);
            Matcher combinador = padrao.matcher(substring.substring(i));
            if(combinador.find()){
                AdicionarNodo(new NodoMetodo(
                        substring.substring(combinador.start(),combinador.end()),
                        ComandoMetodoEnum.COMANDO_METODO_RET,
                        _nodoAtual
                ));
                _index += combinador.end();
                return;
            }
        }

        AdicionarNodo(new NodoMetodo(
                null,
                ComandoMetodoEnum.COMANDO_METODO_RET,
                _nodoAtual
        ));
    }

    private void ObterNodoVariavel(String substring) {
        NodoContainer listaTemp = new NodoContainer(null);

        for(int i = 0;substring.charAt(i) != '\n';i++) {
            Pattern padrao = Pattern.compile("^[a-zA-Z]+\\.[a-zA-Z]+");
            Matcher combinador = padrao.matcher(substring.substring(i));
            if(combinador.find()) {
                ObterNodoGet(
                        listaTemp,
                        substring.substring(combinador.start(), combinador.end()));
                i = combinador.end();
                _index = combinador.end();
            }
        }
    }

    private void ObterNodoGet(NodoContainer nodoListaContainer,String substring){
        Pattern padrao = Pattern.compile("^[a-zA-Z]+\\.");
        Matcher combinador = padrao.matcher(substring);
        if(combinador.find()) {
            var nodo = new NodoVariavel(
                    substring.substring(combinador.start(), combinador.end()),
                    ComandoVariavelEnums.COMANDO_VARIAVEL_GET,
                    nodoListaContainer.ObterNodo()
            );
            _index = combinador.end();

            if (nodoListaContainer.ObterNodo() == null)
                nodoListaContainer.DefinirNodo(nodo);
            else
                AdicionarNodoListaTemp(nodo, nodoListaContainer);
        }

        padrao = Pattern.compile("^\\.[a-zA-Z]+");
        combinador = padrao.matcher(substring);
        if(combinador.find()) {
            var nodo = new NodoVariavel(
                    substring.substring(combinador.start()+1, combinador.end()),
                    ComandoVariavelEnums.COMANDO_VARIAVEL_GET,
                    nodoListaContainer.ObterNodo()
            );
            _index = combinador.end();

            if (nodoListaContainer.ObterNodo() == null)
                nodoListaContainer.DefinirNodo(nodo);
            else
                AdicionarNodoListaTemp(nodo, nodoListaContainer);
        }
    }

    private void ObterNodoMetodoMain() {
         AdicionarNodo(new NodoMetodo(
            "main",
            ComandoMetodoEnum.COMANDO_METHOD_DEFINICAO,
            _nodoAtual
        ));
    }

    private void ObterNodoEndClass(String substring) {
        var nodoClass = (NodoClasse)RetornaPrimeiroNodo(NodoClasse.class);
        var nome = nodoClass.ObterNome();

        AdicionarNodo(new NodoClasse(
                nome,
                ComandoClasseEnums.COMANDO_END_CLASS,
                _nodoAtual
        ));
    }

    private void ObterNodoEndMethod(String substring) {
        var nodoMetodo = (NodoMetodo)RetornaPrimeiroNodo(NodoMetodo.class);
        var nome = nodoMetodo.ObterNome();

        AdicionarNodo(new NodoMetodo(
                nome,
                ComandoMetodoEnum.COMANDO_END_METHOD,
                _nodoAtual
        ));
    }

    private void ObterNodoBegin(String substring) {
        var nodoMetodo = (NodoMetodo)RetornaPrimeiroNodo(NodoMetodo.class);
        var nome = nodoMetodo.ObterNome();

        AdicionarNodo(new NodoMetodo(
                nome,
                ComandoMetodoEnum.COMANDO_BEGIN_METHOD,
                _nodoAtual
        ));
    }

    private void ObterDefinicaoDeMetodo(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
        NodoMetodo nodo = null;
        int j;
        for(j = 0; substring.charAt(j) != '(';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(substring.substring(j));
            if(combinador.find()){
                    nodo = new NodoMetodo(
                        substring.substring(combinador.start(), combinador.end() -1),
                        ComandoMetodoEnum.COMANDO_METHOD_DEFINICAO,
                        _nodoAtual
                    );

                    AdicionarNodo(nodo);
                    _index += combinador.end()+j;
                    return;
            }
        }

        Matcher combinador = padrao.matcher(substring.substring(j));
        for(; substring.charAt(j) != ')';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            if(combinador.find() && nodo != null){
                nodo.AdicionarAtributo(new NodoVariavel(
                        substring.substring(combinador.start(),combinador.end() +1),
                        ComandoVariavelEnums.COMANDO_VARIAVEL_ATRIBUTO,
                        nodo
                ));
            }
        }
        _index = combinador.end()+1;
    }

    private void ObterDeclaracaoDeClasse(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
        for(int j = 0;substring.charAt(j) != '\n';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            Matcher combinador = padrao.matcher(substring.substring(j));
            if(combinador.find()){
                var nodo = new NodoClasse(
                        substring.substring(combinador.start(),combinador.end() +1),
                        ComandoClasseEnums.COMANDO_CLASSE_DEFINICAO,
                        _nodoAtual
                );
                _index += combinador.end()+j;

                AdicionarNodo(nodo);
                return;
            }
        }
    }

    private void ObterDeclaracoesDeVariaveis(String substring) {
        Pattern padrao = Pattern.compile(_padraoNome);
        Pattern padraoIndesejavel = Pattern.compile("^class|^method|^begin|^self|^vars|^end|^if|^return|" +
                                                    "^eq|^ne|^lt|^le|^gt|^ge|^new|^main|^io|^end-method|^end-class|^else|^end-if");
        Matcher combinador = null;
        Matcher combinadorIndesejaveis = null;

        var nodoDeclaracaoVariavel = new NodoDeclaracaoVariavel(_nodoAtual, ComandoVariavelEnums.COMANDO_VARIAVEL_VAR);
        int j = 0;

        for(;substring.charAt(j) != '\n';j++){
            if(IgnorarCaractere(substring.charAt(j)))
                continue;

            combinador = padrao.matcher(substring.substring(j));
            combinadorIndesejaveis = padraoIndesejavel.matcher(substring.substring(j));

            if(combinadorIndesejaveis.find()){
                break;
            }

            if(combinador.find()){
                nodoDeclaracaoVariavel.AdicionarVariavel(new NodoVariavel(
                        substring.substring(combinador.start(),combinador.end()),
                        ComandoVariavelEnums.COMANDO_VARIAVEL_VAR,
                        nodoDeclaracaoVariavel
                ));
                j += combinador.end();
            }
        }
        if(combinador != null)
            _index += j-1;

        AdicionarNodo(nodoDeclaracaoVariavel);
    }

    private void AdicionarNodo(NodoBase nodo){
        if(_nodoInicial == null){
            _nodoInicial = nodo;
            _nodoAtual = nodo;
            return;
        }

        AdicionarNodo(nodo, _nodoInicial);
    }

    private void AdicionarNodo(NodoBase nodo, NodoBase proximoNodo){
        if(proximoNodo.RetornarProximoNodo() == null){
            proximoNodo.DefinirProximoNodo(nodo);
            _nodoAtual = nodo;
            return;
        }

        AdicionarNodo(nodo, proximoNodo.RetornarProximoNodo());
    }

    private void AdicionarNodoListaTemp(NodoBase nodoAdicionar, NodoContainer lista){
        if(lista.ObterNodo() == null){
            lista.DefinirNodo(nodoAdicionar);
            nodoAdicionar.DefinirNodoAnterior(lista.ObterNodo());
            return;
        }

        var nodoContainer = new NodoContainer(lista.ObterNodo().RetornarProximoNodo());
        AdicionarNodoListaTemp(nodoAdicionar,nodoContainer);
    }

    private NodoBase RetornaPrimeiroNodo(Class<?> tipo){
        if(_nodoAtual == null)
            return null;

        return RetornaPrimeiroNodo(tipo,_nodoAtual);
    }

    private NodoBase RetornaPrimeiroNodo(Class<?> tipo, NodoBase nodo){
        if(tipo == nodo.getClass())
            return nodo;

        return RetornaPrimeiroNodo(tipo,_nodoAtual.RetornarNodoAnterior());
    }

    private boolean VerificarFimDoArquivo(int i){
        return i < _codigo.length();
    }

    private boolean IgnorarCaractere(char charactere) {
        char[] characteresIgnorados = {' ', '\n', '\r', '\t' };
        for (char characteresIgnorado : characteresIgnorados) {
            if (characteresIgnorado == charactere) {
                return true;
            }
        }
        return false;
    }
}

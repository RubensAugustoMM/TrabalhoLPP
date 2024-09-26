package Utilitarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Arquivos {
    private Arquivos() {}
    public static String LerArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);

        if(!arquivo.exists()) {
            throw new RuntimeException("O arquivo especificado nao existe!");
        }
        return arquivo.toString();
    }

    public static void CriarArquivo(String nome) {
        File arquivo = new File(nome);

        try {
            if(arquivo.createNewFile()){
                System.out.println("Arquivo Criado com sucesso.");
            }else {
                System.out.println("Nome de arquivo ja existe no repositorio!");
            }

        }catch (IOException excecao){
            throw new RuntimeException(excecao);
        }
    }

    public static void EscreverArquivo(String nome, String texto) {
        try{
            FileWriter escritor = new FileWriter(nome);
            escritor.write(texto);
        }
        catch (IOException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
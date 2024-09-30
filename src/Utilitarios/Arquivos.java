package Utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class Arquivos {
    private Arquivos() {}
    public static String LerArquivo(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            Scanner leitor = new Scanner(arquivo);
            StringBuilder texto = new StringBuilder();

            while(leitor.hasNextLine()) {
               texto.append(leitor.nextLine());
            }

            leitor.close();
            return texto.toString();
        }
        catch (FileNotFoundException excecao) {
           System.out.println(excecao.getMessage());
        }
        return null;
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

    public static void CriarArquivo(String nome, String texto) {
        File arquivo = new File(nome);

        try {
            if(arquivo.createNewFile()){
                System.out.println("Arquivo Criado com sucesso.");
            }else {
                System.out.println("Nome de arquivo ja existe no repositorio!");
            }
            EscreverArquivo(nome, texto);
        }catch (IOException excecao){
            throw new RuntimeException(excecao);
        }
    }

    public static void EscreverArquivo(String nome, String texto) {
        try{
            FileWriter escritor = new FileWriter(nome);
            escritor.write(texto);
            escritor.close();
        }
        catch (IOException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
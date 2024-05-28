package controller;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DiretorioController {

    public DiretorioController() {
        super();
    }

    public void listarArquivosOrdenadosPorTamanho(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);

        if (!diretorio.exists() || !diretorio.isDirectory()) {
            System.out.println("O caminho fornecido não é um diretório válido.");
            return;
        }

        File[] arquivos = diretorio.listFiles(File::isFile);

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("O diretório está vazio ou não contém arquivos.");
            return;
        }

        Arrays.sort(arquivos, Comparator.comparingDouble(File::length));

        for (File arquivo : arquivos) {
            double tamanhoEmMB = ((double) arquivo.length() / 1024) / 1024;
            System.out.printf("Arquivo: %s, Tamanho: %.2f MB%n", arquivo.getName(), tamanhoEmMB);
        }
    }
}

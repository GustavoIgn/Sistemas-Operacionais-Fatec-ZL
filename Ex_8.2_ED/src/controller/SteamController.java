package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SteamController {

    public SteamController() {
        super();
    }

    public void filtrarMedia(String ano, String mes, int mediaMin) throws IOException {
        try {
            FileReader fileReader = null;
            fileReader = new FileReader("C:\\TEMP\\SteamCharts.csv");
            BufferedReader buffer = new BufferedReader(fileReader);
            buffer.readLine();
            String linha = buffer.readLine();
            while (linha != null) {
                String[] dados = linha.split(",");
                String anoRegistro = dados[1];
                String mesRegistro = dados[2];
                if (anoRegistro.equals(ano) && mesRegistro.equals(mes)) {
                    double mediaJogadores = Double.parseDouble(dados[3]);
                    if (mediaJogadores >= mediaMin) {
                        System.out.println(dados[0] + " | " + mediaJogadores);
                    }
                }
                linha = buffer.readLine();
            }
            buffer.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void gerarArquivo(String ano, String mes, String diretorio, String nomeArquivo) throws Exception {
        File diretorioFile = new File(diretorio);
        if (!diretorioFile.exists()) {
            System.err.println("Diretório Inválido");
        }

        File arquivo = new File(diretorio, nomeArquivo + ".csv");
        FileWriter fileWriter = new FileWriter(arquivo);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        try {
            FileReader fileReader = new FileReader("C:\\TEMP\\SteamCharts.csv");
            BufferedReader buffer = new BufferedReader(fileReader);
            buffer.readLine(); // Ignorar o cabeçalho

            String linha;
            while ((linha = buffer.readLine()) != null) {
                String[] dados = linha.split(",");
                String anoRegistro = dados[1];
                String mesRegistro = dados[2];
                if (anoRegistro.equals(ano) && mesRegistro.equals(mes)) {
                    String nomeJogo = dados[0];
                    double mediaJogadores = Double.parseDouble(dados[3]);
                    printWriter.println(nomeJogo + ";" + mediaJogadores);
                }
            }

            buffer.close();
            fileReader.close();
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

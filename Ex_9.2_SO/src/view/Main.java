package view;

import controller.DiretorioController;

public class Main {
    public static void main(String[] args) {

        DiretorioController dCont = new DiretorioController();

        // Caminho do diretório a ser listado
        String caminhoDiretorio = "C:\\Users\\gustavo e guilherme\\Documents\\Fatec & Etec";

        // Listar arquivos ordenados por tamanho
        dCont.listarArquivosOrdenadosPorTamanho(caminhoDiretorio);
    }
}

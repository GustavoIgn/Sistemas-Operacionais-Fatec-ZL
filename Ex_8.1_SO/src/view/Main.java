package view;

import java.io.IOException;

import controller.ArquivoController;
import controller.IArquivosController;

public class Main {
    
    public static void main(String[] args) {

        IArquivosController arq = new ArquivoController();
        String path = "C:\\TEMP\\";
        String name = "generic_food.csv";

        try {
            //arq.readDir(path);
            //arq.createFile(path,  name);
            arq.checkFile(path, name);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

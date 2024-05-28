package view;

import br.edu.fateczl.pilhaString.Pilha;
import controller.FifaController;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Lista;

public class Main {

    public static void main(String[] args) {

        int opc = 0;
        FifaController fifa = new FifaController();
        String caminho = "C:\\TEMP\\";
        String nome = "data.csv";
        Pilha pilha = new Pilha();
        Lista<String> lista = new Lista<>();
        while (opc != 9) {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1- Empilhar Brasileiros\n2- Desempilhar Brasileiros Acima de 80\n3- Listar Revelações\n4- Listar Boas Revelações\n9- Finalizar"));

                switch (opc) {
                    case 1:
                        pilha = fifa.empilhaBrasileiros(caminho, nome);
                        break;
                    case 2:
                        fifa.desempilhaBonsBrasileiros(pilha);
                        break;
                    case 3:
                        lista = fifa.listaRevelacoes(caminho, nome);
                        break;
                    case 4:
                        fifa.buscaListaBonsJovens(lista);
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcao Inválida");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}

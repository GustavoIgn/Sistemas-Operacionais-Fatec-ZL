package view;

import javax.swing.JOptionPane;
import controller.SteamController;

public class Main {

    public static void main(String[] args) throws Exception {

        SteamController steamCont = new SteamController();
        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu \n1- Pesquisar \n2- Criar csv\n9- Finalizar"));
            switch (opc) {
                case 1:
                    String mes = JOptionPane.showInputDialog("Digite o mês (Inglês)");
                    String ano = JOptionPane.showInputDialog("Digite o ano");
                    int media = Integer.parseInt(JOptionPane.showInputDialog("Digite a média de jogadores ativos minima"));
                    System.out.println("Jogos com média de jogadores ativos >= " + media + " em " + mes + " de " + ano + ":");
                    steamCont.filtrarMedia(ano, mes, media);
                    break;
                case 2:
                    mes = JOptionPane.showInputDialog("Digite o mês");
                    ano = JOptionPane.showInputDialog("Digite o ano");
                    String nome = JOptionPane.showInputDialog("Digite o nome do arquivo a ser criado");
                    System.out.println("Gerando arquivo com dados de " + mes + " de " + ano + "...");
                    steamCont.gerarArquivo(ano, mes, "C:\\TEMP\\", nome);
                    System.out.println("Sucesso!!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválido.");
            }
        }
    }

}

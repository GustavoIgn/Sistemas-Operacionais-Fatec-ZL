package view;

import javax.swing.JOptionPane;

import controller.ConverteController;

public class Main {
    public static void main(String[] args) {
        ConverteController controller = new ConverteController();
        boolean valido = false;
        while (!valido) {
        	int decimal = Integer.parseInt(JOptionPane.showInputDialog("Digite um número decimal (máximo 1000): "));
            if (decimal > 1000 && decimal >= 0) {
                JOptionPane.showMessageDialog(null, "O número decimal deve ser um positivo, no máximo 1000.");
            } else {
            	valido = true;
            	String binario = controller.decToBin(decimal);
                System.out.println("O número binário correspondente é: " + binario);
            }
        }     
    }
}

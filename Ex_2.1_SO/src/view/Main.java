package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesCont = new RedesController();
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1-Mostrar ip\n2-Mostrar ping\n 9 - Finalizar"));
			switch (opc) {
			case 1:
				redesCont.ip();
				break;
			case 2:
				redesCont.ping();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa Finalizado!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcão Inválida!");
			}
		}
	}
}
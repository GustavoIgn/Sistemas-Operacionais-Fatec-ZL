package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kCont = new KillController();
		
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1-Listar Processos\n2-Matar Por Pid\n3-Matar por Nome\n9 - Finalizar"));
			switch (opc) {
			case 1:
				kCont.listaProcessos();
				break;
			case 2:
				String pid = JOptionPane.showInputDialog("Insira o Pid");
				kCont.mataPid(pid);
				break;
			case 3:
				String nomeProc = JOptionPane.showInputDialog("Insira o nome do Processo");
				kCont.mataNome(nomeProc);
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

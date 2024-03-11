package controller;

import javax.swing.JOptionPane;

public class Ex_2_Controller {
	public Ex_2_Controller() {
		super();
	}
	
	public String InserirTexto() {
		String texto = JOptionPane.showInputDialog("Insira o Texto:");
		System.out.println("Texto Inserido: " + texto);
		return texto;
	}
	
	public int DividirTexto (String texto) {
		String[] vetorString = texto.split(";");
		
		return vetorString.length;
	}
}

package view;

import controller.Ex_2_Controller;

public class Ex_2_Principal {
	public static void main(String[] args) {
		Ex_2_Controller cont = new Ex_2_Controller();
		String texto = cont.InserirTexto();
		
		System.out.println("Quantidade de palavras no texto: " + cont.DividirTexto(texto));
	}
}

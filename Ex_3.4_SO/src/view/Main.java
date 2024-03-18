package view;

import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {
		int tamanho, saltoMax;
		tamanho = 50;

		Thread[] sapos = new ThreadSapo[5]; // Array para armazenar as threads

		for (int i = 0; i < 5; i++) {
			String nome = "Sapinho " + (i + 1);
			saltoMax = (int) (Math.random() * 9) + 1;
			sapos[i] = new ThreadSapo(nome, saltoMax, tamanho); // Instanciando a thread
			sapos[i].start(); // Iniciando a thread
		}
	}

}

package controller;

import java.util.ArrayList;
import java.util.List;

public class ThreadSapo extends Thread {

	private int saltoMax;
	private int tamanho;
	private int distPercorrida;
	private int totalSaltos;
	private String nome;
	private static List<ThreadSapo> saposTerminados = new ArrayList<>();

	public ThreadSapo(String nome, int saltoMax, int tamanho) {
		this.nome = nome;
		this.saltoMax = saltoMax;
		this.tamanho = tamanho;
		this.distPercorrida = 0;
		this.totalSaltos = 0;
	}

	@Override
	public void run() {
		while (distPercorrida < tamanho) {
			int tamanhoSalto = (int) (Math.random() * saltoMax) + 1;
			distPercorrida += tamanhoSalto;
			if (distPercorrida > tamanho) {
				distPercorrida = tamanho; // Garantindo que a distância máxima não seja excedida
			}
			totalSaltos++;
			System.out.println(nome + " pulou " + tamanhoSalto + " metros e percorreu " + distPercorrida + " metros.");
			try {
				// Possivel pausa por 1 segundo...
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized (saposTerminados) {
			saposTerminados.add(this); // Adiciona este sapo à lista de sapos que terminaram a corrida
		}

		System.out.println(nome + " chegou!");
		System.out.println(nome + " chegou em " + totalSaltos + " saltos!");
		imprimirTabelaColocacao();
	}

	private static void imprimirTabelaColocacao() {
		System.out.println("\nTabela de Colocação:");
		int colocacao = 1;
		synchronized (saposTerminados) {
			for (ThreadSapo sapo : saposTerminados) {
				System.out.println("Colocação " + colocacao + ": " + sapo.nome + " - Saltos: " + sapo.totalSaltos
						+ " - Maior Salto Possível: " + sapo.saltoMax);
				colocacao++;
			}
		}
	}
}
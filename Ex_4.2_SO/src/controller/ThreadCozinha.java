package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {
	private int idPrato, tempoMin, tempoMax;
	private String nome;
	private Semaphore semaforo;

	public ThreadCozinha(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		if (idPrato % 2 == 0) {
			nome = "Lasanha a Bolonhesa";
			tempoMin = 600;
			tempoMax = 600;
			cozinhar(tempoMin, tempoMax, nome);
		} else {
			nome = "Sopa de Cebola";
			tempoMin = 500;
			tempoMax = 300;
			cozinhar(tempoMin, tempoMax, nome);
		}
	}

	private void cozinhar(int tempoMin2, int tempoMax2, String nome2) {
		System.out.println("Cozinhando: " + nome + ", id: " + idPrato);
		int percentualCozimento = 0;
		int tempoTotal = (int) (Math.random() * (tempoMax2 - tempoMin2) + tempoMin2);

		while (percentualCozimento < tempoTotal) {
			try {
				sleep(100);
				System.out.println("Percentual do prato " + idPrato + ": " + percentualCozimento / 10 + "%");
				percentualCozimento += 100;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Prato: " + nome + ", id: " + idPrato + " pronto pra entrega.");

		try {
			semaforo.acquire();
			realizarEntrega(nome);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}



	private void realizarEntrega(String nome) {
		System.out.println("Entrega do Prato " + nome + " id: " + idPrato + " em andamento.");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Prato " + idPrato + " entregue, pedido finalizado.");
	}
	
}
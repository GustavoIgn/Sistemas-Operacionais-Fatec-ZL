package controller;

import java.util.concurrent.Semaphore;

public class Cassino extends Thread {
	private int id;
	private Semaphore semaforo;
	private static int[] placar = new int[10];
	private static int[] tentativa = new int[10];
	private static int podio = 0;
	private static int[] premio = { 5000, 4000, 3000 };

	public Cassino(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			while (true) {
				semaforo.acquire();
				if (placar[id - 1] >= 5 || podio >= 3) {
					semaforo.release();
					break;
				}
				tentativa[id - 1]++;
				girarDados();
				semaforo.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void girarDados() {
		int v1 = (int) (Math.random() * 6 + 1);
		int v2 = (int) (Math.random() * 6 + 1);

		System.out.println("Jogador " + id + " -- Tentativa " + tentativa[id - 1] + " -- Pontos: " + placar[id - 1]);
		if (v1 + v2 == 7 || v1 + v2 == 11) {
			placar[id - 1]++;
			if (placar[id - 1] == 5) {
				podio++;
				System.out.println("Jogador " + id + " -- Tentativa " + tentativa[id - 1] + " -- Pontos: " + placar[id - 1]);
				System.out.println("Competidor " + id + " ganhou " + premio[podio - 1] + ",00\n");
			}
		}

		try {
			Thread.sleep(500); // suspense
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

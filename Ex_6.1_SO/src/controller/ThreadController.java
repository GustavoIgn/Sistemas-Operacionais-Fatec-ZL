package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	Semaphore semaforo;
	int idCarro, sentido;;
	static boolean[] validaSentido = new boolean[4]; // caso seja obrigatorio sentidos diferentes, porém 4 carros apenas

	public ThreadController(Semaphore semaforo, int idCarro) {
		this.semaforo = semaforo;
		this.idCarro = idCarro;
	}

	@Override
	public void run() {
		sentido = (int) (Math.random()*4);
		while (validaSentido[sentido]) {
			sentido = (int) (Math.random()*4);
		}
		validaSentido[sentido] = true;

		try {
			semaforo.acquire();
			passando();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void passando() {
		String[] txtSentido = { "Norte para Sul", "Leste para Oeste", "Sul para Norte", "Oeste para Leste" };

		switch (sentido + 1) {
		case 1: // Baixo
			System.out.println("Carro " + idCarro + " dirigindo de " + txtSentido[sentido]);
			break;
		case 2: // Esquerda
			System.out.println("Carro " + idCarro + " dirigindo de " + txtSentido[sentido]);
			break;
		case 3: // Cima
			System.out.println("Carro " + idCarro + " dirigindo de " + txtSentido[sentido]);
			break;
		case 4: // Direita
			System.out.println("Carro " + idCarro + " dirigindo de " + txtSentido[sentido]);
			break;
		default:
			System.out.println("Eita, você não pode passar por aí agora");
		}

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

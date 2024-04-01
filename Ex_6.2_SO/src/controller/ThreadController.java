package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	Semaphore semaforo;
	int idPessoa, mostrarM;

	public ThreadController(Semaphore semaforo, int idPessoa) {
		this.semaforo = semaforo;
		this.idPessoa = idPessoa;
	}

	@Override
	public void run() {
		caminhando();
		try {
			semaforo.acquire();
			passando();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void caminhando() {
		int tamanho = 200;
        int distanciaPercorrida = 0;
        int passo = (int) (Math.random() * 3) + 4;  // Passo entre 4 e 6 metros
        mostrarM = passo;
        
        while (distanciaPercorrida < tamanho) {
            if (distanciaPercorrida + passo > tamanho) {
                passo = tamanho - distanciaPercorrida;
            }
            distanciaPercorrida += passo;
            
            if(distanciaPercorrida >= mostrarM) {
				System.out.println("Pessoa " + idPessoa + " andou " + mostrarM + "m.");
				mostrarM += passo;
			}
            
            try {
                Thread.sleep(1000);  // Espera 1 segundo entre os passos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

	private void passando() {
		int tempo = (int) (Math.random() * 1001) + 1000;

		System.out.println("Pessoa " + idPessoa + " abrindo a porta");

		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Pessoa " + idPessoa + " passou pela porta" );
	}

}

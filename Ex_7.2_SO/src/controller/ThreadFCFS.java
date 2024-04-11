package controller;

import java.util.concurrent.Semaphore;

public class ThreadFCFS extends Thread {

	private int id;
	private Semaphore semaforo;

	public ThreadFCFS(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			processos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void processos() {
		int tempo = (int) (Math.random() * 117 + 4);
		System.out.println("Processo: " + id + " -- Iniciado.");
		
		try {
			Thread.sleep(tempo * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Processo: " + id + " -- Finalizado -- Tempo: " + tempo + "s.");
	}

}

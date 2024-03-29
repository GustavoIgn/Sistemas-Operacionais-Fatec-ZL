package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	Semaphore semaforo;
	int idAviao;

	public ThreadController(int idAviao, Semaphore semaforo) {
		this.semaforo = semaforo;
		this.idAviao = idAviao;
	}

	@Override
	public void run() {
		try {
			
			semaforo.acquire();

			if (idAviao % 2 == 0) {
				// Pista Norte
				System.out.println("Avião " + idAviao + " utilizando a Pista Norte.");
			} else {
				// Pista Sul
				System.out.println("Avião " + idAviao + " utilizando a Pista Sul.");
			}

			manobrar();
			taxiar();
			decolar();
			afastar();

			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void manobrar() {
		try {
			int tempo = (int) (Math.random() * 400) + 300;
			Thread.sleep(tempo);
			System.out.println("Avião " + idAviao + " manobrando.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void taxiar() {
		try {
			int tempo = (int) (Math.random() * 501) + 500;
			Thread.sleep(tempo);
			System.out.println("Avião " + idAviao + " taxeando.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void decolar() {
		try {
			int tempo = (int) (Math.random() * 201) + 600;
			Thread.sleep(tempo);
			System.out.println("Avião " + idAviao + " decolando.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void afastar() {
		try {
			int tempo = (int) (Math.random() * 501) + 300;
			Thread.sleep(tempo);
			System.out.println("Avião " + idAviao + " afastando da área.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package view;

import java.util.concurrent.Semaphore;

import controller.ThreadFCFS;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);

		for (int i = 0; i < 20; i++) {
			ThreadFCFS t = new ThreadFCFS(i, semaforo);
			t.start();
		}
		
		System.out.println("Simulação finalizada.");
	}
}

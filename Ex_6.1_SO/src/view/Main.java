package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		int carrosMax = 4;
		for (int i = 1; i <= carrosMax; i++) {
			ThreadController t = new ThreadController(semaforo, i);
			t.start();
		}
	}
}

package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);

		for (int i = 1; i <= 12; i++) {
			ThreadController threadCont = new ThreadController(i, semaforo);
			threadCont.start();
		}

	}
}

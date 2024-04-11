package view;

import java.util.concurrent.Semaphore;

import controller.Cassino;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < 10; i++) {
			Cassino cassino = new Cassino(i + 1, semaforo);
			cassino.start();
		}
	}
}

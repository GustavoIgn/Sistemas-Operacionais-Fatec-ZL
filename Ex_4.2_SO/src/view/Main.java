package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozinha;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int i = 1; i < 6; i++) {
			Thread t = new ThreadCozinha(i, semaforo);
			t.start();
		}
	}
}

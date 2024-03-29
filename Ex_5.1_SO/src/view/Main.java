package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforoTochaPedra = new Semaphore(1);
		Semaphore semaforoPorta= new Semaphore(1);

		for (int i = 1; i <=  4; i++) {
			Thread t = new ThreadController(i, semaforoTochaPedra, semaforoPorta);
			t.start();
		}

	}

}

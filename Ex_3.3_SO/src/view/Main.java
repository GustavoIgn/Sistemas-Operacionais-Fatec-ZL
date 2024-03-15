package view;

import controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {
		int vt[] = new int[1000];

		for (int i = 0; i < 1000; i++) {
			vt[i] = (int) (Math.random() * 99) + 1;
		}
		
		Thread t1 = new ThreadVetor(1, vt);
		Thread t2 = new ThreadVetor(2, vt);
		t2.start();
		t1.start();
	}

}

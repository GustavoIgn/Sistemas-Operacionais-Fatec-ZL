package view;

import controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		int mat[][] = new int[3][5];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				mat[i][j] = (int) (Math.random() * 90) + 10;
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(" ");
		}

		for (int i = 0; i < 3; i++) {
			Thread t = new ThreadController(mat[i], i);
			t.start();
		}
	}

}

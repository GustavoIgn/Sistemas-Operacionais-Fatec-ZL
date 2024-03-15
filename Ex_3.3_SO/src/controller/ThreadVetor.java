package controller;

public class ThreadVetor extends Thread {

	private int n;
	private int[] vt;

	public ThreadVetor(int n, int[] vt) {
		this.n = n;
		this.vt = vt;
	}

	@Override
	public void run() {
		percorreVetor();
	}

	private void percorreVetor() {
		int tamanho = vt.length;
		if (n % 2 == 0) {
			double tempoI = System.nanoTime();
			for (int i = 0; i < tamanho; i++) {

			}
			double tempoF = System.nanoTime();
			double tempoT = (tempoF - tempoI) / Math.pow(10, 9);
			System.out.println("Tempo usando For = " + tempoT + " segundos.");
		} else {
			double tempoI = System.nanoTime();
			for (@SuppressWarnings("unused") int i : vt) {

			}
			double tempoF = System.nanoTime();
			double tempoT = (tempoF - tempoI) / Math.pow(10, 9);
			System.out.println("Tempo usando ForEach = " + tempoT + " segundos.");
		}

	}

}

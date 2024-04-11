package controller;

public class ThreadRecursiva extends Thread {

	private long n;

	public ThreadRecursiva(long n) {
		this.n = n;
	}

	@Override
	public void run() {
		long startTime = System.nanoTime();
		long resultado = fatorial(n);
		long endTime = System.nanoTime();

		System.out.println("Fatorial de " + n + " (Recursivo) é " + resultado);
		System.out.println("Tempo de execução (Recursivo): " + (endTime - startTime) + " nanossegundos");
	}

	private long fatorial(long n) {
		if (n == 0) {
			return 1;
		} else {
			long r = n * fatorial(n - 1);
			return r;
		}

	}

}

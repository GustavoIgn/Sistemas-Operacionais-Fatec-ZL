package controller;

public class ThreadFatorial extends Thread {

	long n;

	public ThreadFatorial(long n) {
		this.n = n;
	}

	@Override
	public void run() {
		long startTime = System.nanoTime();
		long resultado = fatorial(n);
		long endTime = System.nanoTime();

		System.out.println("Fatorial de " + n + " (Não Recursivo) é " + resultado);
		System.out.println("Tempo de execução (Não Recursivo): " + (endTime - startTime) + " nanossegundos");
	}

	private long fatorial(long n) {
		long result = 1;
		for (long i = n; i > 0; i--) {
			result = result * i;
		}
		return result;
	}

}

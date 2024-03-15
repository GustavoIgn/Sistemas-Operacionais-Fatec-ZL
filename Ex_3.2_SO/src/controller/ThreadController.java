package controller;

public class ThreadController extends Thread {

	private int[] linha;
	private int idLinha;

	public ThreadController(int[] linha, int idLinha) {
		this.linha = linha;
		this.idLinha = idLinha;
	}

	@Override
	public void run() {
		Somar();
	}

	public void Somar() {
		int soma = 0;
		for (int num : linha) {
			soma += num;
		}
		System.out.println("Linha " + idLinha + ": Soma = " + soma);
	}
}

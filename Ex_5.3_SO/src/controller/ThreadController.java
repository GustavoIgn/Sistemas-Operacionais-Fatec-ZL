package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
	private int id;
	int distanciaTotal, mostrarKm = 100;
	private Semaphore semaforo;
	static int posicaoChegada = 0;
	static int vetorAtletas[] = new int[25];
	static int vetorPontuacao[] = new int[25];
	static int vetorTiro[] = new int[25];
	static int pontos = 250;

	public ThreadController(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		startRun();
		try {
			semaforo.acquire();
			atirar();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			semaforo.release();
			pedalar();
			chegada();
		}
	}

	private void startRun() {
		System.out.println("Corredor " + id + " iniciou a corrida!!");
		int distanciaPercorrida = 0;
		distanciaTotal = 3000;
		int velocidadeMin = 20, velocidadeMax = 25, tempo = 30;
		percurso(distanciaPercorrida, distanciaTotal, velocidadeMax, velocidadeMin, tempo);
	}

	private void percurso(int distanciaPercorrida, int distanciaTotal, int velocidadeMax, int velocidadeMin,
			int tempo) {
		while (distanciaPercorrida < distanciaTotal) {
			int velocidadeCorredor = (int) (Math.random() * (velocidadeMax - velocidadeMin)) + velocidadeMin;
			distanciaPercorrida += velocidadeCorredor;

			if (distanciaPercorrida >= mostrarKm) {
				System.out.println("Atleta " + id + " percorreu " + mostrarKm + "m.");
				mostrarKm += 100;
			}

			try {
				Thread.sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void atirar() {
		int pontosTiro = 0;
		for (int i = 0; i < 3; i++) {
			int tempo = (int) (Math.random() * 2500) + 500;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int pontoTiro = (int) (Math.random() * 11); // de 0 a 10 pontos
			System.out.println("Atleta " + id + " fez " + pontoTiro + " pontos no tiro " + (i + 1) + ".");
			pontosTiro += pontoTiro;
		}
		vetorTiro[id - 1] = pontosTiro;
	}

	private void pedalar() {
		System.out.println("Atleta " + id + " iniciou a pedalada!!");
		int distanciaPercorrida = 0;
		distanciaTotal = 5000;
		int velocidadeMin = 30, velocidadeMax = 40, tempo = 40;
		percurso(distanciaPercorrida, distanciaTotal, velocidadeMax, velocidadeMin, tempo);
	}

	private void chegada() {
		posicaoChegada++;
		int pontuacaoTotal = pontos + vetorTiro[id - 1];

		vetorPontuacao[posicaoChegada - 1] = pontuacaoTotal;
		vetorAtletas[posicaoChegada - 1] = id;
		System.out.println("Atleta " + (vetorAtletas[posicaoChegada - 1]) + " chegou em " + posicaoChegada
				+ "º lugar e teve " + pontuacaoTotal + " pontos.");
		pontos = pontos - 10;

		if (posicaoChegada == 25) {
			ordenarResultados();
		}
	}

	private void ordenarResultados() {
		for (int i = 0; i < 25; i++) {
			for (int j = i + 1; j < 25; j++) {
				if (vetorPontuacao[i] < vetorPontuacao[j]) {
					int tempPontuacao = vetorPontuacao[i];
					vetorPontuacao[i] = vetorPontuacao[j];
					vetorPontuacao[j] = tempPontuacao;

					int tempAtleta = vetorAtletas[i];
					vetorAtletas[i] = vetorAtletas[j];
					vetorAtletas[j] = tempAtleta;
				}
			}
		}

		// Exibir resultado final
		System.out.println("\nResultado Final:");
		for (int i = 0; i < 25; i++) {
			System.out.println("Atleta " + vetorAtletas[i] + ": " + vetorPontuacao[i] + " pontos");
		}
	}
}

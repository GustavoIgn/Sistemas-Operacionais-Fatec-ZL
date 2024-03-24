package controller;

import java.util.concurrent.Semaphore;

public class ThreadTransacoes extends Thread {

	private int idThread, calcMin, calcMax, transacaoMax;
	private Semaphore semaforo;

	public ThreadTransacoes(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		switch (idThread % 3) {
		case 0:
			calcMin = 1000;
			calcMax = 1000;
			transacaoMax = 1500;
			Rotacao(3);
			break;
		case 1:
			calcMin = 200;
			calcMax = 800;
			transacaoMax = 1500;
			Rotacao(2);
			break;
		case 2:
			calcMin = 500;
			calcMax = 1000;
			transacaoMax = 1000;
			Rotacao(3);
			break;
		default:
			System.out.println("ERRO");
			break;
		}
	}

	private void Rotacao(int vezes) {
		if (vezes != 0) {
            calcular(calcMin, calcMax);
            try {
                semaforo.acquire();
                realizarTransacao(transacaoMax);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
                Rotacao(vezes - 1);
            }
        }

	}

	private void realizarTransacao(int transacaoMax2) {
		System.out.println("ID: " + idThread + " comecou uma transacao.");
		int tempo = (int) (Math.random() * transacaoMax2);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ID: " + idThread + " finalizou sua transacao");
	}

	private void calcular(int calcMin2, int calcMax2) {
		int tempo = (int) (Math.random() * calcMax2 + calcMin2);
		try {
			System.out.println("ID: " + idThread + " comecou seus calculos.");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

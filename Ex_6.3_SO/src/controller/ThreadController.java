package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	Semaphore semaforoDeposito;
	Semaphore semaforoSaque;
	int idConta, tipo;
	double valor;
	double saldo;

	public ThreadController(Semaphore semaforoDeposito, Semaphore semaforoSaque, int tipo, int idConta, int valor,
			double saldo) {
		this.semaforoDeposito = semaforoDeposito;
		this.semaforoSaque = semaforoSaque;
		this.idConta = idConta;
		this.valor = valor;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	@Override
	public void run() {
		if (tipo == 1) {
			try {
				semaforoSaque.acquire(); // Aguarda para realizar o saque
				sacar();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforoSaque.release(); // Libera o semáforo de saque
			}

		} else {
			try {
				semaforoDeposito.acquire(); // Aguarda para realizar o deposito
				depositar();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforoDeposito.release(); // Libera o semáforo de deposito
			}
		}
	}

	private void depositar() {
		System.out.println("\nConta: #" + idConta + " -- Valor Depositado: R$ " + valor);
		saldo += valor;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		exibirSaldo();
	}

	private void sacar() {
		System.out.println("\nConta: #" + idConta + " -- Valor Sacado: R$ " + valor);
		saldo -= valor;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		exibirSaldo();
	}

	private void exibirSaldo() {
		System.out.println("Saldo Disponível: R$ " + saldo + " --Conta: " + idConta);

	}
}

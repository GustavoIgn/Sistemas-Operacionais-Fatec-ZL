package view;

import java.util.concurrent.Semaphore;
import controller.ThreadController;

public class Main {
    public static void main(String args[]) {
        Semaphore semaforoDeposito = new Semaphore(1);  // Permitir apenas 1 depósito por vez
        Semaphore semaforoSaque = new Semaphore(1);     // Permitir apenas 1 saque por vez
        int saldo = 500; // Saldo Genérico para todas as contas;

        for (int i = 1; i <= 20; i++) {
            int tipo = (int) (Math.random() * 2) + 1;
            int valor = (int) (Math.random() * 101) + 5; // valor de deposito ou saque aleatorio entre 5 e 105;
            ThreadController tSaque = new ThreadController(semaforoDeposito, semaforoSaque, tipo, i, valor, saldo);
            tSaque.start();
        }
    }
}
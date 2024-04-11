package controller;

import java.util.concurrent.Semaphore;

public class ThreadSJF extends Thread {

    private int id;
    private int tempos;
    private Semaphore semaphore;

    public ThreadSJF(int id, int tempos, Semaphore semaphore) {
        this.id = id;
        this.tempos = tempos;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // Tenta adquirir o semáforo
            processos();
            semaphore.release(); // Libera o semáforo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processos() {
        System.out.println("Processo: " + id + " -- Iniciado.");

        try {
            Thread.sleep(tempos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processo: " + id + " -- Finalizado -- Tempo: " + tempos + "s.");
    }
}


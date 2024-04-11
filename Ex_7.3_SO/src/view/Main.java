package view;

import controller.ThreadSJF;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int tempos[] = new int[20];

        for (int i = 0; i < 20; i++) {
            tempos[i] = (int) (Math.random() * 117) + 4;
        }

        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                if (tempos[i] > tempos[j]) {
                    int aux = tempos[i];
                    tempos[i] = tempos[j];
                    tempos[j] = aux;
                }
            }
        }

        Semaphore semaforo = new Semaphore(1); // Semáforo com 1 permissão

        for (int i = 0; i < 20; i++) {
            ThreadSJF t = new ThreadSJF(i, tempos[i], semaforo);
            t.start();
        }

        System.out.println("Simulação finalizada.");
    }
}

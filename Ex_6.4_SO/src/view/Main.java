package view;

import java.util.concurrent.Semaphore;
import controller.ThreadController;

public class Main {
    public static void main(String args[]) {
        Semaphore semaforo = new Semaphore(5);
        int[] carrosNaPista = new int[14]; // Array para rastrear os carros das equipes que estão na pista

        Thread[] threads = new ThreadController[14];

        // Array de strings para representar as equipes
        String[] equipes = {
            "Mercedes",
            "Red Bull",
            "Ferrari",
            "McLaren",
            "Alpine",
            "AlphaTauri",
            "Aston Martin"
        };

        for (int i = 0; i < 14; i++) {
            if (i < 7) {
                threads[i] = new ThreadController(semaforo, carrosNaPista, i, 1, equipes[i], equipes); // Carro "A"
            } else {
                threads[i] = new ThreadController(semaforo, carrosNaPista, i, 2, equipes[i - 7], equipes); // Carro "B"    
            }
        }

        for (int i = 0; i < 14; i++) {
            threads[i].start();
        }

        // Espera todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreadController threadController = new ThreadController(null, null, 0, 0, null, equipes);
		threadController.exibirGridLargada();
    }
}
package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

    Semaphore semaforo;
    int[] carrosNaPista;
    int idCorredor;
    static int naPista[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 0 - Livre, 1 - Primeiro Piloto, 2 - Segundo Piloto.
    int idCarro;
    static double[] tempoVoltas = new double[14]; // Vetor para armazenar os tempos de volta mais rápidos de cada piloto
    String equipe;
    String equipeVt [] = new String [7];

    public ThreadController(Semaphore semaforo, int[] carrosNaPista, int idCorredor, int idCarro, String equipe, String [] equipeVt) {
        this.idCorredor = idCorredor;
        this.semaforo = semaforo;
        this.carrosNaPista = carrosNaPista;
        this.idCarro = idCarro;
        this.equipe = equipe;
        this.equipeVt = equipeVt;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();

            while (naPista[idCorredor] != 0) {
                sleep(100); // Carro à frente finalizando.
            }

            if (idCarro == 1) {
                while (carrosNaPista[idCorredor] == 2) {
                    sleep(100); // Espera o segundo carro da equipe sair da pista
                }
            } else {
                while (carrosNaPista[idCorredor] == 1) {
                    sleep(100); // Espera o primeiro carro da equipe sair da pista
                }
            }

            naPista[idCorredor] = idCarro;
            carrosNaPista[idCorredor] = idCarro;

            double melhorTempoVolta = Double.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                double tempoVolta = correr(i + 1);
                if (tempoVolta < melhorTempoVolta) {
                    melhorTempoVolta = tempoVolta;
                }
            }

            tempoVoltas[idCorredor] = melhorTempoVolta; // Armazena o tempo da volta mais rápida no vetor

            naPista[idCorredor] = 0; // liberando a pista
            if (idCarro == 1) {
                carrosNaPista[idCorredor] = 2; // libera o segundo carro da equipe
            } else {
                carrosNaPista[idCorredor] = 1; // libera o primeiro carro da equipe
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
        
        System.out.println("\n<--------------------PILOTO NOVO OU PISTA LIVRE--------------------->\n");
    }

    private double correr(int i) {
        double tempoVolta = (Math.random() * 101) + 60;
        System.out.println("Piloto " + (idCorredor + 1) + " da " + equipe + " Correndo --> VOLTA " + i + " - Tempo: " + tempoVolta);
        try {
            Thread.sleep((long) tempoVolta * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tempoVolta;
    }

    public void exibirGridLargada() {
        // ordena e exibe o grid de largada
        int[] ordem = new int[14];
        for (int i = 0; i < 14; i++) {
            ordem[i] = i + 1;
        }

        // Ordenando os pilotos pelo tempo da volta mais rápida
        for (int i = 0; i < 14; i++) {
            for (int j = i + 1; j < 14; j++) {
                if (tempoVoltas[ordem[i] - 1] > tempoVoltas[ordem[j] - 1]) {
                    int temp = ordem[i];
                    ordem[i] = ordem[j];
                    ordem[j] = temp;
                }
            }
        }

        System.out.println("\nGrid de Largada:");
        for (int i = 0; i < 14; i++) {
            int piloto = ordem[i];
            // Correção: Usando ordem[i] para acessar os tempos de volta e as equipes corretas
            System.out.println("Piloto " + piloto + " da equipe " + ((piloto <= 7) ? equipeVt[piloto - 1] : equipeVt[piloto - 8]) + " - Tempo da volta mais rápida: " + tempoVoltas[piloto - 1]);
        }
    }
}


package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	int idCavaleiro, velocidadeExtra, tamanhoCorredor = 2000;
	Semaphore semaforoTochaPedra, semaforoPorta;
	static int distanciaB = 500, portaC = (int) (Math.random() * 4);
	static boolean pedraC;
	int mostrarKm = 100;
	static boolean[] portaAberta = new boolean[4];

	public ThreadController(int id, Semaphore semaforoTochaPedra, Semaphore semaforoPorta) {
		this.idCavaleiro = id;
		this.semaforoTochaPedra = semaforoTochaPedra;
		this.semaforoPorta = semaforoPorta;
	}

	@Override
	public void run() {
		startRun();
		try {
			semaforoPorta.acquire();
			entrarPorta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforoPorta.release();
		}

	}

	private void startRun() {
		System.out.println("Cavaleiro " + idCavaleiro + " iniciou a corrida!!");
		int distanciaPercorrida = 0;

		while (distanciaPercorrida < tamanhoCorredor) {
			int velocidadeCavaleiro = (int) (Math.random() * 2) + 2;
			distanciaPercorrida += (velocidadeExtra + velocidadeCavaleiro);
			if(distanciaPercorrida >= mostrarKm) {
				System.out.println("Cavaleiro " + idCavaleiro + " correu " + mostrarKm + "m.");
				mostrarKm += 100;
			}
			
			if (distanciaPercorrida > distanciaB && !pedraC) {
				try {
					semaforoTochaPedra.acquire();
					if (distanciaB == 500) {
						distanciaB = 1500;
						pegarBonus("Tocha");					
					} else {
						pedraC = true;
						pegarBonus("Pedra");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					semaforoTochaPedra.release();
				}
				
			}
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void pegarBonus(String bonus) {
		System.out.println("Cavaleiro " + idCavaleiro + " conseguiu a " + bonus + " sagrada!!");
		velocidadeExtra += 2;
		
	}

	private void entrarPorta() {
		int porta = (int) (Math.random()*4);
		while (portaAberta[porta]) {
			porta = (int) (Math.random()*4);
		}
		portaAberta[porta] = true;
		System.out.println("Cavaleiro " + idCavaleiro + " entrou na porta " + (porta + 1));
		
		if (porta == portaC) {
			System.out.println("Cavaleiro " + idCavaleiro + " sobreviveu ao inferno e terminou a corrida!!");
		} else {
			System.out.println("Cavaleiro " + idCavaleiro + " sucumbiu a derrota e foi morto por MONSTROS!!");
		}

	}
}

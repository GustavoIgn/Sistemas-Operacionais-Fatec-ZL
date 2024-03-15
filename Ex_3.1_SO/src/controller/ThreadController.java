package controller;

//extends Thread...
//Parâmetros por contrutor
//método run()

public class ThreadController extends Thread {
	private int idThread;
	
	public ThreadController(int idThread) {
		this.idThread = (int) this.getId();
	}
	
	@Override
	public void run() {
		mostraId();
	}
	
	private void mostraId() {
		System.out.println("Thread nº " + idThread + " rodando");
	}
}

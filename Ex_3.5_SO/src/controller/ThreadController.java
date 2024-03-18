package controller;

import java.io.BufferedReader;
import java.io.*;

public class ThreadController extends Thread {

	private double tempoTotal;
	private String acesso;

	public ThreadController(String acesso) {
		this.acesso = acesso;
	}

	@Override
	public void run() {
		ping(acesso);
	}

	private String os() {
		return System.getProperty("os.name");
	}

	private void ping(String acesso) {
		String sistemaOperacional = os();
		if (sistemaOperacional.equals("Linux")) {
			processoPing(acesso);
		} else {
			System.out.println("Sistema operacional não invalido");
		}
	}

	private void processoPing(String acesso) {
		try {
			Process processo = Runtime.getRuntime().exec("ping -4 -c 10 " + acesso);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha;
			int cont = 0;
			while ((linha = buffer.readLine()) != null) {
				if (linha.contains("time=")) {

					int indInicio = linha.indexOf("time=") + 5;
					int indFim = linha.indexOf(" ms");

					String tempoStr = linha.substring(indInicio, indFim);

					double tempo = Double.parseDouble(tempoStr);
					tempoTotal += tempo;
					cont++;
				}
			}
			
			double tempoMedio = tempoTotal / cont;
			System.out.println("Tempo médio de ping do site  " + acesso + ": " + tempoMedio);
			fluxo.close();
			leitor.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
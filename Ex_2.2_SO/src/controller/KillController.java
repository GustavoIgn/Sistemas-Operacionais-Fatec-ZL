package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class KillController {
	public KillController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name"); // Nome do Sistema.
		return os;
	}

	public void listaProcessos() {
		String process = "";
		if (os().contains("Windows")) {
			process = ("TASKLIST /FO TABLE");
		} else {
			process = ("ps -ef");
		}
		
		execChamado(process);
	}

	public void mataPid(String pid) {
		String process = "";
		if (os().contains("Windows")) {
			process = ("TASKKILL /PID " + pid);
		} else {
			process = ("kill -9 " + pid);
		}
		
		execChamado(process);
	}

	public void mataNome(String nProc) {
		String process = "";
		if (os().contains("Windows")) {
			process = ("TASKKILL /IM " + nProc);
		} else {
			process = ("pkill -f " + nProc);
		}
		
		execChamado(process);
	}
	
	private void execChamado(String process) {
		if (os().contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		} else {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		}
	}
}

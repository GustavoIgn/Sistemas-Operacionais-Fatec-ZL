package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name"); // Nome do Sistema.
		String arch = System.getProperty("os.arch");// Arquitetura do Sistema.
		String version = System.getProperty("os.version");// Versão do Sistema.
		return os + " - V. " + version + " - arch. " + arch;
	}

	public void ip() {
		String sistOp = os();

		if (sistOp.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("IPCONFIG");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("Ethernet")) {
						System.out.println(linha);
					}
					if (linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			} finally {
			}
		} else if (sistOp.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ip addr");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("mtu")) {
						System.out.println(linha);
					}
					if (linha.contains("inet")) {
						String[] separa = linha.split(" ");
						System.out.println("IPv4: " + separa[1]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		} else {
			System.out.println("Sistema Operacional não identificado");
		}
	}

    public void ping() {
        if (os().contains("Windows")) {
            try {
            	String process2 = "PING -4 -n 10 www.google.com.br";
                Process p = Runtime.getRuntime().exec(process2);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null) {
    				System.out.println(linha);
    				linha = buffer.readLine();
    			}
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
            	String process2 = "ping -4 -c 10 www.google.com.br";
                Process p = Runtime.getRuntime().exec(process2);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null) {
    				System.out.println(linha);
    				linha = buffer.readLine();
    			}
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

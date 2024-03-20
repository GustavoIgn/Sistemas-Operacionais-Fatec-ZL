package controller;

import br.edu.fateczl.pilhaint.Pilha;

public class ConverteController {
	Pilha p = new Pilha();

	public ConverteController() {
		super();
	}

	public String decToBin(int decimal) {
		String binario = "";

		while (decimal > 0) {
			int resto = decimal % 2;
			p.push(resto);
			decimal /= 2;
		}

		while (!p.isEmpty()) {
			try {
				binario += Integer.toString((int) p.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return binario;
	}
}

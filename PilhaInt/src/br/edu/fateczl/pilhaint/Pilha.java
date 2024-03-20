package br.edu.fateczl.pilhaint;

public class Pilha {

	No topo;

	public Pilha() {
		topo = null;
	}

	public boolean isEmpty() {
		if (topo == null) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int e) {
		No elemento = new No();
		elemento.dado = e;
		if (isEmpty()) {
			topo = elemento;
		} else {
			elemento.proximo = topo;
			topo = elemento;
		}

	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Não há elementos para desempilhar");
		}
		int valor = topo.dado;
		topo = topo.proximo;
		return valor;
	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Não há elementos para desempilhar");
		}
		int valor = topo.dado;
		return valor;
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No auxiliar = topo;
			cont = 1;
			while (auxiliar.proximo != null) {
				auxiliar = auxiliar.proximo;
				cont++;
			}
		}
		return cont;
	}
}

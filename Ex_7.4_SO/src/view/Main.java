package view;

import java.util.Scanner;

import controller.ThreadFatorial;
import controller.ThreadRecursiva;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira um numero para calcular seu fatorial: (Maximo 20)");
		long n = input.nextLong();
		
		
		Thread tRec = new ThreadRecursiva(n);
		Thread tFat = new ThreadFatorial(n);
		tRec.start();
		tFat.start();
		
		input.close();
	}
}

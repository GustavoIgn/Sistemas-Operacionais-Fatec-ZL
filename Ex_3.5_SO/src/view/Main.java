package view;

import controller.ThreadController;

public class Main {
	public static void main(String[] args) {	
		
		Thread uol = new ThreadController("www.uol.com.br");
		Thread google = new ThreadController("www.google.com.br");
		Thread terra = new ThreadController("www.terra.com.br");
		
		uol.start();
		google.start();
		terra.start();

	}

}
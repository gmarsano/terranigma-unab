package userInterface.terminal;

import java.util.Scanner;

import userInterface.UserInterface;

public class TerminalUI implements UserInterface {
	private Scanner in;
	
	public TerminalUI (Scanner in) {
		this.in = in;
	}
	
	/**
	 * Muestra el simbolo de entrada de texto.
	 */
	public void symbol() {
		System.out.print(">>> ");
	}
	
	/**
	 * Muestra un mensaje `message` por consola
	 * 
	 * @param message
	 */
	public void message(String message) {
		System.out.println(message);
	}
	
	/**
	 * Lista por consola las opciones entregadas en `list` y retorna la opción elegida
	 * 
	 * @param list; Lista de opciones
	 * @param message; Mensaje de presentación de las opciones
	 * @return String
	 */
	public String getListResponse(String[] list, String message) {
		int index;
		String response;
		
		while (true) {
			this.message(message);
			
			for(int i = 1; i <= list.length; i++) {
				this.message(i + ": " + list[i-1]);
			}
			
			this.symbol();
			
			try {
				index = Integer.parseInt(in.nextLine()) - 1;
				response = list[index];
				return response;
			} catch (Exception e) {
				this.message("Opción inválida. Intente de nuevo...");
			}
		}	
	}
	
	public String getListResponse(String[] list) {
		return getListResponse(list,"");
	}
	
	
	/**
	 * Pide una respuesta por teclado al usuario y la retorna
	 * 
	 * @param message; Request message
	 * @return String
	 */
	public String request(String message) {
		String response;
		
		this.message(message);
		this.symbol();
		
		response = in.nextLine();
		
		return response;
	}
	
	public void showCharStats(String[][] table) {
		for (Object[] row : table) {
		    System.out.format("%-6s%-12s%-6s%-8s\n", row);
		}
	}

}

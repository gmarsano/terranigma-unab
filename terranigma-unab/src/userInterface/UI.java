package userInterface;

import java.util.Scanner;

/**
 * Dispone de la funcionalidad para la interacción con el usuario
 * 
 */
public class UI {
	private static final UI singleton = new UI();
	private static Scanner in;
	
	public static UI get() {
		return singleton;
	}
	
	private UI() {}
	
	public String getListResponse(String[] list) {
		return getListResponse(list,"");
	}
	
	/**
	 * @param in the in to set
	 */
	public static void setIn(Scanner in) {
		if (UI.in == null) {
			UI.in = in;			
		}
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
				System.out.println("Opción inválida. Intente de nuevo...");
			}
		}	
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


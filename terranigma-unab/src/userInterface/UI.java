package userInterface;

import java.util.Scanner;

/**
 * Dispone de la funcionalidad para la interacción con el usuario.
 * 
 */
public class UI {
	private static final UI singleton = new UI();
	
	public static UI get() {
		return singleton;
	}
	
	private UI() {}
	
	public String getListResponse(String[] list) {
		return getListResponse(list,"");
	}
	
	/**
	 * Lista por consola las opciones entregadas en `list` y retorna la opcion elegida.
	 * 
	 * @param list; Lista de opciones
	 * @param message; Mensaje de presentación de las opciones
	 * @return String
	 */
	public String getListResponse(String[] list, String message) {
		int index;
		String response;
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println(message);
			for(int i = 1; i <= list.length; i++) {
				System.out.println(i + ": " + list[i-1]);
			}
			System.out.printf(">>>");
			try {
				index = Integer.parseInt(in.nextLine()) - 1;
				response = list[index];
				in.close();
				return response;
			} catch (Exception e) {
				System.out.println("Opción inválida. Intente de nuevo...");
			}
		}	
	}
}


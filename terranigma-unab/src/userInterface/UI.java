package userInterface;

import java.util.Scanner;

import userInterface.terminal.TerminalUI;
import userInterface.windowbuilder.GUI;

/**
 * Dispone de la funcionalidad para la interacción con el usuario
 * 
 */
public class UI {
	private static UserInterface singleton = null;
	private static Scanner in;
	
	
	public static UserInterface get() {
		
		if (singleton == null) {
			// Selección de interfaz de usuario 
			System.out.println("Seleccione interfaz: ");
			System.out.println("1: Terminal");
			System.out.println("2: GUI");
			String response = in.nextLine();
			if (response.equals("1")) {
				singleton = new TerminalUI(in);
			} else {
				singleton = new GUI();
			}
		}
		
		return singleton;
	
	}
	
	private UI() {}
	
	
	/**
	 * @param in the in to set
	 */
	public static void setIn(Scanner in) {
		if (UI.in == null) {
			UI.in = in;			
		}
	}

}


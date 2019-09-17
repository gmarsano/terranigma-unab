package userInterface.windowbuilder;

import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

import userInterface.UserInterface;

import terranigma.abstracts.Character;

public class GUI implements UserInterface {
	private Vista window;
	private Character char1;
	private Character char2;
	
	public GUI () {
		this.window = new Vista();
		this.window.setVisible(true);
	}
	
	/*
	 * Permite esperar una respuesta del usuario esperando el cambio de estado de
	 * la variable de sincronización de la vista
	 */
	private void waitUserResponse() {
		JTextField textField = window.getUserInputText();
		textField.requestFocus();
	    textField.select(0, textField.getText().length());
	    
	    window.setWaitForResponse(true);
		
	    while (window.isWaitForResponse()) {
			try {
			    TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
		}
	    
	}

	@Override
	public String getListResponse(String[] list, String message) {
		// TODO Auto-generated method stub
		int index;
		String response;
		
		while (true) {
			this.message(message);
			
			for(int i = 1; i <= list.length; i++) {
				this.message(i + ": " + list[i-1]);
			}
			
			this.waitUserResponse();
			try {
				index = Integer.parseInt(this.window.getUserInputText().getText()) - 1;
				response = list[index];
				return response;
			} catch (Exception e) {
				this.message("Opción inválida. Intente de nuevo...");
			}
			
		}
	}
	@Override
	public String getListResponse(String[] list) {
		// TODO Auto-generated method stub
		return getListResponse(list,"");
	}

	@Override
	public void message(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		// 
		window.setInfoArea(message + System.lineSeparator());
	}

	@Override
	public String request(String message) {
		String response;
		
		this.message(message);
		
		this.waitUserResponse();
		response = this.window.getUserInputText().getText();
		
		return response;
	}

	@Override
	public void showCharStats(String[][] table) {
		// TODO Auto-generated method stub
		
		/* for (Object[] row : table) {
		    System.out.format("%-6s%-12s%-6s%-8s\n", row);
		} */
		
		// Llamar a función de reemplazo en GUI
		this.refreshStats();
	}
	
	/**
	 * ***** Metodos de GUI para animaciones y visualización de información *****
	 */
	
	/**
	 * Lanza la presentación del juego
	 * 
	 */
	public void gameIntro() {
		
		
	}
	
	/**
	 * Recibe personajes e inicializa la vusualización de la batalla
	 * 
	 */
	public void gameStart(Character char1, Character char2) {
		// Cargar fondo de batalla
		window.getContentPane()
		
		// Cargar imagenes de personajes
		
		// Cargar paneles de atributos
		
		
	}
	
	
	/**
	 * Refresca los paneles de información de atributos de los personajes
	 * 
	 */
	public void refreshStats() {
		
	}
	
	/**
	 * Animación del personaje al recibir daño
	 * 
	 */
	public void takeDamage() {
		
	}
	
	/**
	 * Animación del personaje derrotado al recibir golpe mortal
	 * 
	 */
	public void defeated() {
		
	}
	
}

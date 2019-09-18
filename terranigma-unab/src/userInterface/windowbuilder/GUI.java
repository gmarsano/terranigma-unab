package userInterface.windowbuilder;

import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	 * la variable de sincronizaci�n de la vista
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
				this.message("Opci�n inv�lida. Intente de nuevo...");
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
		
		// Llamar a funci�n de reemplazo en GUI
		this.refreshStats();
	}
	
	/**
	 * ***** Metodos de GUI para animaciones y visualizaci�n de informaci�n *****
	 */
	
	/**
	 * Lanza la presentaci�n del juego
	 * 
	 */
	public void gameIntro() {
		
		
	}
	
	/**
	 * Recibe personajes e inicializa la vusualizaci�n de la batalla
	 * 
	 */
	public void gameStart(Character char1, Character char2) {
		this.char1 = char1;
		this.char2 = char2;
		
		// Cargar fondo de batalla
		window.screenPanel.changeImage("/userInterface/windowbuilder/images/battlefield.png");
		
		
		// Cargar imagenes de personajes
		ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource(char1.getIconUri())).getImage());
		window.lblChar1.setIcon(icon);
		
		icon = new ImageIcon(new ImageIcon(getClass().getResource(char2.getIconUri())).getImage());
		window.lblChar2.setIcon(icon);
		
		// Cargar paneles de atributos
		
		
	}
	
	/**
	 * Refresca los paneles de informacion de atributos de los personajes
	 * 
	 */
	public void refreshStats() {

		String message = getCharacterStats(this.char1);
		window.char1StatsArea.setText(message);
		
		message = getCharacterStats(this.char2);
		window.char2StatsArea.setText(message);
	}
	
	public String getCharacterStats(Character charX) {
		String message;
		
		//System.lineSeparator()
		
		message = "Jugador: " + charX.getPlayerName() + "\t	Personaje:" + charX.getName() + System.lineSeparator();
		message = message + "HP: " + charX.getHp() + "/" + charX.getMaxHp();
		message = message + "\t	MP: " + charX.getMp() + "/" + charX.getMaxMp() + System.lineSeparator();
		message = message + "STR: " + charX.getStr() + "\t DEF: " + charX.getDef();
		message = message + "\t	WIS: " + charX.getWis() + "	SP: " + charX.getSp(); 
				
		return message;
	}
	/**
	 * Animacion del personaje al recibir danno
	 * 
	 */
	public void takeDamage(Character ch) {
		JLabel lblCharX;
		if (ch.equals(this.char1)) {
			lblCharX = window.lblChar1;
		} else {
			lblCharX = window.lblChar2;
		}
		
		int x = lblCharX.getX();
		int y = lblCharX.getY();
		
		lblCharX.setLocation(x - 30, y);
		this.waitMS(300);
		lblCharX.setLocation(x + 30, y);
		this.waitMS(300);
		lblCharX.setLocation(x - 30, y);
		this.waitMS(300);
		lblCharX.setLocation(x + 30, y);
		
	}
	
	private void waitMS(int n) {
		try {
		    TimeUnit.MILLISECONDS.sleep(n);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Animaci�n del personaje derrotado al recibir golpe mortal
	 * 
	 */
	public void defeated() {
		
	}
	
}

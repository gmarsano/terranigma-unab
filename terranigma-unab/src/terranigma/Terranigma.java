package terranigma;

import userInterface.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import terranigma.abstracts.Character;
import terranigma.factories.CharacterFactory;
import terranigma.interfaces.CanQueue;

public class Terranigma {
	private static Terranigma singleton;
	private static String player1;
	private static String player2;
	private static boolean running = false;
	private Character char1;
	private Character char2;
	private List<CanQueue> actionQueue = new ArrayList<CanQueue>();
	
	public static Terranigma get() {
		if (singleton == null) {
			singleton = new Terranigma();
		}
		return singleton;
	}
	
	public static void restart() {
		singleton = new Terranigma();
	}
	
	private Terranigma() {
	}
	
	public void play() {
		String message;
		
		if (player1 == null) {
			message = "Ingrese nombre del jugador 1:";
			player1 = UI.get().request(message);
			message = "Ingrese nombre del jugador 2:";
			player2 = UI.get().request(message);
		}
		
		message = "Seleccione personaje (" + player1 + "):";
		String charName1 = UI.get().getListResponse(CharacterFactory.get().getCharacterList(), message);
		message = "Seleccione personaje (" + player2 + "):";
		String charName2 = UI.get().getListResponse(CharacterFactory.get().getCharacterList(), message);
		
		this.char1 = CharacterFactory.get().newCharacter(charName1, player1);
		this.char2 = CharacterFactory.get().newCharacter(charName2, player2);
		
		this.char1.setEnemy(this.char2);
		this.char2.setEnemy(this.char1);
		
		this.actionQueue.add(this.char1);
		this.actionQueue.add(this.char2);
		
		running = true;
		
		while (running) {
			this.nextOnQueue();
		}
	}
	
	public void endGame(Character looser) {
		String message;
		
		running = false;
		
		message = looser.getName() + " ha muerto.";
		UI.get().message(message);
		message = looser.getEnemy().getPlayerName() + " es el vencedor.";
		UI.get().message(message);
	}
	
	public void nextOnQueue() {
		if (!running) {
			return;
		}
		
		for (CanQueue o : this.actionQueue) {
			o.trigger();
		}
		
		Collections.sort(this.actionQueue, Collections.reverseOrder());
		
		if (this.actionQueue.get(0).getCt() >= 100) {
			this.actionQueue.get(0).act();
		}
	}
	
	public void enqueue(CanQueue obj) {
		this.actionQueue.add(obj);
	}
	
	public void dequeue(CanQueue obj) {
		if (this.actionQueue.contains(obj)) {
			this.actionQueue.remove(obj);			
		}
	}
}

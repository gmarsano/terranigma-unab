package terranigma.factories;

import terranigma.abstracts.Character;
import terranigma.characters.*;

public class CharacterFactory {
	private static final CharacterFactory singleton = new CharacterFactory();
	private final String[] characterList = {
		"Ark",
		"Naomi",
		"El Sabio"
	};
	
	public static CharacterFactory get() {
		return singleton;
	}
	
	private CharacterFactory() {}
	
	public String[] getCharacterList() {
		return this.characterList;
	}
	
	public Character newCharacter(String type, String playerName) {
		Character response;
		// personajes disponibles
		switch(type) {
			case "Ark":
				response = new Ark(type, playerName);
				break;
			case "Naomi":
				response = new Naomi(type, playerName);
				break;
			case "El Sabio":
				response = new ElSabio(type, playerName);
				break;
			default:
				response = new Ark("Ark", playerName);
		}
		return response;
	}
}

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
	
	public Character newCharacter(String type) {
		Character response;
		// personajes disponibles
		switch(type) {
			case "Ark":
				response = new Ark();
				break;
			case "Naomi":
				response = new Naomi();
				break;
			case "El Sabio":
				response = new ElSabio();
				break;
			default:
				response = new Ark();
		}
		return response;
	}
}

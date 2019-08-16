package terranigma;

import terranigma.abstracts.Character;

public class Player {
	private Character myCharacter;
	
	public Player(Character character) {
		this.myCharacter = character;
	}
	
	public Character getCharacter() {
		return this.myCharacter;
	}

}

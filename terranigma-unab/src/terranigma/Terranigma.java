package terranigma;

import java.util.ArrayList;
import java.util.List;
import terranigma.factories.CharacterFactory;

public class Terranigma {
	private Player jugador1;
	private Player jugador2;
	
	
	public Terranigma () {
		// Selección de personajes. 
		// Asignar personajes.
		this.jugador1 = new Player(CharacterFactory.get().newCharacter("Ark"));
		this.jugador2 = new Player(CharacterFactory.get().newCharacter("Ark"));
	}
}

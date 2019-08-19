package terranigma.characters;

import terranigma.abstracts.Character;
import userInterface.UI;

public class Ark extends Character {
	// se inicializan las características del personaje ARK
	public Ark(String name, String playerName) {
		super(
				name, playerName,
				"Terminemos esto pronto!",
				// hp, mp, str, def, wis, sp
				110, 30, 80, 50, 10, 20
				);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		// Configuración del poder de ataque
		int dmg = (int) Math.round(this.getStr()*0.04*this.getSp());
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub

	}

}

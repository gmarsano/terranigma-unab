package terranigma.characters;

import terranigma.abstracts.Character;
import userInterface.UI;

public class Naomi extends Character {
	
	public Naomi(String name, String playerName) {
		super(
				name, playerName,
				"Disfruta de tu último tiempo feliz.",
				// hp, mp, str, def, wis, sp
				90, 30, 70, 80, 15, 15
				);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		
		// Configuración del poder de ataque
		int dmg = (int) Math.round(this.getStr()*0.03*this.getSp());
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}

}

package terranigma.characters;

import terranigma.abstracts.Character;
import userInterface.UI;

public class ElSabio extends Character {
	
	public ElSabio(String name, String playerName) {
		super(
				name, playerName,
				"Evita las condiciones desfavorables.",
				70, 70, 50, 60, 40, 10
				);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		
		// Configuración del poder de ataque
		int dmg = (int) Math.round(this.getStr()*0.02*this.getSp());
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		
	}

}

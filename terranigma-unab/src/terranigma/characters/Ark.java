package terranigma.characters;

import terranigma.abstracts.Character;
import userInterface.UI;

public class Ark extends Character {
	
	public Ark(String name, String playerName) {
		super(
				name, playerName,
				"Terminemos esto pronto!",
				200, 30, 10, 10, 10, 10
				);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		
		int dmg = (int) Math.round(this.str*0.2*this.sp);
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub

	}

}

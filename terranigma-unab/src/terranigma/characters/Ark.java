package terranigma.characters;

import terranigma.abilities.Agility;
import terranigma.abilities.Meditate;
import terranigma.abstracts.Character;
import userInterface.UI;

public class Ark extends Character {
	// se inicializan las características del personaje ARK
	public Ark(String name, String playerName) {
		super(
				name, playerName,
				"Terminemos esto pronto!",
				// hp, mp, str, def, wis, sp
				480, 120, 160, 50, 20, 10
				);
		this.abilities.add(new Agility(this));
		this.abilities.add(new Meditate(this));
		this.iconUri = "/userInterface/windowbuilder/images/Ark.png";
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		// Configuración del poder de ataque
		int dmg = (int) Math.round(0.2*this.getStr()*0.25*this.getSp());
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

}

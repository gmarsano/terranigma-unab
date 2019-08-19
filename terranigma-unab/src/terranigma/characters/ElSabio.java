package terranigma.characters;

import terranigma.abstracts.Character;
import userInterface.UI;

public class ElSabio extends Character {
	
	public ElSabio(String name, String playerName) {
		super(
				name, playerName,
				"Evita las condiciones desfavorables.",
				// hp, mp, str, def, wis, sp
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
	
	// sobreescribimos la propiedad de sanación del personaje Sabio
	@Override
	public void takeHeal(int value) {
		String message;
		int heal; 
		int pm = this.getMp();
		
		// Si tiene puntos de magia incrementamos la sanación y bajamos puntos de magia
		if (pm >= 20) {
			heal = value + 30;
			this.setMp(pm - 20);
		}
		else {
			heal = value;
		}
		
		this.setHp(this.getHp() + heal);
		
		if (this.getHp() > this.getMaxHp()) {
			// incrementa los Health Points 
			this.setMaxHp(this.getHp());
		}
		
		message = this.name + " ha recibido " + heal + " de curación.";
		UI.get().message(message);
	}

}

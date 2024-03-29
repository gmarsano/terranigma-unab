package terranigma.characters;

import terranigma.abilities.Meditate;
import terranigma.abilities.ToxicGas;
import terranigma.abstracts.Character;
import userInterface.UI;

public class ElSabio extends Character {
	
	public ElSabio(String name, String playerName) {
		super(
				name, playerName,
				"Evita las condiciones desfavorables.",
				// hp, mp, str, def, wis, sp
				368, 320, 60, 40, 100, 8
				);
		this.abilities.add(new ToxicGas(this));
		this.abilities.add(new Meditate(this));
		this.iconUri = "/userInterface/windowbuilder/images/ElSabio.png";
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		String message;
		
		// Configuraci�n del poder de ataque
		int dmg = (int) Math.round(this.getStr()*0.02*this.getSp());
		
		message = this.name + " ha lanzado un ataque!";
		UI.get().message(message);
		
		this.enemy.takeDamage(dmg);
	}

	
	// sobreescribimos la propiedad de sanaci�n del personaje Sabio
	@Override
	public void takeHeal(int value) {
		String message;
		int heal; 
		int pm = this.getMp();
		
		// Si tiene puntos de magia incrementamos la sanaci�n y bajamos puntos de magia
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
		
		message = this.name + " ha recibido " + heal + " de curaci�n.";
		UI.get().message(message);
	}

}

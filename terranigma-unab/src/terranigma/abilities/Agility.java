package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.factories.EffectFactory;
import userInterface.UI;

public class Agility extends Ability {

	public Agility(Character caller) {
		super(caller, "Agilidad");
		super.setTarget(caller.getEnemy());
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		this.cost = 50;
		if(this.getCaller().getMp() < this.cost) {
			UI.get().message("Agilidad tiene efecto. No hay suficiente MP");
			return;
		}
		
		Effect e = EffectFactory.get().newEffect("+Velocidad", this.getCaller(), this.getCaller());
		e.enqueue();
		
		this.getCaller().consumeMp(this.cost);
	}
}

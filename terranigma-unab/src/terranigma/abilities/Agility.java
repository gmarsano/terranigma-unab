package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.factories.EffectFactory;

public class Agility extends Ability {

	public Agility(Character caller) {
		super(caller, "Agilidad");
		super.setTarget(caller.getEnemy());
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		Effect e = EffectFactory.get().newEffect("+Velocidad", this.getCaller(), this.getCaller());
		e.enqueue();
	}
}

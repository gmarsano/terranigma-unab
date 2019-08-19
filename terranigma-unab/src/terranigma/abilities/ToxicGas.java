package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.factories.EffectFactory;

public class ToxicGas extends Ability {
	
	public ToxicGas(Character caller) {
		super(caller, "Gas Venenoso");
		super.setTarget(caller.getEnemy());
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		Effect e = EffectFactory.get().newEffect("Veneno", this.getCaller(), this.getCaller().getEnemy());
		e.enqueue();
	}

}

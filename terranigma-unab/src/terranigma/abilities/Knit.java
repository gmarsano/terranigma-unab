package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.factories.EffectFactory;
import userInterface.UI;

public class Knit extends Ability {
	
	public Knit(Character caller) {
		super(caller, "Tejer");
		super.setTarget(caller.getEnemy());
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		this.cost = 60;
		if(this.getCaller().getMp() < this.cost) {
			UI.get().message("Estrangular no hace efecto. No hay suficiente MP");
			return;
		}
		
		Effect e = EffectFactory.get().newEffect("Estrangular", this.getCaller(), this.getCaller().getEnemy());
		e.enqueue();
		
		this.getCaller().consumeMp(this.cost);
	}

}

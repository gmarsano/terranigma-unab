package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.factories.EffectFactory;
import userInterface.UI;

public class ToxicGas extends Ability {
	
	public ToxicGas(Character caller) {
		super(caller, "Gas Venenoso");
		super.target = caller.getEnemy();
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		this.cost = 60;
		
		if(this.getCaller().getMp() < this.cost) {
			UI.get().message("El veneno no hace efecto. No hay suficiente MP");
			return;
		}
			
		Effect e = EffectFactory.get().newEffect("Veneno", this.getCaller(), this.getCaller().getEnemy());
		e.enqueue();
		this.getCaller().consumeMp(this.cost);
	}

}

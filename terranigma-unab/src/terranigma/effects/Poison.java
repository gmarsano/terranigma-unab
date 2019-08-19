package terranigma.effects;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import userInterface.UI;

public class Poison extends Effect {
	
	public Poison(Character caller, Character target, String name) {
		// caller, target, name, sp, instant, times, stack
		super(caller, target, name, 10, false, 4);
		this.setCt(8);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Character target = this.getTarget();
		int dmg = (int) Math.round(15 + 0.8*this.getCaller().getWis());
		String message = target.getName() + " está envenenado.";
		
		UI.get().message(message);
		target.takeDamage(dmg);
	}

	@Override
	public void unapply() {
		// TODO Auto-generated method stub
		Character target = this.getTarget();
		String message = target.getName() + " ya no está envenenado.";
		
		UI.get().message(message);
	}

	@Override
	public void updateMessage() {
		// TODO Auto-generated method stub
		
	}
	
}

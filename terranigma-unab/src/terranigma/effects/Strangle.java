package terranigma.effects;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import userInterface.UI;

public class Strangle extends Effect {
	
	public Strangle(Character caller, Character target, String name) {
		// caller, target, name, sp, instant, times, stack
		super(caller, target, name, 8, true, 3);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Character target = this.getTarget();
		
		int dmg = (int) Math.round(5 + 0.4*this.getCaller().getStr() + 0.2*this.getCaller().getWis());
		String message = target.getName() + " estás siendo estrangulado.";
		
		UI.get().message(message);
		target.takeDamage(dmg);
	}

	@Override
	public void unapply() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateMessage() {
		// TODO Auto-generated method stub
	}

}

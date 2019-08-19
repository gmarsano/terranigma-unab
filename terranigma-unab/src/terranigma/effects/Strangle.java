package terranigma.effects;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;

public class Strangle extends Effect {
	
	public Strangle(Character caller, Character target, String name) {
		// caller, target, name, sp, instant, times, stack
		super(caller, target, name, 8, true, 3);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub

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

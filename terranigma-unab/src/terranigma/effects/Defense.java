package terranigma.effects;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;

public class Defense extends Effect {
	
	public Defense(Character caller, Character target, String name) {
		// caller, target, name, sp, instant, times, stack
		super(caller, target, name, 8, true, 2, false);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		Character target = this.getTarget();
		String message = target.getName() + " toma posición defensiva.";
		
		if (this.isRepeat()) {
			this.setRepeat(false);
			target.setDef(target.getDef() + 5);
			
			efectMessage(message);
		}
	}

	@Override
	public void unapply() {
		// TODO Auto-generated method stub
		Character target = this.getTarget();
		String message = target.getName() + " ha dejado la posición defensiva.";
		
		target.setDef(target.getDef() - 5);
		
		efectMessage(message);
	}

	@Override
	public void updateMessage() {
		// TODO Auto-generated method stub
		String message = this.getTarget().getName() + " ha retomado la posición defensiva";
		
		this.efectMessage(message);
	}
	
}

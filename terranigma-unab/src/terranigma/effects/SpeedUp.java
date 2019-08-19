package terranigma.effects;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;

public class SpeedUp extends Effect {
	
	public SpeedUp(Character caller, Character target, String name) {
		// caller, target, name, sp, instant, times, stack
		super(caller, target, name, 100);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		//incrementa la velocidad del personaje, en forma permanente
		Character target = this.getTarget();
		
		String message = target.getName() + " incremento su velocidad.";
		efectMessage(message);
		
		//modifica el atributo speed del personaje
		this.setSp(this.getSp() + 2);
		
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

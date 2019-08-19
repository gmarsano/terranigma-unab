package terranigma.factories;

import terranigma.abstracts.Character;
import terranigma.abstracts.Effect;
import terranigma.effects.*;

public class EffectFactory {
	private static final EffectFactory singleton = new EffectFactory();
	private final String[] effectsList = {
		"Veneno",
		"Estrangular",
		"+Velocidad",
		"Defensa"
	};
	
	public static EffectFactory get() {
		return singleton;
	}
	
	private EffectFactory() {}
	
	public String[] getEffectsList() {
		return this.effectsList;
	}
	
	public Effect newEffect(String type, Character caller, Character target) {
		Effect response = null;
		// efectos disponibles
		if (type.equals(this.effectsList[0])) {
			response = new Poison(caller, target, type);
		} else if (type.equals(this.effectsList[1])) {
			response = new Strangle(caller, target, type);
		} else if (type.equals(this.effectsList[2])) {
			response = new SpeedUp(caller, target, type);
		} else if (type.equals(this.effectsList[3])) {
			response = new Defense(caller, target, type);
		}
		return response;
	}
}

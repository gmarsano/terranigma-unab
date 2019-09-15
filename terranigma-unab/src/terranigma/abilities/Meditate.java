package terranigma.abilities;

import terranigma.abstracts.Ability;
import terranigma.abstracts.Character;
import userInterface.UI;

public class Meditate extends Ability {

	public Meditate(Character caller) {
		super(caller, "Meditar");
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		this.getCaller().takeMp(30);
		UI.get().message(this.getCaller().getName() + " está meditando.");
	}

}

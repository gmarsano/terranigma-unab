package terranigma.abstracts;

public abstract class Ability {
	protected Character caller;
	protected Character target;
	protected String name;
	
	public Ability (Character caller, String name) {
		this.caller = caller;
		this.name = name;
	}
	
	abstract public void use();

	/**
	 * @return the caller
	 */
	public Character getCaller() {
		return caller;
	}

	/**
	 * @param caller the caller to set
	 */
	public void setCaller(Character caller) {
		this.caller = caller;
	}

	/**
	 * @return the target
	 */
	public Character getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Character target) {
		this.target = target;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}

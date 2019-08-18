package terranigma.abstracts;

import terranigma.Terranigma;
import terranigma.interfaces.CanQueue;
import userInterface.UI;

public abstract class Character implements CanQueue {
	protected String name;
	protected String playerName;
	protected String actMessage;
	// health points
	protected int hp;
	// max health points
	protected int maxHp;
	// magic points
	protected int mp;
	// max magic points
	protected int maxMp;
	// strength
	protected int str;
	// defense
	protected int def;
	// wisdom
	protected int wis;
	// speed
	protected int sp;
	// charge time
	protected int ct = 0;
	protected Character enemy;
	
	
	public Character(
			String name, String playerName, String actMessage,
			int hp, int mp, int str, int def, int wis, int sp
			) {
		this.name = name;
		this.playerName = playerName;
		this.actMessage = actMessage;
		this.hp = hp;
		this.maxHp = hp;
		this.mp = mp;
		this.maxMp = mp;
		this.str = str;
		this.def = def;
		this.wis = wis;
		this.sp = sp;
	}
	
	abstract public void attack();
	abstract public void ability();
	
	public void defend() {
		
	}
	
	public void takeDamage(int value) {
		String message;
		int dmg = value - this.def;
		
		this.setHp(this.hp - dmg);
		if (this.hp < 0) {
			this.hp = 0;
		}
		
		message = this.name + " ha recibido " + dmg + " de daño.";
		UI.get().message(message);
		
		if (!this.isAlive()) {
			this.derrotado();
		}
	}
	
	public void say(String message) {
		message = this.name + "(" + this.playerName + "): " + message;
		UI.get().message(message);
	}
	
	/**
	 * Muestra información del estado del personaje
	 */
	public void showStats() {
		String[][] table = new String[1][];
		// table[0] = new String[] {this.name, "", "", ""};
		table[0] = new String[] {"HP:", this.hp+"/"+this.maxHp, "MP:", this.mp+"/"+this.maxMp};
		
		UI.get().showCharStats(table);
	}
	
	/**
	 * Declara la derrota
	 */
	public void derrotado() {
		Terranigma.get().endGame(this);
	}
	
	/**
	 * @return true, si está vivo; false, si está muerto
	 */
	public boolean isAlive() {
		if (this.hp < 1) {
			return false;
		}
		
		return true;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * @return the maxHp
	 */
	public int getMaxHp() {
		return maxHp;
	}

	/**
	 * @param maxHp the maxHp to set
	 */
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	/**
	 * @return the maxMp
	 */
	public int getMaxMp() {
		return maxMp;
	}

	/**
	 * @param maxMp the maxMp to set
	 */
	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	/**
	 * @return the str
	 */
	public int getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(int str) {
		this.str = str;
	}

	/**
	 * @return the def
	 */
	public int getDef() {
		return def;
	}

	/**
	 * @param def the def to set
	 */
	public void setDef(int def) {
		this.def = def;
	}

	/**
	 * @return the wis
	 */
	public int getWis() {
		return wis;
	}

	/**
	 * @param wis the wis to set
	 */
	public void setWis(int wis) {
		this.wis = wis;
	}

	/**
	 * @return the sp
	 */
	public int getSp() {
		return sp;
	}

	/**
	 * @param sp the sp to set
	 */
	public void setSp(int sp) {
		this.sp = sp;
	}

	/**
	 * @return the ct
	 */
	@Override
	public int getCt() {
		return ct;
	}

	/**
	 * @param ct the ct to set
	 */
	public void setCt(int ct) {
		this.ct = ct;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * @return the enemy
	 */
	public Character getEnemy() {
		return enemy;
	}

	/**
	 * @param enemy the enemy to set
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub
		String[] options = {
				"Atacar",
				"Habilidad",
				"Defender"
		};
		String response;
		
		this.dequeue();
		this.enqueue();
		
		this.say(this.actMessage);
		this.showStats();
		
		response = UI.get().getListResponse(options);
		
		if (response.equals(options[0])) {
			this.attack();
			this.setCt(this.getCt() - 100);
		} else if(response.equals(options[1])) {
			this.ability();
			this.setCt(this.getCt() - 100);
		} else if(response.equals(options[2])) {
			this.defend();
			this.setCt(this.getCt() - 50);
		}
	}

	@Override
	public int compareTo(CanQueue o) {
		// TODO Auto-generated method stub
		return this.getCt() - o.getCt();
	}

	@Override
	public void trigger() {
		// TODO Auto-generated method stub
		this.setCt(this.ct + this.sp);
	}

	@Override
	public void enqueue() {
		// TODO Auto-generated method stub
		Terranigma.get().enqueue(this);
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub
		Terranigma.get().dequeue(this);
	}
	
	

}

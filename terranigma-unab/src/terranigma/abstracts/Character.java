package terranigma.abstracts;

import java.util.ArrayList;
import java.util.List;

import terranigma.Terranigma;
import terranigma.factories.EffectFactory;
import terranigma.interfaces.CanQueue;
import userInterface.UI;

public abstract class Character implements CanQueue {
	protected String name;
	protected String playerName;
	protected String actMessage;
	// health points
	private int hp;
	// max health points
	private int maxHp;
	// magic points
	private int mp;
	// max magic points
	private int maxMp;
	// strength
	private int str;
	// defense
	private int def;
	// wisdom
	private int wis;
	// speed
	private int sp;
	// charge time
	private int ct = 0;
	protected Character enemy;
	protected List<Effect> effects;
	protected List<Ability> abilities;
	protected String iconUri;
	
	
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
		
		this.effects = new ArrayList<Effect>();
		this.abilities = new ArrayList<Ability>();
	}
	
	abstract public void attack();
	
	public void ability() {
		String response;
		String message = "Seleccione habilidad:";
		String[] options = this.getAbilitiesNames();
		
		UI.get().message(message);
		response = UI.get().getListResponse(options);
		
		this.getAbilityByName(response).use();
	}
	
	public void defend() {
		this.takeHeal(10);
		this.takeMp(10);
		Effect e = EffectFactory.get().newEffect("Defensa", this, this);
		e.enqueue();
	}
	
	
	public String[] getAbilitiesNames() {
		String[] names = new String[this.abilities.size()];
		List<String> list = new ArrayList<String>();
		
		for (Ability a : this.abilities) {
			list.add(a.getName());
		}
		
		list.toArray(names);
		
		return names;
	}
	
	public Ability getAbilityByName(String name) {
		for (Ability a : this.abilities) {
			if (a.getName().contentEquals(name)) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * Maneja el daño recibido.
	 * 
	 * @param value
	 */
	public void takeDamage(int value) {
		String message;		
		int dmg = value - Math.round((value * this.getDef())/100);
		
		if (dmg <= 4) {
			dmg = 5;
		}
		
		this.setHp(this.getHp() - dmg);
		if (this.getHp() < 0) {
			this.setHp(0);
		}
		
		message = this.name + " ha recibido " + dmg + " de daño.";
		UI.get().message(message);
		
		if (UI.isGUI()) {
			UI.getGUI().takeDamage(this);
		}
		
		if (!this.isAlive()) {
			this.derrotado();
			
			if (UI.isGUI()) {
				UI.getGUI().defeated();
			}
		}
	}
	
	/**
	 * Maneja la curación recibida.
	 * 
	 * @param value
	 */
	public void takeHeal(int value) {
		String message;
		int heal = value;
		
		this.setHp(this.getHp() + heal);
		
		message = this.name + " ha recibido " + heal + " de curación.";
		UI.get().message(message);
	}
	
	public void takeMp(int value) {
		String message;
		int rise = value;
		
		this.setMp(this.getMp() + rise);
		
		message = this.name + " ha recibido " + rise + " de MP.";
		UI.get().message(message);
	}
	
	public void consumeMp(int value) {
		String message;
		int fall = value;
		
		this.setMp(this.getMp() - fall);
		
		message = this.name + " ha usado " + fall + " de MP.";
		UI.get().message(message);
	}
	
	public void say(String message) {
		message = "\n" + this.name + "(" + this.playerName + "): " + message;
		UI.get().message(message);
	}
	
	
	/**
	 * Muestra información del estado del personaje
	 */
	public void showStats() {
		String[][] table = new String[3][];
		// table[0] = new String[] {this.name, "", "", ""};
		table[0] = new String[] {
				"HP:", this.getHp()+"/"+this.getMaxHp(),
				"MP:", this.getMp()+"/"+this.getMaxMp()
				};
		table[1] = new String[] {
				"str:", Integer.toString(this.getStr()),
				"def:", Integer.toString(this.getDef())
				};
		table[2] = new String[] {
				"wis:", Integer.toString(this.getWis()),
				"sp:", Integer.toString(this.getSp())
				};
		
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
		if (this.getHp() < 1) {
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
		if (hp > this.maxHp) {
			this.hp = this.maxHp;
		} else {
			this.hp = hp;			
		}
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
		if (mp > this.maxMp) {
			this.mp = this.maxMp;
		} else {
			this.mp = mp;			
		}
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
		if (str > 100) {
			this.str = 100;
		}else {
			this.str = str;
		}
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
		if (def > 90) {
			this.def = 90;
		} else {
			this.def = def;
		}
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
		if (wis > 100) {
			this.wis = 100;
		} else {
			this.wis = wis;
		}
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
		if (sp > 100) {
			this.sp = 100;
		} else {
			this.sp = sp;
		}
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
		return this.enemy;
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
			this.setCt(this.getCt() - 60);
		}
		
		this.dequeue();
		this.enqueue();
	}

	@Override
	public int compareTo(CanQueue o) {
		// TODO Auto-generated method stub
		return this.getCt() - o.getCt();
	}

	@Override
	public void trigger() {
		// TODO Auto-generated method stub
		this.setCt(this.getCt() + this.getSp());
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
	
	public Effect findEffect(String name) {
		for (Effect e: this.effects) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	public boolean hasEffect(String name) {
		for (Effect e: this.effects) {
			if (e.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasEffect(Effect e) {
		return this.effects.contains(e);
	}
	
	public void addEffect(Effect e) {
		if(!this.hasEffect(e)) {
			this.effects.add(e);
		}
	}
	
	public void unlistEffect(Effect e) {
		if (this.hasEffect(e)) {
			this.effects.remove(e);			
		}
	}

	/**
	 * @return the iconUri
	 */
	public String getIconUri() {
		return iconUri;
	}

	/**
	 * @param iconUri the iconUri to set
	 */
	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}

}

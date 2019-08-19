package terranigma.abstracts;

import terranigma.Terranigma;
import terranigma.interfaces.CanQueue;
import userInterface.UI;

public abstract class Effect implements CanQueue {
	private Character caller;
	private Character target;
	private String name;
	private int sp;
	private boolean instant = true;
	private int times = 1; // -1 persist
	private boolean stack = true;
	private boolean repeat = true;
	protected int ct = 0;
	
	
	public Effect(Character caller, Character target, String name, int sp) {
		this.caller = caller;
		this.target = target;
		this.name = name;
		this.sp = sp;
	}
	
	public Effect(Character caller, Character target, String name, int sp, boolean instant, int times) {
		this.caller = caller;
		this.target = target;
		this.name = name;
		this.sp = sp;
		this.instant = instant;
		this.times = times;
	}
	
	public Effect(
			Character caller, Character target, String name, int sp,
			boolean instant, int times, boolean stack
			) {
		this.caller = caller;
		this.target = target;
		this.name = name;
		this.sp = sp;
		this.instant = instant;
		this.times = times;
		this.stack = stack;
	}
	
	
	abstract public void apply();
	abstract public void unapply();
	abstract public void updateMessage();
	
	public void efectMessage(String message) {
		// TODO Auto-generated method stub
		UI.get().message(message);
	}
	
	public boolean shouldPersist() {
		if (this.times != 0) {
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	

	/**
	 * @return the repeat
	 */
	public boolean isRepeat() {
		return repeat;
	}

	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	/**
	 * @return the stack
	 */
	public boolean isStack() {
		return stack;
	}

	/**
	 * @return the times
	 */
	public int getTimes() {
		return times;
	}

	/**
	 * @param times the times to set
	 */
	public void setTimes(int times) {
		if (times < -1) {
			this.times = -1;
		} else {
			this.times = times;
		}
	}

	/**
	 * @return the instant
	 */
	public boolean isInstant() {
		return instant;
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
	 * @param ct the ct to set
	 */
	public void setCt(int ct) {
		this.ct = ct;
	}
	
	

	/**
	 * @return the caller
	 */
	public Character getCaller() {
		return caller;
	}

	/**
	 * @return the target
	 */
	public Character getTarget() {
		return target;
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
	public void act() {
		// TODO Auto-generated method stub
		
		this.apply();
		this.setCt(this.getCt() - 100);
		
		this.dequeue();
		this.enqueue();
	}

	@Override
	public int getCt() {
		// TODO Auto-generated method stub
		return this.ct;
	}

	@Override
	public void enqueue() {
		// TODO Auto-generated method stub
		Effect find = this.getTarget().findEffect(this.getName());
		boolean same = false;
		
		if (find != null) {
			if (find.equals(this)) {
				same = true;
			}
		}
		
		if (this.isInstant()) {
			this.setTimes(this.getTimes() - 1);
			this.instant = false;
			
			if (this.isStack() || !this.checkStack()) {
				this.apply();
			}
		}
		
		if (this.shouldPersist()) {
			if (find == null) {
				this.setTimes(this.getTimes() - 1);
				Terranigma.get().enqueue(this);
				this.getTarget().addEffect(this);
			} else if(same) {
				this.setTimes(this.getTimes() - 1);
				Terranigma.get().enqueue(this);
			} else if (this.isStack()) {
				this.setTimes(this.getTimes() - 1);
				Terranigma.get().enqueue(this);
				this.getTarget().addEffect(this);
			} else {
				find.setTimes(this.getTimes() - 1);
				this.updateMessage();
			}
			
		} else {
			this.remove();
		}
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub
		Terranigma.get().dequeue(this);
	}
	
	public void remove() {
		this.dequeue();
		this.unapply();
		this.getTarget().unlistEffect(this);
	}
	
	public boolean checkStack() {
		return this.getTarget().hasEffect(this.getName());
	}
}

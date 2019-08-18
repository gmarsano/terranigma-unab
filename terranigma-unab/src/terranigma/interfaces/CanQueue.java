package terranigma.interfaces;

public interface CanQueue extends Comparable<CanQueue> {
	public void trigger();
	public void act();
	public int getCt();
	public void enqueue();
	public void dequeue();
}

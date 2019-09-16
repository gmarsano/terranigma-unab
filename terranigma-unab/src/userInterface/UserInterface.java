package userInterface;

public interface UserInterface {
	public abstract String getListResponse(String[] list, String message);
	public abstract String getListResponse(String[] list);
	public abstract void message(String message);
	public abstract String request(String message);
	public abstract void showCharStats(String[][] table);
}

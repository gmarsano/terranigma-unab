package terranigma;

import java.util.Scanner;

public class UserInterface {
	private static final UserInterface singleton = new UserInterface();
	
	public static UserInterface get() {
		return singleton;
	}
	
	private UserInterface() {}
	
	public String getListResponse(String[] list) {
		return getListResponse(list,"");
	}
	
	public String getListResponse(String[] list, String message) {
		int index;
		String response;
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println(message);
			for(int i = 1; i <= list.length; i++) {
				System.out.println(i + ": " + list[i-1]);
			}
			System.out.printf(">>>");
			try {
				index = Integer.parseInt(in.nextLine()) - 1;
				response = list[index];
				in.close();
				return response;
			} catch (Exception e) {
				System.out.println("Opción inválida. Intente de nuevo...");
			}
		}	
	}
}

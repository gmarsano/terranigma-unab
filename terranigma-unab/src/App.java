import java.util.Scanner;

import terranigma.Terranigma;
import userInterface.UI;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner in = new Scanner(System.in)) {
			
			UI.setIn(in);
			UI.get();
			Terranigma.get().play();
			
		}
	}

}

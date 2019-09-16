package userInterface.windowbuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserResponseListener implements ActionListener {
	private Vista window;
	
	public UserResponseListener(Vista window) {
		// TODO Auto-generated constructor stub
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (window.getUserInputText().getText().equals("SALIR")) {
			System.exit(0);
		}
		
		if (window.isWaitForResponse()) {
			window.setWaitForResponse(false);
		}
		
	}
}

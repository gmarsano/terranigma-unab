package userInterface.windowbuilder;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DefaultCaret;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Vista extends JFrame {
	
	private boolean waitForResponse;
	private JTextField userInputText;
	// 
	private JTextArea infoArea;
	
	/**
	 * Create the application.
	 */
	public Vista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/userInterface/windowbuilder/images/terranigma_underworld.jpg")));
		setBackground(Color.BLACK);
		setTitle("UNAB - Terranigma 2.0");
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(0, 0, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel screenPanel = new JPanel();
		screenPanel.setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel userInputPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
						.addComponent(userInputPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
						.addComponent(screenPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(screenPanel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userInputPanel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnSendInput = new JButton("Enviar");
		btnSendInput.addActionListener(new UserResponseListener(this));
		userInputPanel.add(btnSendInput);
		this.getRootPane().setDefaultButton(btnSendInput);
		
		userInputText = new JTextField();
		userInputPanel.add(userInputText);
		userInputText.setColumns(80);
		
		//JTextArea infoArea = new JTextArea();
		// Epavez
		infoArea = new JTextArea();
		infoArea.setBackground(Color.BLACK);
		infoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		infoArea.setForeground(Color.GREEN);
		infoArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		infoArea.setEditable(false);
		scrollPane.setViewportView(infoArea);
		getContentPane().setLayout(groupLayout);
		DefaultCaret caret = (DefaultCaret)infoArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}

	/**
	 * @return the waitForResponse
	 */
	public boolean isWaitForResponse() {
		return waitForResponse;
	}

	/**
	 * @param waitForResponse the waitForResponse to set
	 */
	public void setWaitForResponse(boolean waitForResponse) {
		this.waitForResponse = waitForResponse;
	}

	/**
	 * @return the userInputText
	 */
	public JTextField getUserInputText() {
		return userInputText;
	}

	//
	public void setInfoArea(JTextArea infoArea) {
		this.infoArea = infoArea;
	}

	public void setInfoArea(String message) {
		// TODO Auto-generated method stub
		//this.infoArea.setText(message);
		//message = "<HTML> " + message + "<br>";
		this.infoArea.append(message);
		//this.infoArea.setCaretPosition(this.infoArea.get);
		
	}
	
	
	
}

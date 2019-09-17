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
import javax.swing.JLabel;
import javax.swing.JTextPane;

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
		screenPanel.setBounds(10, 11, 998, 355);
		screenPanel.setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 372, 998, 248);
		
		JPanel userInputPanel = new JPanel();
		userInputPanel.setBounds(10, 626, 998, 103);
		
		JLabel lblChar1 = new JLabel("New label");
		
		JLabel lblChar2 = new JLabel("New label");
		
		JTextArea textArea = new JTextArea();
		GroupLayout gl_screenPanel = new GroupLayout(screenPanel);
		gl_screenPanel.setHorizontalGroup(
			gl_screenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_screenPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_screenPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_screenPanel.createSequentialGroup()
							.addComponent(lblChar1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
							.addComponent(lblChar2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		gl_screenPanel.setVerticalGroup(
			gl_screenPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_screenPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_screenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChar1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChar2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addGap(24))
		);
		screenPanel.setLayout(gl_screenPanel);
		
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
		getContentPane().setLayout(null);
		infoArea.setEditable(false);
		scrollPane.setViewportView(infoArea);
		getContentPane().add(scrollPane);
		getContentPane().add(userInputPanel);
		getContentPane().add(screenPanel);
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

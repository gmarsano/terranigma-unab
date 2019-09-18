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
import java.util.Locale;

public class Vista extends JFrame {
	
	private boolean waitForResponse;
	private JTextField userInputText;
	private JTextArea infoArea;
	public PanelImagen screenPanel;
	public JScrollPane scrollPane;
	public JPanel userInputPanel;
	public JLabel lblChar1;
	public JLabel lblChar2;
	public JTextArea char1StatsArea;
	public JTextArea char2StatsArea;
	private JLabel lblSalir;
	public JLabel lblChar1Pointer;
	public JLabel lblChar2Pointer;
	
	
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
		
		screenPanel = new PanelImagen();
		screenPanel.setBounds(10, 11, 998, 355);
		screenPanel.setBackground(Color.BLACK);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 372, 998, 248);
		
		userInputPanel = new JPanel();
		userInputPanel.setBounds(10, 626, 998, 103);
		
		lblChar1 = new JLabel("");
		
		lblChar2 = new JLabel("");
		
		char1StatsArea = new JTextArea();
		char1StatsArea.setFont(new Font("Arial", Font.BOLD, 14));
		char1StatsArea.setForeground(Color.YELLOW);
		char1StatsArea.setOpaque(false);
		char1StatsArea.setEditable(false);
		
		char2StatsArea = new JTextArea();
		char2StatsArea.setFont(new Font("Arial", Font.BOLD, 14));
		char2StatsArea.setForeground(Color.YELLOW);
		char2StatsArea.setOpaque(false);
		char2StatsArea.setEditable(false);
		
		lblChar1Pointer = new JLabel("<<");
		lblChar1Pointer.setVisible(false);
		lblChar1Pointer.setFont(new Font("Arial", Font.BOLD, 36));
		lblChar1Pointer.setForeground(Color.YELLOW);
		
		lblChar2Pointer = new JLabel(">>");
		lblChar2Pointer.setVisible(false);
		lblChar2Pointer.setForeground(Color.YELLOW);
		lblChar2Pointer.setFont(new Font("Arial", Font.BOLD, 36));
		
		GroupLayout gl_screenPanel = new GroupLayout(screenPanel);
		gl_screenPanel.setHorizontalGroup(
			gl_screenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_screenPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_screenPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_screenPanel.createSequentialGroup()
							.addComponent(char1StatsArea, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
							.addComponent(char2StatsArea, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_screenPanel.createSequentialGroup()
							.addComponent(lblChar1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(lblChar1Pointer, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(lblChar2Pointer, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(lblChar2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		gl_screenPanel.setVerticalGroup(
			gl_screenPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_screenPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_screenPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_screenPanel.createSequentialGroup()
							.addGroup(gl_screenPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(char1StatsArea, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(char2StatsArea, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_screenPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChar1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChar2, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
							.addGap(24))
						.addGroup(Alignment.TRAILING, gl_screenPanel.createSequentialGroup()
							.addGroup(gl_screenPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChar1Pointer, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChar2Pointer, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(160))))
		);
		screenPanel.setLayout(gl_screenPanel);
		
		JButton btnSendInput = new JButton("Enviar");
		btnSendInput.setBounds(20, 5, 69, 23);
		btnSendInput.addActionListener(new UserResponseListener(this));
		userInputPanel.setLayout(null);
		userInputPanel.add(btnSendInput);
		this.getRootPane().setDefaultButton(btnSendInput);
		
		userInputText = new JTextField();
		userInputText.setLocale(new Locale("es", "CL"));
		userInputText.setFont(new Font("Arial", Font.PLAIN, 12));
		userInputText.setBounds(96, 6, 646, 20);
		userInputPanel.add(userInputText);
		userInputText.setColumns(20);
		
		infoArea = new JTextArea();
		infoArea.setBackground(Color.BLACK);
		infoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		infoArea.setForeground(Color.GREEN);
		infoArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret)infoArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		getContentPane().setLayout(null);
		
		scrollPane.setViewportView(infoArea);
		getContentPane().add(scrollPane);
		getContentPane().add(userInputPanel);
		
		lblSalir = new JLabel("Para terminar escriba SALIR y presione ENTER");
		lblSalir.setForeground(Color.BLACK);
		lblSalir.setBounds(96, 30, 277, 13);
		lblSalir.setFont(new Font("Arial", Font.BOLD, 12));
		lblSalir.setFocusable(false);
		lblSalir.setEnabled(false);
		userInputPanel.add(lblSalir);
		getContentPane().add(screenPanel);
		
		
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

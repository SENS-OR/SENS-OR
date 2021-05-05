package cs3337;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginScreen implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private JLabel lblStatus;
	private Authentication authenticate = new Authentication();

	/**
	 * Launch the application.
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginScreen window = new LoginScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
 */
	/**
	 * Create the application.
	 
//	public void CreateLoginScreen() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginScreen window = new LoginScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
 * */

	public LoginScreen() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/rsz_senseorlogo.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 20, 206, 83);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(73, 127, 65, 14);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(73, 207, 90, 14);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(73, 165, 89, 14);
		
		textField = new JTextField();
		textField.setBounds(182, 124, 141, 20);
		textField.setColumns(10);
		//textField.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 162, 141, 20);
		
		btnSubmit = new JButton("Enter");
		btnSubmit.setBounds(234, 201, 89, 23);
		btnSubmit.addActionListener(this);
		
		
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(lblNewLabel);
		frame.add(lblNewLabel_1);
		frame.add(lblNewLabel_1_1);
		frame.add(lblStatus);
		frame.add(textField);
		frame.add(passwordField);
		frame.add(btnSubmit);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//input used in textField and then pressing enter push into authentication
		if(e.getSource()==btnSubmit){
			//call the athenticate function
			AuthenticateUser();
		}
	}
	
	private void AuthenticateUser() {
		if(authenticate.Authenticate(textField.getText(),String.valueOf(passwordField.getPassword()))) {
			lblStatus.setText("Access Granted");
			
			Main main = new Main();
			frame.setVisible(false);
		}
		else {
			lblStatus.setText("Access Denied");
		}
	}
}

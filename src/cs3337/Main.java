package cs3337;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main();
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
	 
	public void CreateMainScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/	
	
	
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(81, 11, 258, 182);
		frame.getContentPane().add(panel);
		
		JButton btnScreenShot = new JButton("Take Screenshot");
		btnScreenShot.setBounds(81, 214, 134, 23);
		frame.getContentPane().add(btnScreenShot);
		
		JButton btnExit = new JButton("Exit program");
		btnExit.setBounds(232, 214, 107, 23);
		
		frame.getContentPane().add(btnExit);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}

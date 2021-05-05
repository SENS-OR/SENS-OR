package cs3337;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class Main implements ActionListener{

	//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
	private JFrame frame;	
	
	
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

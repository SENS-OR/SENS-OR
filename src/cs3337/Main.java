package cs3337;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
	
	static JFrame frame;	
	static JLabel lbl;
	static ImageIcon icon;
	JButton btnExit;
	
	public Main() {
		//empty contrusctor
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//call the class for the login screen and after the logging in call the main.java class
		StartApp start = new StartApp();
		Main main = new Main();
		main.StartCam();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void StartCam() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		
		CascadeClassifier cascadeFaceClassifier = new CascadeClassifier(
				"C:/Users/rarom/Downloads/opencv/build/etc/haarcascades/haarcascade_frontalface_default.xml");

		VideoCapture videoDevice = new VideoCapture();
		videoDevice.open(0);
		if (videoDevice.isOpened()) {
			System.out.println("Screen recording");
			while (true) {		
				Mat frameCapture = new Mat();
				videoDevice.read(frameCapture);

				MatOfRect faces = new MatOfRect();
				cascadeFaceClassifier.detectMultiScale(frameCapture, faces);								
				for (Rect rect : faces.toArray()) {
					Imgproc.putText(frameCapture, "Face", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));								
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(0, 100, 0),3);
				}

				PushImage(ConvertMat2Image(frameCapture));
			}
		} else {
			return;
		}
	}

	private static BufferedImage ConvertMat2Image(Mat kameraVerisi) {
		MatOfByte byteMatVerisi = new MatOfByte();
		Imgcodecs.imencode(".jpg", kameraVerisi, byteMatVerisi);
		byte[] byteArray = byteMatVerisi.toArray();
		BufferedImage goruntu = null;
		try {
			InputStream in = new ByteArrayInputStream(byteArray);
			goruntu = ImageIO.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return goruntu;
	}

	
//	public static void PencereHazirla() {
//		frame = new JFrame();
//		frame.setLayout(new FlowLayout());
//		frame.setSize(700, 600);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	
	public void PushImage(Image img2) {
		//Pencere olu?turulmamy? ise hazyrlanyr
		if (frame == null)
			Initialize();
		//Daha önceden bir görüntü yüklenmi? ise yenisi için kaldyryr
		if (lbl != null)
			frame.remove(lbl);
		icon = new ImageIcon(img2);
		lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		//Frame nesnesini yeniler
		frame.revalidate();
	}



	private void Initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setSize(700,600);
		frame.getContentPane().setLayout(new FlowLayout());

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(81, 11, 258, 182);
		frame.getContentPane().add(panel);

		JButton btnScreenShot = new JButton("Take Screenshot");
		btnScreenShot.setBounds(81, 214, 134, 23);
		frame.getContentPane().add(btnScreenShot);

		btnExit = new JButton("Exit program");
		btnExit.setBounds(232, 214, 107, 23);
		btnExit.addActionListener(this);

		//frame.getContentPane().add(btnExit);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		frame.add(btnExit);
	}
	
	public Frame GetFrame() {
		return frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit){
			//call the athenticate function
			System.exit(0);
		}
	}
}

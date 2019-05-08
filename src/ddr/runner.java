package ddr;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class runner {
	JFrame frame;
	Panel panel;
	final int WIDTH = 800;
	final int HEIGHT = 800;
	
	public runner() {
		
		frame = new JFrame();
		panel= new Panel();
		frame.add(panel); 	
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(panel);
        setUp();
	}
	
	public static void main(String[] args) {
	new runner();	
	}
	
	public void setUp() {
		
	}
}

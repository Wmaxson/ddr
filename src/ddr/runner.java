package ddr;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class runner {
	JFrame frame;
	Panel panel;
	final int WIDTH = 500;
	final int HEIGHT = 800;
	
	public runner() {
		
		frame = new JFrame();
		panel= new Panel();
		frame.add(panel); 	
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setVisible(true);
        setUp();
	}
	
	public static void main(String[] args) {
	new runner();	
	}
	
	public void setUp() {
		
	}
}

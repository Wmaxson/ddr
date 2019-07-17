package ddr;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class runner implements ActionListener{
	JFrame frame;
	Panel panel;
	int WIDTH = 800;
	int HEIGHT = 1000;
	Boolean bossActive;
	Timer timer;
	public runner() {
		Timer timer = new Timer();
		
		bossActive = false;
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
	
	public void actionPerformed(ActionEvent e) {
		bossActive = panel.getBossAlive();
		System.out.println("Yeet " + bossActive);
		if (bossActive) {
			frame.getContentPane().setPreferredSize(new Dimension(WIDTH, 1000));
		}
	}
	
	public void setUp() {
		
	}
}

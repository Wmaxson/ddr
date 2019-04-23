package ddr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {

	Timer timer;
	
	public Panel() {
		
		timer = new Timer(1000/60, this);
		
		gameStart();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("yee");
		
	}
	public void gameStart() {
		timer.start();
	}
	
}

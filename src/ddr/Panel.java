package ddr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener, KeyListener{  

	Timer timer;
	GameObject obj;
	public Panel() {
		
		timer = new Timer(1000/60, this);
		
		gameStart();
		
		obj = new GameObject(10,10,0,0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("yee");
		repaint();
		
	}
	@Override
	public void paintComponent(Graphics g){
		obj.draw(g);    
	 }
	
	public void gameStart() {
		timer.start();
	}
	@Override
	

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("typed");
	}
	@Override
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");
	}
	@Override

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("released");
	}
	
}

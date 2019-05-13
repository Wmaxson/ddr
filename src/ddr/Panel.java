package ddr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;
public class Panel extends JPanel implements ActionListener, KeyListener{  
	
	player Player;
	Timer timer;
	GameObject obj;
	
	long startTime = 0;
	long endTime = 0;
	public static long totalMS = 0;
	public static float frameTime = 0;
	public static float totalTime = 0;
	
	public Panel() {
				
		timer = new Timer(1000/60, this);
		
		Player = new player(375, 375, 50,50);
		
		gameStart();
		
		obj = new GameObject(10,10,0,0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Player.update();
		//System.out.println("yee");
		repaint();
		
		endTime = System.currentTimeMillis();
		totalMS = endTime-startTime;
		frameTime = (float)(endTime-startTime)/1000.0f;
		totalTime+=frameTime;
		startTime = endTime;
		System.out.println(totalTime);
		
	}
	@Override
	public void paintComponent(Graphics g){
		obj.draw(g);  
		Player.draw(g);
		Player.drawSheild(g);
	 }
	
	public void gameStart() {
		startTime = System.currentTimeMillis();
		timer.start();
	}
	@Override
	

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("typed");
	}
	@Override
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed");
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Player.dir = "u";
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Player.dir = "d";
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Player.dir = "l";
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Player.dir = "r";
		} else {
			
		}
		
	}
	@Override

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("released");
	}
	
}

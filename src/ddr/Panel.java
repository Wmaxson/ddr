package ddr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Panel extends JPanel implements ActionListener, KeyListener{  
	
	player Player;
	Timer timer;
	GameObject obj;
	boss bE;
	Boolean bossAlive;
	long startTime = 0;
	long endTime = 0;
	public static long totalMS = 0;
	public static float frameTime = 0;
	public static float totalTime = 0;
	int v;
	int h;
	JLabel playerI;
	enemyManager man = new enemyManager();
	sound s;
	enemy Enemy1 = new enemy(350,20,75,75,10, 1);
	enemy Enemy2 = new enemy(350,780,75,75,10, 4);
	enemy Enemy3 = new enemy(20,350,75,75,10, 3);
	enemy Enemy4 = new enemy(700,350,75,75,10, 2);
	Font font = new Font("TimesRoman", Font.PLAIN, 30);
	public static BufferedImage br;
	public static BufferedImage bs;
	int e1;
	Boolean e2;
	Boolean y;
	public Panel() {
		
		playerI = new JLabel();	
		y = true;
		 try {
			br = ImageIO.read(this.getClass().getResourceAsStream("pixil-frame-0.png"));
			bs = ImageIO.read(this.getClass().getResourceAsStream("pixil-frame-0 (3).png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer = new Timer(1000/60, this);
		gameStart();
		obj = new GameObject(10,10,0,0);
		bossAlive = false;
		bE = new boss(350, 20, 100, 100, 1000);
		s = new sound();
		setLayout(null);
		add(playerI);
		e1 = 0;
		e2 = false;
		v = 0;
		h = 400;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Yeet " + bossAlive);
		if (v >= 0) {
			h-=v;
		} else {
			v = 0;
		}
		v--;
		if (bossAlive && y) {
			v = 28;
			y = false;
		}
		
		if (e1 == 1) {
			if (e2 == false) {
				Player = new player(385, 350, 50,50);
				playerI.setIcon(new ImageIcon(getClass().getResource("player.gif")));
				playerI.setBounds(Player.x, Player.y, 50, 50);
				e2 = true;
			}
			
			checkCollision();
			Player.update();
			man.update();
			
			Enemy1.update();
			Enemy2.update();
			Enemy3.update();
			Enemy4.update();
			
			//System.out.println("yee");
			repaint();
			endTime = System.currentTimeMillis();
			totalMS += endTime-startTime;
			frameTime = (float)(endTime-startTime)/1000.0f;
			totalTime+=frameTime;
			startTime = endTime;
			System.out.println(totalTime);
			
			man.getEnemyAlive1(Enemy1.isAlive);
			man.getEnemyAlive2(Enemy2.isAlive);
			man.getEnemyAlive3(Enemy3.isAlive);
			man.getEnemyAlive4(Enemy4.isAlive);
			
			if (Player.isAlive == false) {
				e1++;
			}
			
			
			if (e1>=2) {
				e1=0;
			}
		}
		
	}
	@Override
	public void paintComponent(Graphics g){ //yeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeet
		if (e1 == 0) {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, 800, 1000);
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString("They stole your taco! Rescue your taco! Get Revenge!", 80, 400);
			g.drawString("(Press Space to continue)", 200, 470);
		} else if (e1 == 1) {
			g.setColor(Color.white);
			g.fillRect(0, 800, 800, 200);
			g.drawImage(br, 0,0,800,800, null);
			g.drawImage(bs, 200,800,400,200, null);
			g.setColor(Color.white);
			g.fillRect(0, 800, 800, h);
			obj.draw(g);  
			Player.draw(g);
			Player.drawSheild(g);
			
			Enemy1.draw(g);;
			Enemy2.draw(g);;
			Enemy3.draw(g);;
			Enemy4.draw(g);;
			man.dlList(g);
		}
		
		
		
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
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			e1++;
		}
		
	}
	@Override

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("released");
	}
	public void drawScreen() {
		
	};
	
	public Boolean getBossAlive() {
		return bossAlive;
	}
	
	public void checkCollision() {
		for (int i = 0; i < man.lazerList.size(); i++) {
					
			if(Player.r.intersects(man.lazerList.get(i).hitBox)){
				if (man.lazerList.get(i).dir == 1) {
					Enemy1.health -= 10;
					}
					if (man.lazerList.get(i).dir == 2) {
					Enemy2.health -= 10;
					}
					if (man.lazerList.get(i).dir == 3) {
					Enemy3.health -= 10;
					}
					if (man.lazerList.get(i).dir == 4) {
					Enemy4.health -= 10;
					
					}
					
					man.lazerList.get(i).isAlive = false;
					System.out.println("e");
					
				}
			
			if(Player.hitBox.intersects(man.lazerList.get(i).hitBox)){
				
				man.lazerList.get(i).isAlive = false;
		        System.out.println("e");
		        Player.health -= 0; //REEE
		        bossAlive = true;
			}
		}
	}
	
}

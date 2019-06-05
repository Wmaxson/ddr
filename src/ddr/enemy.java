package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class enemy extends GameObject {
	double health;
	int v;
	 public static BufferedImage enemy1;
	 public static BufferedImage enemy2;
	 Random randy;
	 int ran;
	public enemy(int x1, int y1, int width1, int height1, double health1) {
		super(x1, y1, width1, height1);
		
		try {
			enemy1 = ImageIO.read(this.getClass().getResourceAsStream("enemy1.png"));
			enemy2 = ImageIO.read(this.getClass().getResourceAsStream("enemy2.png"));
			enemy1 = ImageIO.read(this.getClass().getResourceAsStream("enemy1.png"));
			enemy1 = ImageIO.read(this.getClass().getResourceAsStream("enemy1.png"));
			enemy1 = ImageIO.read(this.getClass().getResourceAsStream("enemy1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		health = health1;
		v = 0;
		y-=100;
		v=40;
		randy = new Random();
		ran = randy.nextInt(2);
		//ran = 1;
	}
	
	public void update() {
		
		if (health <= 0) {
			isAlive = false;
			reset();
			
		}
		System.out.println("v = " + v);
		y+=v/5;
		if (v>0) {
			v--;
		}
		
		
		
	}
	
	public void draw(Graphics g) {
		if (isAlive) {
			
		
		g.setColor(Color.YELLOW);
		if (ran == 0) {
			g.drawImage(enemy1, x, y, width, height, null);
		} else if (ran == 1) {
			g.drawImage(enemy2, x, y, width, height, null);
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(x, +150, 100, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x, +150, (int) health, 10);
		
		}
	}
	public void reset() {
		isAlive = true;
		health = 100;
		v = 0;
		y = -100;
		v=40;
		randy = new Random();
		ran = randy.nextInt(2);
	}
	
	
}

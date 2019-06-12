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
	 public static BufferedImage m1;
		public static BufferedImage m2;
		public static BufferedImage f1;
		public static BufferedImage f2;
		public static BufferedImage p1;
		public static BufferedImage p2;
		public static BufferedImage w1;
		public static BufferedImage w2;
		public static BufferedImage ma;
		public static BufferedImage fa;
		public static BufferedImage pa;
		public static BufferedImage wa;
	public enemy(int x1, int y1, int width1, int height1, double health1) {
		super(x1, y1, width1, height1);
		
		try {
			
			m1 = ImageIO.read(this.getClass().getResourceAsStream("mud1.png"));
			m2 = ImageIO.read(this.getClass().getResourceAsStream("mud2.png"));
			f1 = ImageIO.read(this.getClass().getResourceAsStream("fire1.png"));
			f2 = ImageIO.read(this.getClass().getResourceAsStream("fire2.png"));
			p1 = ImageIO.read(this.getClass().getResourceAsStream("plant1.png"));
			p2 = ImageIO.read(this.getClass().getResourceAsStream("plant2.png"));
			w1 = ImageIO.read(this.getClass().getResourceAsStream("water1.png"));
			w2 = ImageIO.read(this.getClass().getResourceAsStream("water2.png"));
			ma = ImageIO.read(this.getClass().getResourceAsStream("mud2.png"));
			fa = ImageIO.read(this.getClass().getResourceAsStream("fireArrow.png"));
			pa = ImageIO.read(this.getClass().getResourceAsStream("plantArrow.png"));
			wa = ImageIO.read(this.getClass().getResourceAsStream("waterArrow.png"));
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
			g.drawImage(m1, x, y, width, height, null);
		} else if (ran == 1) {
			g.drawImage(m2, x, y, width, height, null);
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

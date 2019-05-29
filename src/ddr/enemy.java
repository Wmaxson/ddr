package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class enemy extends GameObject {
	double health;
	 public static BufferedImage enemy1;
	public enemy(int x1, int y1, int width1, int height1, double health1) {
		super(x1, y1, width1, height1);
		
		try {
			enemy1 = ImageIO.read(this.getClass().getResourceAsStream("enemy1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		health = health1;
	}
	
	public void update() {
		
		if (health <= 0) {
			isAlive = false;
		}
	}
	
	public void draw(Graphics g) {
		if (isAlive) {
			
		
		g.setColor(Color.YELLOW);
		g.drawImage(enemy1, x, y, width, height, null);
		g.setColor(Color.BLACK);
		g.fillRect(x, +150, 100, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x, +150, (int) health, 10);
		}
	}

	
	
}

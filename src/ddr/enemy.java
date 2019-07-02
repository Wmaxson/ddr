package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class enemy extends GameObject {
	double health;
	int v;
	public static BufferedImage enemy1;
	public static BufferedImage enemy2;
	Random randy;
	int ran;
	int eee;
	int startX;
	int startY;
	int lives;
	int maxLives;
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
	private static Image hand;
	Boolean bossAlive;

	public enemy(int x1, int y1, int width1, int height1, double health1, int ee) {
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
			hand = new ImageIcon(getClass().getResource("pixil-gif-drawing.gif")).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lives = 3;
		health = health1;
		v = 0;
		startX = x1;
		startY = y1;
		v = 30;
		eee = ee;
		randy = new Random();
		ran = randy.nextInt(2);
		// ran = 1;
		bossAlive = false;
	}

	public int update(Boolean bossalive) {

		if (health <= 0) {
			isAlive = false;
			if (lives > 0) {
				reset();
			}
		}

		System.out.println("v = " + v);

		if (eee == 1) {

			y += v / 5;
			if (v > 0) {
				v--;
			}
		}

		if (eee == 2) {

			x -= v / 5;
			if (v > 0) {
				v--;

			}
		}

		if (eee == 3) {

			x += v / 5;
			if (v > 0) {
				v--;

			}
		}
		if (eee == 4) {

			y -= v / 5;
			if (v > 0) {
				v--;

			}
		}
		
		
		
		bossAlive = bossalive;
		if (bossAlive) {
			lives = 2;
		}
		
		return lives;

	}

	public void draw(Graphics g) {
		if (isAlive) {

			g.setColor(Color.YELLOW);

			if (eee == 1) {

				if (ran == 0) {
					g.drawImage(m1, x, y, width, height, null);
				} else if (ran == 1) {
					g.drawImage(m2, x, y, width, height, null);
				} else if (bossAlive) {
					g.drawImage(hand, x, y, width, height, null);
				}
			} else if (eee == 2) {

				if (ran == 0) {
					g.drawImage(f1, x, y, width, height, null);
				} else if (ran == 1) {
					g.drawImage(f2, x, y, width, height, null);
				} else if (bossAlive) {
					g.drawImage(hand, x, y, width, height, null);
				}
			} else if (eee == 3) {

				if (ran == 0) {
					g.drawImage(w1, x, y, width, height, null);
				} else if (ran == 1) {
					g.drawImage(w2, x, y, width, height, null);
				} else if (bossAlive) {
					g.drawImage(hand, x, y, width, height, null);
				}
			} else if (eee == 4) {

				if (ran == 0) {
					g.drawImage(p1, x, y, width, height, null);
				} else if (ran == 1) {
					g.drawImage(p2, x, y, width, height, null);
				} else if (bossAlive) {

					g.drawImage(hand, x, y, width, height, null);
				
				}
			
			}
			
			if (bossAlive) {
				g.drawString("Prepare to be destroyed", 300, 1000);
			}
			
			g.setColor(Color.BLACK);
			g.fillRect(x, y + 75, 100, 10);
			g.setColor(Color.GREEN);
			g.fillRect(x, y + 75, (int) health, 10);
			bossAlive = true;

		}
	}

	public void reset() {

		isAlive = true;
		health = 10;
		v = 30;
		// enemy Enemy1 = new enemy(350,20,75,75,100, 1);
		// enemy Enemy2 = new enemy(780,350,75,75,100, 2);
		// enemy Enemy3 = new enemy(20,350,75,75,100, 3);
		// enemy Enemy4 = new enemy(350,780,75,75,100, 4);
		x = startX;
		y = startY;
		randy = new Random();
		ran = randy.nextInt(2);
		lives--;

	}

}

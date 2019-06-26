package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class lazers extends GameObject{
		int dir;
		int speed;
		Image fireArrow;
		Image mudArrow;
		Image plantArrow;
		Image waterArrow;
	public lazers(int x1, int y1, int width1, int height1, int dir1, int speed1) {
		super(x1, y1, width1, height1);
		dir = dir1;
		speed = speed1;
		
		try {
			fireArrow = ImageIO.read(this.getClass().getResourceAsStream("fireArrow.png"));
			mudArrow = ImageIO.read(this.getClass().getResourceAsStream("plantArrow.png"));
			plantArrow = ImageIO.read(this.getClass().getResourceAsStream("plantArrow.png"));
			waterArrow = ImageIO.read(this.getClass().getResourceAsStream("waterArrow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
			//1 = Up
			//2 = Down
			//3 = Left
			//4 = Right
	
	public void update() {

		
		if (dir == 1) {
			y+=speed;
		} else if (dir == 2) {
			y-=speed;
		} else if (dir == 3) {
			x+=speed;
		} else if (dir == 4) {
			x-=speed;
		} else {
			
		}
		
		super.update();
	}
	
	public void draw(Graphics g) {
		if (isAlive) {
			if (dir == 1) {
				g.drawImage(mudArrow, x, y, null);
			} else if (dir == 2) {
				g.drawImage(plantArrow, x, y,  null);
			} else if (dir == 3) {
				g.drawImage(waterArrow, x, y,  null);
			} else if (dir == 4) {
				g.drawImage(fireArrow, x, y,  null);
			} else {
				
			}
		g.setColor(Color.RED);
	    
		}
		}

	
	
}

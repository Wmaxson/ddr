package ddr;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	 int x;
     int y;
     int width;
     int height;
     Rectangle hitBox;
     Boolean isAlive;
     
     
 	public GameObject(int x1, int y1, int width1, int height1) {
		x = x1;
		y = y1;
		width = width1;
		height = height1;
		hitBox = new Rectangle(x, y, width, height);
		isAlive = true;
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void update() {
        hitBox.setBounds(x, y, width, height);
	}
	
}

package ddr;

import java.awt.Graphics;

public class GameObject {

	 int x;
     int y;
     int width;
     int height;
	
 	public GameObject(int x1, int y1, int width1, int height1) {
		x = x1;
		y = y1;
		width = width1;
		height = height1;
		
	}
	
	public void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);  
	}
	
	public void update() {
		
	}
	
}

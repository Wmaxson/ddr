package ddr;

import java.awt.Color;
import java.awt.Graphics;

public class lazers extends GameObject{
		int dir;
		int speed;
	public lazers(int x1, int y1, int width1, int height1, int dir1, int speed1) {
		super(x1, y1, width1, height1);
		dir = dir1;
		speed = speed1;
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
		g.setColor(Color.RED);
	    g.fillRect(x, y, width, height);
		}
		}

	
	
}

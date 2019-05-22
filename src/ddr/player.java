package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class player extends GameObject {
	String dir;
	int sX;
	int sY;
	Rectangle r;
	
	public player(int x1, int y1, int width1, int height1) {
		
		super(x1, y1, width1, height1);
		dir = "";
		sX = 0;
		sY = 0;
		r = new Rectangle();
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		 g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);
	     
	     
	}
	
	public void drawSheild(Graphics g){
		 g.setColor(Color.GREEN);
	     
		 if (dir.equals("u")) {
			 g.fillRect(x-25, y-25, 100, 20);
			 r.width = 100;
			 r.height = 20;
			 r.x = x-25;
			 r.y = y-25;
		} else if (dir.equals("d")) {
			 g.fillRect(x-25, y+55, 100, 20);
			 r.width = 100;
			 r.height = 20;
			 r.x = x-25;
			 r.y = y+55;
		} else if (dir.equals("l")) {
			 g.fillRect(x-25, y-25, 20, 100);
			 r.width = 20;
			 r.height = 100;
			 r.x = x-25;
			 r.y = y-25;
		} else if (dir.equals("r")) {
			g.fillRect(x+55, y-25, 20, 100);
			r.width = 20;
			 r.height = 100;
			 r.x = x+55;
			 r.y = y-25;
		} else {
			
		}
		 
	    
	    
	     
	
	}
	public void update(){
		super.update();
		if (isAlive = false) {
			System.exit(0);
		}
	}

}

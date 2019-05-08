package ddr;

import java.awt.Color;
import java.awt.Graphics;

public class player extends GameObject {
	String dir;
	int sX;
	int sY;
	public player(int x1, int y1, int width1, int height1) {
		super(x1, y1, width1, height1);
		dir = "";
		sX = 0;
		sY = 0;
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
		} else if (dir.equals("d")) {
			 g.fillRect(x-25, y+55, 100, 20);
		} else if (dir.equals("l")) {
			 g.fillRect(x-25, y-25, 20, 100);
		} else if (dir.equals("r")) {
			g.fillRect(x+55, y-25, 20, 100);
		} else {
			
		}
		 
	    
	    
	     
	
	}
	public void update(){
		
	}

}

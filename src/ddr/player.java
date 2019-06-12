package ddr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle; //Condence?
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class player extends GameObject {
	String dir;
	int sX;
	int sY;
	Rectangle r;
	int health;
	public static BufferedImage player1;
	
	public player(int x1, int y1, int width1, int height1) { 
		
		super(x1, y1, width1, height1);
		dir = "";
		sX = 0;
		sY = 0;
		r = new Rectangle();
		health = 3;
		try {
			player1 = ImageIO.read(this.getClass().getResourceAsStream("player.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics g){ //Setup images
		 g.setColor(Color.BLUE);
	     g.drawImage(player1, x, y, width, height, null);
	     g.setColor(Color.BLACK);
	     g.fillRect(350, y+90, 100, 10);
	     g.setColor(Color.RED);
	     g.fillRect(350, y+90, health*34, 10);
	     
	}
	
	public void drawSheild(Graphics g){ //Make me more efficent: (Arrays?)
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
		if (isAlive == false) {
		}
		if (health <= 0) {
			isAlive = false;
		}
	}

}

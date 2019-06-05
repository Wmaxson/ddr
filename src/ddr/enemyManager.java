package ddr;

import java.awt.Graphics;
import java.util.ArrayList;



public class enemyManager {
	int listPlace = 0;
	
	ArrayList<lazers> lazerList; 
	lazers lazer;
	player Player;
	long launchtime = 0;
	enemy e;
	Boolean eA;
	public enemyManager() {
	
	lazerList= new ArrayList<>();	
	launchtime = Panel.totalMS;
	eA = true;
	
	}
	
	public void update() {
		System.out.println("totalMS = " + Panel.totalMS);
		
		
		
		if (launchtime <= Panel.totalMS) {
			
			
			
			if (attackPatternObject.patT[listPlace] == 0) {
				
			launchtime += 100;
				
			}else if(attackPatternObject.patT[listPlace] == 1) {
				
				lazerList.add(new lazers(395,0,10,50,1, 3));
				
			}else if(attackPatternObject.patT[listPlace] == 2) {
				
				lazerList.add(new lazers(395,800,10,50,2, 3));
				
			}else if(attackPatternObject.patT[listPlace] == 3) {
				
				lazerList.add(new lazers(0,395,50,10,3, 3));
				
			}else if(attackPatternObject.patT[listPlace] == 4) {
				
				lazerList.add(new lazers(800,395,50,10,4,3 ));
				
			}
			listPlace++;
			
			if (listPlace >= attackPatternObject.patT.length) {
				listPlace = 0;
			}
			
			if (eA == false) {
				listPlace = 0;
			}
			
			
		}
		
		
		
		for (int i = 0; i < lazerList.size(); i++) {

			lazerList.get(i).update();
			System.out.println("Me too!");
			if (lazerList.get(i).isAlive == false) {
				lazerList.remove(i);
			}
		}
			
		
	}

	public void dlList(Graphics g) {
		System.out.println();
		for (int i = 0; i < lazerList.size(); i++) {
			
			lazerList.get(i).draw(g);
			
			
		}
	}
	
	public Boolean getEnemyAlive(Boolean e) {
		eA=e;
		return e;
		
	}
	
	
	
}

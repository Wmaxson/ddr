package ddr;

import java.util.ArrayList;



public class enemyManager {
	int listPlace = 0;
	ArrayList<lazers> lazerList; 
	lazers lazer;
	long launchtime = 0;
	public enemyManager() {
	lazerList= new ArrayList<>();	
	launchtime = Panel.totalMS;
	}
	
	public void update() {
		if (launchtime == Panel.totalMS) {
			if (attackPatternObject.pat[listPlace] == 0) {
				
			launchtime += 100;
				
			}else if(attackPatternObject.pat[listPlace] == 1) {
				
				lazerList.add(new lazers(395,0,10,50,1));
				
			}else if(attackPatternObject.pat[listPlace] == 2) {
				
				lazerList.add(new lazers(395,800,10,50,2));
				
			}else if(attackPatternObject.pat[listPlace] == 3) {
				
				lazerList.add(new lazers(0,395,50,10,3));
				
			}else if(attackPatternObject.pat[listPlace] == 4) {
				
				lazerList.add(new lazers(800,395,50,10,4));
				
			}
			listPlace++;
		}
			
		
	}

	public void lList() {
		for (int i = 0; i < lazerList.size(); i++) {
			
			
		}
	}
}

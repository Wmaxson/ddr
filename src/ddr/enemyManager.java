package ddr;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class enemyManager {
	int listPlace = 0;

	ArrayList<lazers> lazerList;
	lazers lazer;
	player Player;
	long launchtime = 0;
	enemy e;
	Boolean eA1;
	Boolean eA2;
	Boolean eA3;
	Boolean eA4;

	// ImageIcon ii = new
	// ImageIcon(this.getClass().getResource("pixel-gif-drawing"));
	public enemyManager() {

		lazerList = new ArrayList<>();
		launchtime = Panel.totalMS;
		eA1 = true;
		eA2 = true;
		eA3 = true;
		eA4 = true;

	} // yeet

	public void update(Boolean b) {
		System.out.println("totalMS = " + Panel.totalMS);

		if (launchtime <= Panel.totalMS) {

			if (attackPatternObject.patT[listPlace] == 0) {

				launchtime += 100;

			} else if (attackPatternObject.patT[listPlace] == 1 && eA1) {

				lazerList.add(new lazers(395, 0, 10, 50, 1, 3));

			} else if (attackPatternObject.patT[listPlace] == 2 && eA2) {

				lazerList.add(new lazers(395, 800, 10, 50, 2, 3));

			} else if (attackPatternObject.patT[listPlace] == 3 && eA3) {

				lazerList.add(new lazers(0, 395, 50, 10, 3, 3));

			} else if (attackPatternObject.patT[listPlace] == 4 && eA4) {

				lazerList.add(new lazers(800, 395, 50, 10, 4, 3));

			}
			listPlace++;

			if (listPlace >= attackPatternObject.patT.length) {
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

	public Boolean getEnemyAlive4(Boolean e) {
		eA4 = e;
		return eA4;

	}

	public Boolean getEnemyAlive1(Boolean e) {
		eA1 = e;
		return eA1;

	}

	public Boolean getEnemyAlive2(Boolean e) {
		eA2 = e;
		return eA2;

	}

	public Boolean getEnemyAlive3(Boolean e) {
		eA3 = e;
		return eA3;

	}

}

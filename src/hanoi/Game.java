package hanoi;

import hanoiGui.MainForm;

public class Game {
	static Tower[] towers;

	public static void main(String[] args) throws GeneralException {
		initTowers();
		MainForm mf = new MainForm();
		// init main form (display towers)
		// ask input for game size
		// display discs
		// listen for move input
		// move towers
		// display towers
	}

	public static void initTowers() throws GeneralException {
		towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower();
		}
	}

}

package hanoiGui;

import hanoi.Disc;
import hanoi.EndTower;
import hanoi.GeneralException;
import hanoi.MiddleTower;
import hanoi.StartTower;
import hanoi.Tower;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Tower[] towers;
	private static GamePanel gp1;
	private static GamePanel gp2;
	private static GamePanel gp3;
	public static Disc temp;
	private static int NUMBER_OF_DISCS = 5;

	public static void main(String[] args) throws GeneralException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					initTowers();
				} catch (GeneralException e) {
					e.printStackTrace();
				}
                MainForm mf = new MainForm();
                mf.setTitle("Towers Of Hanoi!");
                mf.setLayout(new GridLayout());
                mf.setSize(600, 300);
                mf.setLocationRelativeTo(null);
                mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                mf.setVisible(true);
                mf.getContentPane().add(gp1);
                mf.getContentPane().add(gp2);
                mf.getContentPane().add(gp3);
            }
        });
	}

	public MainForm() {
        gp1 = new GamePanel(towers[0]);
        gp2 = new GamePanel(towers[1]);
        gp3 = new GamePanel(towers[2]);
        addKeyListener(new Controller());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}

	private static void initTowers() throws GeneralException {
		towers = new Tower[3];
		towers[0] = new StartTower(NUMBER_OF_DISCS);
		towers[1] = new MiddleTower();
		towers[2] = new EndTower();
	}
	
	public static void checkMove(int towNo) throws GeneralException {
		if (temp == null) {
			firstMove(towNo);
		} else if (towers[towNo].getSize() == 0 
				|| temp.size() <= towers[towNo].checkTop().size()){
			secondMove(towNo);
		} else {
			alert();
		}
	}
	
	private static void firstMove(int towNo) throws GeneralException {
		if (towers[towNo].getSize() > 0) {
			temp = towers[towNo].takeOffTop();
			rePaint();
		} else {alert();}
	}
	
	private static void secondMove(int towNo) throws GeneralException {
		towers[towNo].putOnTop(temp);
		temp = null;
		rePaint();
	}
	
	private static void alert() {
//		Color tc = new Color(0,0,0);
//		Color dc = new Color(255,0,0);
//		for (int i = 0; i < 4; i++) {
//			if (GamePanel.tc.equals(tc)) {
//				GamePanel.tc = dc;
//			} else {GamePanel.tc = tc;}
//			if (GamePanel.dc.equals(dc)) {
//				GamePanel.dc = tc;
//			} else {GamePanel.dc = dc;}
//			MainForm.gp1.repaint();
//			MainForm.gp2.repaint();
//			MainForm.gp3.repaint();
//		}
	}
	
	private static void rePaint() {
		gp1.repaint();
		gp2.repaint();
		gp3.repaint();	
	}

	public static void checkFinish() {
		
	}
}

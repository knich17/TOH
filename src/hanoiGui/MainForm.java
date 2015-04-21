package hanoiGui;

import hanoi.Disc;
import hanoi.EndTower;
import hanoi.GeneralException;
import hanoi.MiddleTower;
import hanoi.StartTower;
import hanoi.Tower;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MainForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainForm mf;
	private static Object[] choices = {"1", "2", "3", "4", "5"};
	private static StartTower t1;
	private static MiddleTower t2;
	private static EndTower t3;
	private static GamePanel gp1;
	private static GamePanel gp2;
	private static GamePanel gp3;
	static Disc temp;
	private static int discNumber = 0;
	static int moves = 0;
	static int bestMoves = 0;
	static boolean finished = false;
	private static Timer timer;
	public static ArrayList<String> moveList;

	public static void main(String[] args) throws GeneralException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					initTowers();
					mf = new MainForm();
				} catch (GeneralException e) {
					e.printStackTrace();
				}
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

	public MainForm() throws GeneralException {
		timer = new Timer(300, new timerActionListener());
        initGamePanels();
        addKeyListener(new Controller());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        getDiscNumber();
        reset();
	}
	
	private static void initGamePanels() {
		 gp1 = new GamePanel(t1);
	     gp2 = new GamePanel(t2);
	     gp3 = new GamePanel(t3);
	}

	private static void initTowers() throws GeneralException {
//		towers = new Tower[3];
//		towers[0] = new StartTower();
//		towers[1] = new MiddleTower();
//		towers[2] = new EndTower();
		t1 = new StartTower();
		t1.Stack(discNumber);
		t2 = new MiddleTower();
		t3 = new EndTower();
	}
	
	private static void getDiscNumber() {
		String s = (String)JOptionPane.showInputDialog(
                mf,
                "Enter the number of discs: ",
                "Difficulty",
                JOptionPane.PLAIN_MESSAGE,
                null, choices,
                "3");
		if (s != null) {
			discNumber = Integer.parseInt(s);			
		}
	}
	
	public static void checkMove(int towNo) throws GeneralException {
		Tower tower = getTower(towNo);
		if (temp == null) {
			firstMove(tower);
		} else if (tower.getSize() == 0 
				|| temp.size() <= tower.checkTop().size()){
			secondMove(tower);
		} else {
			alert();
		}
	}
	
	private static Tower getTower(int towNo) {
		switch (towNo) {
		case 1:
			return t1;
		case 2:
			return t2;
		case 3: 
			return t3;
		default:
			return null;
		}
	}
	
	public static void solve() throws GeneralException {
		reset();
		if (discNumber >= 3) {
			moveList = new ArrayList<String>();
			moveStack(t1, t3, t2, t1.getSize());
			reset();
		}
	}
	
	public static void moveStack(Tower t, Tower target, Tower ot, int noDiscs) throws GeneralException {
		if (noDiscs == 1) {
			moveList.add(t.getName());
			moveList.add(target.getName());
			moveTop(t, target);
			
		} else {
			moveStack(t, ot, target, noDiscs-1);
			moveStack(t, target, ot, 1);
			moveStack(ot, target, t, noDiscs-1);			
		}
	}
	
	public static void moveTop(Tower ta, Tower tb) throws GeneralException {
		firstMove(ta);
		secondMove(tb);
	}
	
	private static void firstMove(Tower tower) throws GeneralException {
		if (!tower.isEmpty()) {
			temp = tower.takeOffTop();
			rePaint();
		} else {alert();}
	}
	
	private static void secondMove(Tower tower) throws GeneralException {
		tower.putOnTop(temp);
		temp = null;
		moves++;
		rePaint();
	}
	
	private static void alert() {
		
	}
	
	public static void showHelp() {
		JOptionPane.showMessageDialog(mf, "The aim is to get all the discs from the starting tower to the end tower "
				+ "by only stacking smaller discs on larger discs.\n" 
				+ "Press R to reset, D to change difficulty and 1, 2, or 3 to pick up and place a disc from the respective tower."
				, "Instructions", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void rePaint() {
		gp1.repaint();
		gp2.repaint();
		gp3.repaint();	
	}

	public static void checkFinish() {
		if (t1.isEmpty() && t2.isEmpty() && temp == null) {
			finished = true;
			if (moves < bestMoves) {
				JOptionPane.showMessageDialog(mf, "Congratulations!\n" + "Your score of " + moves + " beat the old highscore of "
						+ bestMoves + "!", "New high score!", JOptionPane.INFORMATION_MESSAGE);
				bestMoves = moves;				
			} else if (bestMoves == 0) {
				JOptionPane.showMessageDialog(mf, "Congratulations!\n" + "New high score of: " + moves, "New high score!"
						, JOptionPane.INFORMATION_MESSAGE);
				bestMoves = moves;
			}
		}
	}
	
	public static void reset() throws GeneralException {
		t1.reset();
		t1.Stack(discNumber);
		t2.reset();
		t3.reset();
		temp = null;
		moves = 0;
		finished = false;
		rePaint();
	}

	public static void changeDifficulty() throws GeneralException {
		getDiscNumber();
		reset();
		moveList.clear();
		bestMoves = 0;
	}

	public static void startTimer() {
		timer.start();
	}

	public static void stopTimer() {
		timer.stop();
	}
}

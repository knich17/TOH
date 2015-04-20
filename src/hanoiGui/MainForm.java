package hanoiGui;

import hanoi.Disc;
import hanoi.GeneralException;
import hanoi.Tower;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainForm extends JFrame {
	public static Tower[] towers;
	public static GamePanel gp1;
	public static GamePanel gp2;
	public static GamePanel gp3;
	public static Disc temp;

	public static void main(String[] args) throws GeneralException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					initTowers();
					towers[0].initDiscs(5);
				} catch (GeneralException e) {
					// TODO Auto-generated catch block
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
        this.gp1 = new GamePanel(towers[0]);
        this.gp2 = new GamePanel(towers[1]);
        this.gp3 = new GamePanel(towers[2]);
        addKeyListener(new Controller());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}

	private static void initTowers() throws GeneralException {
		towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower();
		}
	}
}

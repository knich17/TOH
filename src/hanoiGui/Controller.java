package hanoiGui;

import hanoi.GeneralException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e){
		int towNo = -1;
		if ((e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1) && !MainForm.finished) {
			towNo = 1;
		} else if ((e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2) && !MainForm.finished) {
			towNo = 2;
		} else if ((e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3) && !MainForm.finished) {
			towNo = 3;
		} else if (e.getKeyCode() == KeyEvent.VK_F1) {
			MainForm.showHelp();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			try {
				MainForm.solve();
				MainForm.startTimer();
			} catch (GeneralException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			try {
				MainForm.changeDifficulty();
			} catch (GeneralException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			try {
				MainForm.reset();
			} catch (GeneralException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (towNo >= 1 && towNo <= 3) {
			try {
				MainForm.checkMove(towNo);
				MainForm.checkFinish();
			} catch (GeneralException e1) {
				e1.printStackTrace();
			}		
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	}

	@Override
	public void keyReleased(KeyEvent e) {	}
}

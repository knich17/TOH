package hanoiGui;

import hanoi.GeneralException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e){
		int towNo = -1;
		if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			towNo = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			towNo = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			towNo = 2;
		}
		
		if (towNo >= 0 && towNo <= 2) {
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

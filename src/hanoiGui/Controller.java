package hanoiGui;

import hanoi.GeneralException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

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
		
		try {
			if (towNo >= 0 && towNo <= 2) {
				if (MainForm.temp == null) {
					if (MainForm.towers[towNo].getSize() > 0) {
						MainForm.temp = MainForm.towers[towNo].takeOffTop();
					} else {alert();}
				} else if (MainForm.towers[towNo].getSize() == 0 
						|| MainForm.temp.size() <= MainForm.towers[towNo].checkTop().size()){
					MainForm.towers[towNo].putOnTop(MainForm.temp);
					MainForm.temp = null;
					//if towers.checktop.size=1 
					//finish
				} else {
					alert();
				}
			}
		} catch (GeneralException e1) {
			e1.printStackTrace();
		}
		
		MainForm.gp1.repaint();
		MainForm.gp2.repaint();
		MainForm.gp3.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	private void alert() {
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
}

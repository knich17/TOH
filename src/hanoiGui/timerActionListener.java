package hanoiGui;

import hanoi.GeneralException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timerActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainForm.moveList.size() > 0) {
			String name = MainForm.moveList.get(0);
			MainForm.moveList.remove(0);
			try {
				if (name == "Start") {
						MainForm.checkMove(1);
				} else if (name == "Middle") {
					MainForm.checkMove(2);
				} else {
					MainForm.checkMove(3);
				}
			} catch (GeneralException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MainForm.rePaint();
		} else {
			MainForm.stopTimer();
			MainForm.finished = true;
		}
	}

}

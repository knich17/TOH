package hanoiGui;

import hanoi.Disc;
import hanoi.Tower;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Stack;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tower tower;
	public static Color tc = new Color(0, 0, 0);
	public static Color dc = new Color(255, 0, 0);

	public GamePanel(Tower tow) {
		tower = tow;
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(tc);

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		// draw tower
		g2d.fillRect(80, 80, 20, 150);
		g2d.fillRect(20, 210, 140, 20);

		//draw key text
		if (tower.getName() == "Start") {
			g2d.drawString("Press 1!", 70, 250);			
		} else if (tower.getName() == "Middle") {			
			g2d.drawString("Press 2!", 70, 250);			
		} else {
			g2d.drawString("Press 3!", 70, 250);						
		}
		
		if (tower.getName() == "Start") {
			g2d.drawString("Moves: " + MainForm.moves, 20, 20);
			g2d.drawString("Press R to reset", 20, 40);
			g2d.drawString("Press F1 for help", 20, 60);
		} else if (tower.getName() == "Middle") {
			if (MainForm.temp != null) {
				g2d.setColor(MainForm.temp.getColour());
				g2d.fillRect(80 - (MainForm.temp.size() * 10), 20, MainForm.temp.size() * 20 + 20, 20);
				g2d.setPaint(dc);
			}	else if (MainForm.finished) {
				g2d.setPaint(new Color(255, 0, 0));
			    Font font = new Font("Serif", Font.PLAIN, 40);
			    g2d.setFont(font);
				g2d.drawString("Yay! :D", 20, 50);
				g2d.setPaint(dc);
			}
		}  else if (tower.getName() == "End") {
			g2d.drawString("Top Score: " + MainForm.bestMoves, 100, 40);
		}

		//draw discs
		Stack<Disc> dStack = tower.getDiscs();
		int dcount = 1;
		int x, y, w, h;
		for (Disc d : dStack) {
			x = 80 - (d.size() * 10);
			y = 210 - (dcount * 20);
			w = d.size() * 20 + 20;
			h = 20;

			//draw disc
			g2d.setPaint(d.getColour());
			g2d.fillRect(x, y, w, h);

			//draw disc outline (in white)
			g2d.setPaint(new Color(225, 225, 225));
			g2d.drawRect(x, y, w - 1, h - 1);

			dcount++;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}

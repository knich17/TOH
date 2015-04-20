package hanoi;

import java.awt.Color;

public class Disc {
	private int size;
	private Color colour;

	public Disc(int size) throws GeneralException {
		if (size <= 0) {
			throw new GeneralException("Size must be greater than 0!");
		}
		this.size = size;
		if (this.size % 2 == 0) {
			colour = new Color(255, 0, 0);
		} else {
			colour = new Color(155, 0, 0);
		}
	}

	public int size() {
		return this.size;
	}
	
	public Color getColour() {
		return this.colour;
	}

}

package hanoi;

public class Disc {
	private int size;

	public Disc(int size) throws GeneralException {
		if (size <= 0) {
			throw new GeneralException("Size must be greater than 0!");
		}
		this.size = size;
	}

	public int size() {
		return this.size;
	}

}

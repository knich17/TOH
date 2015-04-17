package hanoi;

import java.util.Stack;

public class Tower {
	private Stack<Disc> dStack;

	public Tower(int n) throws GeneralException {
		if (n < 0) {
			throw new GeneralException(
					"Initial disks on dStack can not be negitive");
		}
		this.dStack = new Stack<Disc>();
		for (int i = n; i > 0; i--) {
			this.dStack.push(new Disc(i));
		}
	}

	public Disc takeOffTop() throws GeneralException {
		if (this.dStack.empty()) {
			throw new GeneralException("Can not get the top of an empty Tower");
		}
		return this.dStack.pop();
	}

	public void putOnTop(Disc d) throws GeneralException {
		if (d == null) {
			throw new GeneralException("Can not add null disk to top");
		}
		if (this.dStack.empty() || d.size() < this.dStack.peek().size()) {
			this.dStack.push(d);
		} else {
			throw new GeneralException(
					"Can't add the same or larger disk to top");
		}
	}

	public Stack<Disc> getDiscs() {
		return dStack;
	}
}

package hanoi;

import java.util.Stack;

public abstract class Tower {
	protected Stack<Disc> dStack;

	public Tower() {
		this.dStack = new Stack<Disc>();
	}

	public void reset() throws GeneralException {
		this.dStack.removeAllElements();
	}

	public Disc takeOffTop() throws GeneralException {
		if (this.dStack.empty()) {
			throw new GeneralException("Can not get the top of an empty Tower");
		}
		return this.dStack.pop();
	}
	
	public Disc checkTop() throws GeneralException {
		if (this.dStack.empty()) {
			throw new GeneralException("Can not check the top of an empty Tower");
		}
		return this.dStack.peek();
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

	public int getSize() {
		return dStack.size();
	}
	
	public abstract String getName();
}

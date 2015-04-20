package hanoi;

import java.util.Stack;

public class StartTower extends Tower{

	public StartTower(int n) throws GeneralException {
		dStack = new Stack<Disc>();
		if (n < 0) {
			throw new GeneralException("Initial disks on dStack can not be negitive");
		}
		for (int i = n; i > 0; i--) {
			this.dStack.push(new Disc(i));
		}
	}
	
	public String getName() {
		return "Start";
	}

}

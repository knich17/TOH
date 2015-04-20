package hanoi;

public class StartTower extends Tower{
	
	public String getName() {
		return "Start";
	}
	
	public void Stack(int n) throws GeneralException {
		if (n < 0 || !dStack.isEmpty()) {
			throw new GeneralException("When restacking, n must be positive, dstack must be empty");
		}
		for (int i = n; i > 0; i--) {
			this.dStack.push(new Disc(i));
		}
	}
}

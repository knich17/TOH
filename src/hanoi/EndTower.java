package hanoi;

public class EndTower extends Tower{

	public EndTower() {
		super();
	}
	
	public boolean isFin() {
		return false;
	}
	
	public String getName() {
		return "End";
	}

}

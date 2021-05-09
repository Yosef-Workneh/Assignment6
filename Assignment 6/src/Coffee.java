
public class Coffee extends Beverage {

	private boolean extraShot;
	private boolean extraSyrup;
	private final double shotCost = 0.5;
	private final double syrupCost = 0.5;

	public Coffee(String name, SIZE size, boolean extraShot,boolean extraSyrup) {

		super(name, TYPE.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public String toString() {
		String s = getBevName() + ", " + getSize();

		if (extraSyrup) {
			s += " Extra syrup";
		}
		s += ", $" +calcPrice();	

		return s;	  
	}

	@Override 
	public double calcPrice() {

		double totalP = super.getBasePrice();


		if (super.getSize() == SIZE.MEDIUM) {
			totalP += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			totalP += 2 * super.getSizePrice();
		}

		if (extraShot) {
			totalP += shotCost;
		}
		if (extraSyrup) {
			totalP += syrupCost;
		}
		return totalP;
	}
	public boolean equals(Coffee cofee) {

		if (super.equals(cofee) && extraShot==cofee.getExtraShot() && extraSyrup==cofee.getExtraSyrup()) {

			return true;
		}
		else {
			return false;
		}
	}
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	public boolean getExtraShot() {
		return extraShot;
	}
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public double getShotCost() {
		return shotCost;
	}
	public double getSyrupCost() {
		return syrupCost;
	}	
}
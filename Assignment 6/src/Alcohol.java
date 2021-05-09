
public class Alcohol extends Beverage {

	private boolean weekend;
	private final double weekendFee = 0.6;

	public Alcohol(String name, SIZE size, boolean weekend) {

		super(name,TYPE.ALCOHOL,size);
		this.weekend = weekend;
	}

	public String toString() {

		String s1 = getBevName() +", " + getSize();

		if (weekend) {
			s1 += " Weekend ";

		}
		s1 += ", $" +calcPrice();
		return s1;
	}

	public boolean equals (Alcohol alcohol) {
		if (super.equals(alcohol) && weekend == alcohol.getweekend()) {

			return true;
		}

		else {

			return false;
		}	
	}

	@Override
	public double calcPrice() {

		double TotalPr = super.getBasePrice();

		if (super.getSize() == SIZE.MEDIUM) {
			TotalPr += super.getSizePrice();

		}
		else if (super.getSize() == SIZE.LARGE) {
			TotalPr += 2 * super.getSizePrice();
		}

		if (weekend) {
			TotalPr += weekendFee;
		}
		return TotalPr;
	}
	public boolean getweekend() {
		return weekend;
	}
	public double getWeekendFee() {
		return weekendFee;
	}
	public void setIsWeekend(boolean weekend ) {
		this.weekend = weekend;
	}	

}
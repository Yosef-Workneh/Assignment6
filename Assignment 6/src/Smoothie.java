
public class Smoothie extends Beverage{

	private int numberFruits;
	private boolean AddProtien;
	private final double fruitCost= 0.5;
	private final double proteinCost = 1.5;

	public Smoothie(String name, SIZE size,int NumberFruit,boolean AddProtien) {

		super(name,TYPE.SMOOTHIE,size);
		this.numberFruits = NumberFruit;
		this.AddProtien = AddProtien;
	}

	public String toString() {

		String s1 = getBevName() + ", " + getSize() +" " + numberFruits + " Fruits";

		if (AddProtien) {
			s1 += " Protein powder";
		}
		s1 += ", $" + calcPrice();

		return s1;
	}


	public boolean equals(Smoothie smoothie) {
		if (super.equals(smoothie) && numberFruits == smoothie.getNumOfFruits() && AddProtien == smoothie.getAddProtien()) {

			return true;
		}
		else {

			return false;
		}
	}
	@Override
	public double calcPrice() {
		double Totalpr = super.getBasePrice();

		if (super.getSize() == SIZE.MEDIUM) {

			Totalpr += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			Totalpr += 2 * super.getSizePrice();
		}

		Totalpr += numberFruits * fruitCost;
		if (AddProtien) {
			Totalpr += proteinCost;
		}

		return Totalpr;
	}
	public void setNumOfFruits(int numberFruit) {
		this.numberFruits = numberFruit;
	}
	public int getNumOfFruits() {
		return numberFruits;
	}
	public void setAddProtienr(boolean AddProtien) {
		this.AddProtien = AddProtien;
	}
	public boolean getAddProtien() {
		return AddProtien;
	}
	public double getFruitCost() {
		return fruitCost;
	}
	public double getProteinCost() {
		return proteinCost;
	}
}



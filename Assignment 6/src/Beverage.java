
public abstract class Beverage {

	private String name;
	private TYPE type;
	private	SIZE size;
	private final double basePrice = 2.0;
	private	final double sizePrice = 1.0;

	public Beverage (String name, TYPE type, SIZE size) {

		this.name = name;
		this.type = type;
		this.size = size;
	}

	public abstract double calcPrice();

	public String toString() {

		return "Name: "+ name +", Size: "+ size +", Type: "+ type;
	}

	public boolean equals(Beverage beverage) {

		if (name.equals(beverage.getBevName()) && type==beverage.getType() && size==beverage.getSize()) {

			return true;
		}

		else {
			return false;

		}
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getBevName() {
		return name;
	}

	public void setType(TYPE type) {
		this.type = type;
	}
	public TYPE getType() {
		return type;
	}
	public void setSize(SIZE size) {
		this.size = size;

	}
	public SIZE getSize() {
		return size;
	}
	public  double getSizePrice() {
		return sizePrice;
	}
	public  double getBasePrice() {
		return basePrice;

	}	

}

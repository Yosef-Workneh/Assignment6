import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface{


	private int OrderNo;
	private int orderTime;
	private DAY orderDay;
	private ArrayList<Beverage> beverages;
	private Customer customer;


	public Order (int orderTime, DAY orderDay, Customer customer) {
		OrderNo = genOrderNum();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		beverages = new ArrayList<>();

	}

	public int genOrderNum() {
		Random rand = new Random();

		int rand1 = rand.nextInt(90_000 - 10_000)+ 10_000;
		return rand1;

	}
	public String toString() {
		String s1 = "__________________________________" + orderDay.toString() +", " +orderTime
				+"\n" + customer.toString() + " Order Num: " + OrderNo;

		for (Beverage b : beverages) {

			s1 += "\n" + b.toString();
		}

		s1 += "\n Order Total: " + calcOrderTotal();

		return s1;

	}
	public boolean isWeekend() {

		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {

			return true;
		}

		return false;
	}
	public Beverage getBeverage(int itemNum) {

		return beverages.get(itemNum);
	}
	public int compareTo(Order order) {

		if (OrderNo == order.getOrderNo()) {

			return 0;
		}
		else if (OrderNo > order.getOrderNo()) {

			return 1;
		}
		else {

			return -1;
		}
	}
	
	public double calcOrderTotal() {

		double orderT = 0;

		for (Beverage b : beverages) {

			orderT += b.calcPrice();
		}

		return orderT;

	}

	public int findNumOfBeveType(TYPE type) {

		int count = 0;

		for (Beverage b : beverages) {

			if (b.getType() == type) {

				count++;
			}

		}

		return count;
	}

	public int getTotalItems() {

		return beverages.size();
	}

	public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {

		Coffee c1 = new Coffee(name, size, extraShot, extraSyrup);
		beverages.add(c1);
	}

	public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {
		Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
		beverages.add(s);
	}
	public void addNewBeverage(String name, SIZE size) {

		boolean weekend = false;
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {

			weekend = true;
		}

		Alcohol a1 = new Alcohol(name, size, weekend);

		beverages.add(a1);

	}
	public void setOrderNo(int OrderNo) {
		this.OrderNo = OrderNo;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public DAY getOrderDay() {
		return orderDay;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return new Customer(customer);
	}
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

}



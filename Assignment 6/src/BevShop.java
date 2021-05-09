import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	private int numOfAlcoholOrders;
	private int currentOrderIndex;
	private ArrayList<Order> orders;

	public BevShop() {

		orders = new ArrayList<>();

	}
	public String toString() {

		String s1 = "Monthly Orders\n";

		for (Order o1 : orders) {

			s1 += o1.toString();
		}
		s1 += "Total Sale: " +totalMonthlySale();

		return s1;
	}
	public boolean validTime(int time) {

		if (time >= MIN_TIME && time <= MAX_TIME) {

			return true;
		}

		return false;
	}
	public boolean validAge(int age) {

		if (age > MIN_AGE_FOR_ALCOHOL) {

			return true;
		}

		return false;
	}
	public boolean eligibleForMore() {
		if (numOfAlcoholOrders < 3) {
			return true;

		}
		return false;
	}
	public boolean isMaxFruit(int number) {

		if (number > MAX_FRUIT) {

			return true;
		}

		return false;
	}
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIndex = orders.indexOf(order);
		numOfAlcoholOrders = 0;
	}
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size);
		numOfAlcoholOrders++;
	}

	public int findOrder(int orderNumber) {

		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNumber) {

				return i;
			}
		}
		return -1;
	}
	@Override
	public double totalOrderPrice(int OrderNo) {
		double OrderSale = 0;

		for (Order o : orders) {
			if (o.getOrderNo() == OrderNo) {

				for (Beverage b : o.getBeverages()) {
					OrderSale += b.calcPrice();
				}
			}
		}
		return OrderSale;
	}
	@Override
	public double totalMonthlySale() {

		double totalSale = 0;
		for (Order o : orders) {

			for (Beverage b1 : o.getBeverages()) {
				totalSale += b1.calcPrice();
			}
		}
		return totalSale;
	}
	public int totalNumOfMonthlyOrders() {

		return orders.size();
	}
	public void sortOrders() {

		for (int x = 0; x < orders.size()-1; x++) {

			int MinIdx = x;

			for (int i = x+1; i< orders.size(); i++) {

				if (orders.get(i).getOrderNo() < orders.get(MinIdx).getOrderNo()) {

					MinIdx= i;
				}
			}

			Order temp = orders.get(MinIdx);

			orders.set(MinIdx, orders.get(x));
			orders.set(x, temp);
		}
	}
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	public Order getCurrentOrder() {
		return orders.get(currentOrderIndex);
	}
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholOrders;
	}
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
}
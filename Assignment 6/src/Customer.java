
public class Customer {

	private String name;
	private int age;


	public Customer(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public Customer(Customer customer) {
		name = customer.getName();
		age = customer.getAge();

	}
	public String toString() {
		return name +", " + age +"y/o";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}


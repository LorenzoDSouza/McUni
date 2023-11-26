package KDB;

public class Item {

	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;

	}

	public double price() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + ": $ " + price;
	}
}

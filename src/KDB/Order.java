package KDB;

import java.util.*;

public class Order {

	private int order_id;
	private ArrayList<Item> items;
	private String observation;

	public Order(int order_id, String observation) {

		ArrayList<Item> i = new ArrayList<Item>();
		items = i;

		this.order_id = order_id;
		this.observation = observation;

	}

	public Order(int order_id) {

		ArrayList<Item> i = new ArrayList<Item>();
		items = i;

		this.order_id = order_id;
	}

	@SuppressWarnings("finally")
	public boolean addItem(Item item) { //method to add item to the order
		boolean xadd = false;
		try {
			if (items.add(item)) {
				xadd = true;
				System.out.println(item.getName() + " added to the order successfully!");
				System.out.println();
			} else {
				throw new AppExceptions("Couldnt add the item to the order!");
			}
		} catch (AppExceptions e) {
			System.err.println("Error: " + e.getMessage());
			xadd = false;
		} finally {
			return xadd;
		}
	}

	public double totalPriceM() {//method to return the total price of a order
		double ttp = 0;

		for (Item item : items) {
			ttp += item.price();
		}
		return ttp;
	}

	public void printOrder() {
		System.out.println("-----------------------" + "\n" + "\nOrder ID: " + order_id + "\n");
		for (Item item : items) {
			System.out.println(item.toString());
		}
		System.out.println();
		System.out.printf("Total price: $ %.2f", totalPriceM());
		System.out.println();
		System.out.println();

	}

	public ArrayList<Item> getItems() {//method to return the list of items in the order
		return items;
	}
}

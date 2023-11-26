package KDB;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		menu();
	}

	private static Scanner sca = new Scanner(System.in);

	private static Item CheeseBurguer = new Item("Cheese Burguer", 19.50);
	private static Item Burguer = new Item("Hamburguer", 15.50);
	private static Item FrenchFries = new Item("French Fries", 8.90);
	private static Item MilkShake = new Item("Milk Shake", 12.50);
	private static Item Nuggets = new Item("Nuggets", 9.90);

	private static McSystem mcSystem = new McSystem();

	private static Order o1 = new Order(1, null);
	private static Order o2 = new Order(2, null);

	// initiated all the objects as atributes from the main class

	private static void menu() {// made the menu at the main class

		
		int dw1 = 0;
		int index = 1;

		System.out.println("--------Welcome to McUni System!--------");

		do {
			try {
				System.out.println("Select one option above:" + "\n" + "\n 1 - Add a new order to the queue"
						+ "\n 2 - Deliver the last order" + "\n 3 - Show all orders" + "\n 4 - Quit menu"); // options

				System.out.printf("Option: ");
				int m = sca.nextInt();// valuation if the value is a integer
				System.out.println();
				if (m == 4) {
					break;
				} else if (m != 1 && m != 2 && m != 3) {// validation of the int values
					throw new Exception();
				} else {
					switch (m) {//the options are the methods wrote above
					case 1:
						addOrderSys(index);
						index++;
						break;
					case 2:
						deliverOrderSys();
						break;
					case 3:
						showAllOrdersSys();
						break;
					}
				}


			} catch (Exception e) {
				System.out.println("Enter a valid option!");
				System.out.println();
			}
		} while (dw1 == 0);

	}

	// above are the menu options
	private static void addOrderSys(int index) { //menus option to add order in the queue
		int dw2 = 0; // variable to continue to add items
		int dw3 = 0; // variable to keep the user in the items menu, even if an exception is apointed
		Order orderx = new Order(index); // default order to increment the arraylist
		System.out.println(
				"Choose each item do you want to add to the order (add 1 by 1, even it's the same type of item): ");
		do {// dw3
			try {
				do {// dw2
					System.out.println("1 - Cheese Burguer" + "\n2 Hamburguer" + "\n3 French Fries" + "\n4 Milk Shake"
							+ "\n5 Nuggets");// switch case options
					System.out.printf("Option:");
					int mOrder = sca.nextInt();
					System.out.println();

					switch (mOrder) {
					case 1:
						orderx.addItem(CheeseBurguer);
						break;
					case 2:
						orderx.addItem(Burguer);
						break;
					case 3:
						orderx.addItem(FrenchFries);
						break;
					case 4:
						orderx.addItem(MilkShake);
						break;
					case 5:
						orderx.addItem(Nuggets);
						break;
					default:
						System.out.println("There isn't any option by this number");
						break;

					}

					System.out.println("Would you like to add another item to the order?" + "\npress 0(zero) to YES"
							+ "\nor" + "\npress any other integer to return to menu!");
					
					dw2 = sca.nextInt();
				} while (dw2 == 0);
				
				System.out.println("Would you like to add an observation to the order? "
						+ "\n1 - yes"
						+ "\nany other number - no");
				try {
				dw3 = sca.nextInt();
				} catch (Exception e){
					
				}
				
				dw3 = 1;// here i have to create the option to add observation, using the method
						// setObservation

			} catch (Exception e) {
				System.out.println("The input is invalid!");
				System.out.println();
			}
		} while (dw3 == 0);

		if (orderx.getItems().isEmpty()) {
		} else {
			mcSystem.addOrder(orderx);
		}
	}

	private static void deliverOrderSys() {//option to deliver the first order in the queue
		mcSystem.deliverOrder();
	}

	private static void showAllOrdersSys() {//show all the orders in the queue, with the price and items
		for (Order order : mcSystem.getQueue()) {
			order.printOrder();
		}
	}
}

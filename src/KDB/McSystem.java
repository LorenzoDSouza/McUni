package KDB;

import java.util.*;

public class McSystem {

	private Queue<Order> queue;

	public McSystem() {
		Queue<Order> ord = new LinkedList<Order>();
		queue = ord;

	}

	public Queue<Order> getQueue() {
		return queue;
	}

	@SuppressWarnings("finally")
	public boolean addOrder(Order order) { // method to add order to the queue
		boolean xadd = false;
		try {
			if (queue.add(order)) {
				xadd = true;
				System.out.println("Order added successfully!");
			} else {
				throw new AppExceptions("Couldnt add the order to the queue!");
			}
		} catch (AppExceptions e) {
			System.err.println("Error: " + e.getMessage());
			xadd = false;
		} finally {
			return xadd;
		}
	}

	@SuppressWarnings("finally")
	public boolean deliverOrder() {// method do deliver the head order
		boolean xadd = false;
		try {
			queue.remove();

		} catch (Exception e) {
			System.err.println("Error: Couldn't done the last order!");
			xadd = false;
		} finally {
			return xadd;
		}
	}

}

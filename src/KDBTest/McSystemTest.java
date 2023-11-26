package KDBTest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import KDB.*;

public class McSystemTest {

	private Item CheeseBurguer, FrenchFries, MilkShake;
	private McSystem mcSystem;
	private Order ot1, ot2, ot3;

	@BeforeEach
	void setUp() {
		CheeseBurguer = new Item("Cheese Burguer", 19.50);
		FrenchFries = new Item("French Fries", 8.90);
		MilkShake = new Item("Milk Shake", 12.50);

		mcSystem = new McSystem();

		ot1 = new Order(1);
		ot2 = new Order(2);
		ot3 = new Order(3);

		ot1.addItem(CheeseBurguer);
		ot1.addItem(FrenchFries);
		ot1.addItem(MilkShake);

	}

	@Test
	void testNoItemsIntoOrder() {
		int size = ot3.getItems().size();
		
		assertEquals(0, size);
	}

	@Test
	void testAddOneItemToOrder() {
		ot3.addItem(CheeseBurguer);
		int size = ot3.getItems().size();
		
		assertEquals(1, size);
	}

	@Test
	void testAddLotsOffItemsToOrder() {
		ot3.addItem(CheeseBurguer);
		ot3.addItem(FrenchFries);
		ot3.addItem(MilkShake);
		
		int size = ot3.getItems().size();
		
		assertEquals(3, size);
	}
	
	@Test
	void testDeliverItemFromTheOrder() {
		mcSystem.addOrder(ot1);
		
		mcSystem.deliverOrder();
		int size = mcSystem.getQueue().size();
		
		assertEquals(0, size);
	}
	
	@Test
	void testAddOrderToSystem() {
		mcSystem.addOrder(ot1);
		
		assertEquals(ot1, mcSystem.getQueue().peek());
	}
	
	@Test
	void testOrdersTotalPrice() {
		
		assertEquals(40.90, ot1.totalPriceM());
	}
}

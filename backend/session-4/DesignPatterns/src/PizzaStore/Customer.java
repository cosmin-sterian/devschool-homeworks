package PizzaStore;

import PizzaStore.Employee.Employable;
import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Payment.Payable;

import java.util.LinkedList;
import java.util.List;

import static PizzaStore.Menu.Pizza.PizzaRecipe.MAX_EXTRAS;

public class Customer {

	private PizzaStore store;
	private String name;
	private Menu.PizzaType desiredPizzaType;
	private Employable assignedCustomerService;
	private List<Ingredient> extras;
	private Payable paymentStrategy;

	public Customer(PizzaStore store, String name, Payable paymentStrategy) {
		this.store = store;
		this.name = name;
		extras = new LinkedList<>();
		this.paymentStrategy = paymentStrategy;
		System.out.println("Welcome to our Pizza Store, " + name +
				"! You have a 20% discount on Credit/Debit Card payments!");
	}

	public void choosePizza(Menu.PizzaType desiredPizzaType) {
		assignedCustomerService = store.assignCustomerToCustomerService(this);
		if (assignedCustomerService == null) {
			System.out.println("There are no Customer Service Employees available at the moment...");
			return;
		}
		this.desiredPizzaType = desiredPizzaType;
	}

	public void addExtra(Ingredient extra) {
		if (checkFullExtras()) {
			System.out.println("Sorry, no more extras on this pizza!");
			return;
		}
		extras.add(extra);
	}

	public void removeExtra(Ingredient extra) {
		extras.remove(extra);
	}

	public void placeOrder() {
		if (assignedCustomerService == null) {
			System.out.println("You need an assigned waiter first!");
			return;
		}
		assignedCustomerService.takeRequest(desiredPizzaType, extras);
	}

	public boolean pay(float sum) {
		boolean result = paymentStrategy.pay(sum);
		if (result) {
			assignedCustomerService = null;
		}
		return result;
	}

	public void changePaymentMethod(Payable paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	private boolean checkFullExtras() {
		return extras.size() == MAX_EXTRAS;
	}

	public String getName() {
		return name;
	}

}

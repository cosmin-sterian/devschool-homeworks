package PizzaStore;

import PizzaStore.Employee.Baker;
import PizzaStore.Employee.CustomerService;

import java.util.List;

public class PizzaStore {
	private static volatile PizzaStore instance; // Singleton
	private static final Object mutex = new Object();

	private List<CustomerService> customerServiceEmployeeObservers; // Observer pattern
	private Baker//TODO

	private PizzaStore() {}

	public static PizzaStore getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null) {
					instance = new PizzaStore();
				}
			}
		}
		return instance;
	}
}

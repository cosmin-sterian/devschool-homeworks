package PizzaStore;

import PizzaStore.Employee.Baker;
import PizzaStore.Employee.CustomerService;
import PizzaStore.Employee.Employable;

import java.util.LinkedList;
import java.util.List;

public class PizzaStore {
	private static volatile PizzaStore instance; // Singleton
	private static final Object mutex = new Object();

	private List<Employable> customerServiceEmployeeObservers; // Observer pattern
	private List<Employable> bakers;

	private PizzaStore() {
		customerServiceEmployeeObservers = new LinkedList<>();
		bakers = new LinkedList<>();
	}

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

	private void addEmployee(Employable.EmployeeType employeeType) {

	}
}

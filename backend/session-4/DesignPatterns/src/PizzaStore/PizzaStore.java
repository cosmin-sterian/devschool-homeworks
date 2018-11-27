package PizzaStore;

import PizzaStore.Employee.Baker;
import PizzaStore.Employee.CustomerService;
import PizzaStore.Employee.Employable;
import PizzaStore.Menu.Pizza.PizzaTemplate;

import java.util.LinkedList;
import java.util.List;

public class PizzaStore {
	private static volatile PizzaStore instance; // Singleton
	private static final Object mutex = new Object();
	private static int employees_count;

	private List<Employable> customerServiceEmployees; // Observer pattern
	private List<Employable> bakers; // Observer pattern
	private List<PizzaTemplate> pizzaRequests;
	private List<PizzaTemplate> readyPizzas;

	private PizzaStore() {
		customerServiceEmployees = new LinkedList<>();
		bakers = new LinkedList<>();
		employees_count = 0;
		pizzaRequests = new LinkedList<>();
		readyPizzas = new LinkedList<>();
	}

	public void addPizzaTemplate(PizzaTemplate pizzaTemplate) {
		switch (pizzaTemplate.getTemplateType()) {
			case PIZZA:
				readyPizzas.add(pizzaTemplate);
				notifyCustomerService();
				break;
			case REQUEST:
				pizzaRequests.add(pizzaTemplate);
				notifyBakers();
				break;
		}
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

	public Employable addEmployee(Employable.EmployeeType employeeType) {
		Employable employable;
		switch (employeeType) {
			case BAKER:
				employable = new Baker(employees_count);
				bakers.add(employable);
				break;
			case CUSTOMER_SERVICE:
				employable = new CustomerService(employees_count);
				customerServiceEmployees.add(employable);
				break;
			default:
				employable = null;
				employees_count--;
		}
		employees_count++;
		return employable;
	}

	public void notifyCustomerService() {
		customerServiceEmployees.forEach(Employable::update); // Observers stuff
	}

	public void notifyBakers() {
		bakers.forEach(Employable::update); // Observers stuff
	}

	public List<PizzaTemplate> getPizzaRequests() {
		return pizzaRequests;
	}

	public List<PizzaTemplate> getReadyPizzas() {
		return readyPizzas;
	}

	public int getBakersCount() {
		return bakers.size();
	}
}

package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.PizzaTemplate;
import PizzaStore.PizzaStore;

import java.util.List;
import java.util.Optional;

public class CustomerService implements Employable {

	private PizzaStore pizzaStore; // Observer pattern, subject
	private int employeeId;
	private EmployeeType employeeType;
	private boolean requestedPizza;
	private Menu.PizzaType requestedPizzaType;

	public CustomerService(int employeeId) {
		this.employeeId = employeeId;
		employeeType = EmployeeType.CUSTOMER_SERVICE;
		pizzaStore = PizzaStore.getInstance();
		requestedPizza = false;
	}

	@Override
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int getEmployeeId() {
		return employeeId;
	}

	@Override
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void update() {
		if (!requestedPizza)
			return;
		List<PizzaTemplate> readyPizzas = pizzaStore.getReadyPizzas();
		Optional<PizzaTemplate> myPizzaOptional = readyPizzas.stream()
				.filter(pizza -> pizza.getPizzaType() == requestedPizzaType)
				.findFirst();
		if (!myPizzaOptional.isPresent())
			return; // Someone else had a similar pizza and took it
		PizzaTemplate myPizza = myPizzaOptional.get();
		System.out.println("Your " + myPizza.getPizzaType() + " is ready!"); // Replace with MVC (Pizza/Menu View)
	}

}

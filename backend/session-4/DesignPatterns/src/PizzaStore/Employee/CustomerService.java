package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.PizzaRecipe;
import PizzaStore.Menu.Pizza.PizzaRequest;
import PizzaStore.Menu.Pizza.PizzaTemplate;
import PizzaStore.*;

import java.util.List;
import java.util.Optional;

public class CustomerService implements Employable {

	private PizzaStore pizzaStore; // Observer pattern, subject
	private int employeeId;
	private EmployeeType employeeType;
	private boolean requestedPizza;
	private Menu.PizzaType requestedPizzaType;
	private Customer assignedCustomer;
	private boolean available;

	public CustomerService(int employeeId) {
		this.employeeId = employeeId;
		employeeType = EmployeeType.CUSTOMER_SERVICE;
		pizzaStore = PizzaStore.getInstance();
		requestedPizza = false;
		available = true;
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
		System.out.println("[CS#" + employeeId + "]: Your " + myPizza.getPizzaType() +
				" is ready, " + assignedCustomer.getName() + "!"); // Replace with MVC (Pizza/Menu View)
		System.out.println("[CS#" + employeeId + "]: It costs " + myPizza.getPrice());
		assignedCustomer.pay(myPizza.getPrice());
		setAssignedCustomer(null);
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public Customer getAssignedCustomer() {
		return assignedCustomer;
	}

	@Override
	public void setAssignedCustomer(Customer assignedCustomer) {
		if (assignedCustomer == null) {
			available = true;
			return;
		}
		this.assignedCustomer = assignedCustomer;
		available = false;
	}

	@Override
	public void takeRequest(Menu.PizzaType pizzaType, List<Ingredient> extras) {
		System.out.println("[CS#" + employeeId + "]: We have taken your order for " + pizzaType +
				(extras.size() > 0 ? (" with extras: " + extras.toString()) : ""));

		requestedPizza = true;
		requestedPizzaType = pizzaType;
		PizzaRecipe pizzaRequestRecipe = new PizzaRecipe(pizzaType);
		extras.forEach(pizzaRequestRecipe::addExtra);
		PizzaRequest pizzaRequest = pizzaRequestRecipe.buildPizzaRequest();
		pizzaStore.addPizzaTemplate(pizzaRequest);
	}
}

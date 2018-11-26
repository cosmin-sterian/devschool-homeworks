package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.Pizza;
import PizzaStore.PizzaStore;

import java.util.List;

public class CustomerService implements Employable {

	private PizzaStore subject; // Observer pattern
	private int employeeId;
	private EmployeeType employeeType;

	public CustomerService(int employeeId) {
		this.employeeId = employeeId;
		employeeType = EmployeeType.CUSTOMER_SERVICE;
		subject = PizzaStore.getInstance();
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

	@Override
	public Pizza handleRequest(Menu.PizzaType pizzaType, List<Ingredient> extras) {
		return null; // TODO
	}

	public void update() {
		// TODO
	}
}

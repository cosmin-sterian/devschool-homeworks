package PizzaStore.Employee;

import PizzaStore.Customer;
import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.PizzaTemplate;

import java.util.List;

public interface Employable {
	// Observer pattern

	enum EmployeeType { CUSTOMER_SERVICE, BAKER }

	public void setEmployeeId(int employeeId);
	public int getEmployeeId();

	public EmployeeType getEmployeeType();

	public boolean isAvailable();
	public Customer getAssignedCustomer();
	public void setAssignedCustomer(Customer assignedCustomer);
	public void takeRequest(Menu.PizzaType pizzaType, List<Ingredient> extras);

	public void update();

}

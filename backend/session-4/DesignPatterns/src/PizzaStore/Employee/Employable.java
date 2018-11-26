package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.Pizza;

import java.util.List;

public interface Employable {

	enum EmployeeType { CUSTOMER_SERVICE, BAKER }

	public void setEmployeeId(int employeeId);
	public int getEmployeeId();

	public EmployeeType getEmployeeType();

	public Pizza handleRequest(Menu.PizzaType pizzaType, List<Ingredient> extras);

}

package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.*;
import PizzaStore.PizzaStore;

import java.util.*;

public class Baker implements Employable {
	// Factory & Strategy & Builder Patterns

	private  PizzaStore pizzaStore; // Observer pattern, subject
	private int employeeId;
	private EmployeeType employeeType;

	public Baker(int employeeId) {
		this.employeeId = employeeId;
		pizzaStore = PizzaStore.getInstance();
		employeeType = EmployeeType.BAKER;
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
	public void update() {
		List<PizzaTemplate> pizzaRequests = pizzaStore.getPizzaRequests();
		Optional<PizzaTemplate> optionalPizzaRequest = pizzaRequests.stream().findFirst();
		if (!optionalPizzaRequest.isPresent())
			return; // No requests left, someone else took it
		PizzaTemplate pizzaRequest = optionalPizzaRequest.get();
		Menu.PizzaType pizzaType = pizzaRequest.getPizzaType();
		PizzaRecipe pizzaRecipe = new PizzaRecipe(pizzaType);

		Set<Ingredient> ingredients = PizzaRecipe.recipes.get(pizzaType);
		List<Ingredient> extras = pizzaRequest.getExtras();

		ingredients.forEach(pizzaRecipe::addIngredient);
		extras.forEach(pizzaRecipe::addExtra);

		Pizza pizza = pizzaRecipe.buildPizza();
		pizzaStore.addPizzaTemplate(pizza);
	}
}

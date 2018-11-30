package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.*;
import PizzaStore.*;

import java.util.*;

public class Baker implements Employable {
	// Factory & Strategy & Builder Patterns

	private  PizzaStore pizzaStore; // Observer pattern, subject
	private int employeeId;
	private EmployeeType employeeType;
	private boolean available;

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
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void update() {
		List<PizzaTemplate> pizzaRequests = pizzaStore.getPizzaRequests();
		Optional<PizzaTemplate> optionalPizzaRequest = pizzaRequests.stream().findFirst();
		if (!optionalPizzaRequest.isPresent())
			return; // No requests left, someone else took it
		available = false;
		PizzaTemplate pizzaRequest = optionalPizzaRequest.get();
		pizzaRequests.remove(pizzaRequest);
		Menu.PizzaType pizzaType = pizzaRequest.getPizzaType();
		PizzaRecipe pizzaRecipe = new PizzaRecipe(pizzaType);

		Set<Ingredient> ingredients = PizzaRecipe.recipes.get(pizzaType);
		List<Ingredient> extras = pizzaRequest.getExtras();

		ingredients.forEach(pizzaRecipe::addIngredient);
		extras.forEach(pizzaRecipe::addExtra);

		Pizza pizza = pizzaRecipe.buildPizza();
		pizzaStore.addPizzaTemplate(pizza);
		available = true;
	}

	@Override
	public Customer getAssignedCustomer() {
		System.out.println("I'm a baker, I can't do that.");
		return null;
	}

	@Override
	public void setAssignedCustomer(Customer assignedCustomer) {
		System.out.println("I'm a baker, I can't do that.");
	}

	@Override
	public void takeRequest(Menu.PizzaType pizzaType, List<Ingredient> extras) {
		System.out.println("I'm a baker, I can't do that.");
	}

}

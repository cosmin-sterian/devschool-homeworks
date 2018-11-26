package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.Pizza;
import PizzaStore.PizzaStore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Baker implements Employable {
	// Factory & Strategy & Builder Patterns
	private static final HashMap<Menu.PizzaType, List<Ingredient>> recipes = new HashMap<Menu.PizzaType, List<Ingredient>>()
	{{
		put(Menu.PizzaType.CHICKEN_BARBEQUE_PIZZA,
				Arrays.asList(
						Ingredient.BACON, Ingredient.ONION, Ingredient.MOZZARELLA,
						Ingredient.TOMATO_SAUCE, Ingredient.BARBEQUE_SAUCE, Ingredient.CHICKEN
				));
		put(Menu.PizzaType.PEPPERONI_PIZZA,
				Arrays.asList(
						Ingredient.MOZZARELLA, Ingredient.PEPPERONI, Ingredient.TOMATO_SAUCE
				));
		put(Menu.PizzaType.PROSCIUTTO_FUNGHI_PIZZA,
				Arrays.asList(
						Ingredient.HAM, Ingredient.MOZZARELLA, Ingredient.TOMATO_SAUCE, Ingredient.MUSHROOMS
				));
		put(Menu.PizzaType.TUNA_PIZZA,
				Arrays.asList(
						Ingredient.FISH, Ingredient.ONION, Ingredient.OLIVES,
						Ingredient.MOZZARELLA, Ingredient.TOMATO_SAUCE
				));
		put(Menu.PizzaType.RUSTIC_PIZZA,
				Arrays.asList(
						Ingredient.BACON, Ingredient.HAM, Ingredient.SAUSAGES,
						Ingredient.ONION, Ingredient.MOZZARELLA,
						Ingredient.TOMATO_SAUCE, Ingredient.CORN
				));
	}};

	private  PizzaStore pizzaStore;
	private int employeeId;
	private EmployeeType employeeType;

	public Baker(int employeeId) {
		this.employeeId = employeeId;
		pizzaStore = PizzaStore.getInstance();
		employeeType = EmployeeType.BAKER;
	}

	public Pizza bakePizza(Menu.PizzaType pizzaType, List<Ingredient> extras) {
//		switch (pizzaType) {
//			case CHICKEN_BARBEQUE_PIZZA:
//				Pizza pizza = bakeChickenBarbequePizza();
//				extras.forEach(pizza::addExtra);
//		}
		//TODO: Check which method is better
		List<Ingredient> ingredients = recipes.get(pizzaType);
		Pizza pizza = new Pizza();
		ingredients.forEach(pizza::addIngredient);
		extras.forEach(pizza::addExtra);
		return pizza;
	}

	private Pizza bakeChickenBarbequePizza() {

//		Pizza pizza = new Pizza()
//				.addIngredient(Ingredient.BACON)
//				.addIngredient(Ingredient.ONION)
//				.addIngredient(Ingredient.MOZZARELLA)
//				.addIngredient(Ingredient.TOMATO_SAUCE)
//				.addIngredient(Ingredient.BARBEQUE_SAUCE)
//				.addIngredient(Ingredient.CHICKEN);
		//TODO: Try Cristi's idea with a custom collector
		List<Ingredient> ingredients = recipes.get(Menu.PizzaType.CHICKEN_BARBEQUE_PIZZA);
		Pizza pizza = new Pizza();
		ingredients.forEach(pizza::addIngredient);
		return pizza;
	}

	private Pizza bakePepperoniPizza() {
		Pizza pizza = new Pizza()
				.addIngredient(Ingredient.MOZZARELLA)
				.addIngredient(Ingredient.PEPPERONI)
				.addIngredient(Ingredient.TOMATO_SAUCE);
		return pizza;
	}

	private Pizza bakeProsciuttoFunghiPizza() {
		Pizza pizza = new Pizza()
				.addIngredient(Ingredient.HAM)
				.addIngredient(Ingredient.MOZZARELLA)
				.addIngredient(Ingredient.TOMATO_SAUCE)
				.addIngredient(Ingredient.MUSHROOMS);
		return pizza;
	}

	private Pizza bakeTunaPizza() {
		Pizza pizza = new Pizza()
				.addIngredient(Ingredient.FISH)
				.addIngredient(Ingredient.ONION)
				.addIngredient(Ingredient.OLIVES)
				.addIngredient(Ingredient.MOZZARELLA)
				.addIngredient(Ingredient.TOMATO_SAUCE);
		return pizza;
	}

	private Pizza bakeRusticPizza() {
		Pizza pizza = new Pizza()
				.addIngredient(Ingredient.BACON)
				.addIngredient(Ingredient.HAM)
				.addIngredient(Ingredient.SAUSAGES)
				.addIngredient(Ingredient.ONION)
				.addIngredient(Ingredient.MOZZARELLA)
				.addIngredient(Ingredient.TOMATO_SAUCE)
				.addIngredient(Ingredient.CORN);
		return pizza;
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
		return bakePizza(pizzaType, extras);
	}
}

package PizzaStore.Menu.Pizza;

import PizzaStore.Menu.Menu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaRecipe {
	// Builder class for PizzaTemplate
	public static final int MAX_EXTRAS = 3;
	public static final HashMap<Menu.PizzaType, Set<Ingredient>> recipes = new HashMap<Menu.PizzaType, Set<Ingredient>>()
	{{
		put(Menu.PizzaType.CHICKEN_BARBEQUE_PIZZA,
				Stream.of(
						Ingredient.BACON, Ingredient.ONION, Ingredient.MOZZARELLA,
						Ingredient.TOMATO_SAUCE, Ingredient.BARBEQUE_SAUCE, Ingredient.CHICKEN
				).collect(Collectors.toSet()));
		put(Menu.PizzaType.PEPPERONI_PIZZA,
				Stream.of(
						Ingredient.MOZZARELLA, Ingredient.PEPPERONI, Ingredient.TOMATO_SAUCE
				).collect(Collectors.toSet()));
		put(Menu.PizzaType.PROSCIUTTO_FUNGHI_PIZZA,
				Stream.of(
						Ingredient.HAM, Ingredient.MOZZARELLA, Ingredient.TOMATO_SAUCE, Ingredient.MUSHROOMS
				).collect(Collectors.toSet()));
		put(Menu.PizzaType.TUNA_PIZZA,
				Stream.of(
						Ingredient.FISH, Ingredient.ONION, Ingredient.OLIVES,
						Ingredient.MOZZARELLA, Ingredient.TOMATO_SAUCE
				).collect(Collectors.toSet()));
		put(Menu.PizzaType.RUSTIC_PIZZA,
				Stream.of(
						Ingredient.BACON, Ingredient.HAM, Ingredient.SAUSAGES,
						Ingredient.ONION, Ingredient.MOZZARELLA,
						Ingredient.TOMATO_SAUCE, Ingredient.CORN
				).collect(Collectors.toSet()));
	}};

	Set<Ingredient> ingredients;
	List<Ingredient> extras;
	Menu.PizzaType pizzaType;

	public PizzaRecipe(Menu.PizzaType pizzaType) {
		ingredients = new HashSet<>();
		extras = new LinkedList<>();
		this.pizzaType = pizzaType;
	}

	public PizzaRecipe addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		return this;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public PizzaRecipe addExtra(Ingredient extra) {
		if (checkFullExtras()) {
			System.out.println("Sorry, no more extras on this pizza!");
			return this;
		}
		extras.add(extra);
		return this;
	}

	public List<Ingredient> getExtras() {
		return extras;
	}

	public Pizza buildPizza() {
		return new Pizza(this);
	}

	public PizzaRequest buildPizzaRequest() {
		return new PizzaRequest(this);
	}

	private boolean checkFullExtras() {
		return extras.size() == MAX_EXTRAS;
	}

}

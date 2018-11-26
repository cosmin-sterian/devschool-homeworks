package PizzaStore.Menu.Pizza;

import java.util.LinkedList;
import java.util.List;

public class Pizza {
	// Target of Builder Pattern
	private static final int MAX_EXTRAS = 3;

	private List<Ingredient> ingredients;
	private List<Ingredient> extras;

	public Pizza() {
		ingredients = new LinkedList<>();
		extras = new LinkedList<>();
	}

	public Pizza addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		return this;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public Pizza addExtra(Ingredient extra) {
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

	private boolean checkFullExtras() {
		return extras.size() == MAX_EXTRAS;
	}
}

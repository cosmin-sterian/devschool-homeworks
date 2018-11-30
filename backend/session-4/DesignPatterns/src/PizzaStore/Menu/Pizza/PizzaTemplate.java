package PizzaStore.Menu.Pizza;

import PizzaStore.Menu.Menu;

import java.util.List;
import java.util.Set;

public abstract class PizzaTemplate {

	public enum TemplateType { REQUEST, PIZZA }

	Set<Ingredient> ingredients;
	List<Ingredient> extras;
	Menu.PizzaType pizzaType;
	TemplateType templateType;

	PizzaTemplate(PizzaRecipe pizzaRecipe) {
		ingredients = pizzaRecipe.ingredients;
		extras = pizzaRecipe.extras;
		pizzaType = pizzaRecipe.pizzaType;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Ingredient> getExtras() {
		return extras;
	}

	public Menu.PizzaType getPizzaType() {
		return pizzaType;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public float getPrice() {
		float price = ingredients
				.stream()
				.reduce(0.0f, (acc, ingredient) -> acc + ingredient.getPrice(), (acc1, acc2) -> acc1 + acc2);
		price += extras
				.stream()
				.reduce(0.0f, (acc, extra) -> acc + extra.getPrice(), (acc1, acc2) -> acc1 + acc2);
		return price;
	}
}

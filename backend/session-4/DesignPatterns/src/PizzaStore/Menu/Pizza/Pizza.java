package PizzaStore.Menu.Pizza;

public class Pizza extends PizzaTemplate {
	// Target of Builder Pattern

	public Pizza(PizzaRecipe pizzaRecipe) {
		super(pizzaRecipe);
		templateType = TemplateType.PIZZA;
	}

}

package PizzaStore.Menu.Pizza;

public class PizzaRequest extends PizzaTemplate {

	public PizzaRequest(PizzaRecipe pizzaRecipe) {
		super(pizzaRecipe);
		templateType = TemplateType.REQUEST;
	}

}

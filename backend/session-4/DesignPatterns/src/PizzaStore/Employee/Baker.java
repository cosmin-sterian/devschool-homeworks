package PizzaStore.Employee;

import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Menu.Pizza.Pizza;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Baker {
	// Factory & Strategy & Builder Patterns

	public void bakePizza(Menu.PizzaTypes pizzaType) {
		//TODO
	}

	public Pizza bakeChickenBarbequePizza() {
		Pizza pizza = new Pizza()
				.addIngredient(Ingredient.BACON)
				.addIngredient(Ingredient.ONION)
				.addIngredient(Ingredient.MOZZARELLA)
				.addIngredient(Ingredient.TOMATO_SAUCE)
				.addIngredient(Ingredient.BARBEQUE_SAUCE)
				.addIngredient(Ingredient.CHICKEN);

//		Pizza functionalPizza = new Pizza()		// Because why not
//				.addWithFunction(Pizza::addIngredient, Ingredient.BACON)
//				.addWithFunction(Pizza::addIngredient, Ingredient.ONION)
//				.addWithFunction(Pizza::addIngredient, Ingredient.MOZZARELLA)
//				.addWithFunction(Pizza::addIngredient, Ingredient.TOMATO_SAUCE)
//				.addWithFunction(Pizza::addIngredient, Ingredient.BARBEQUE_SAUCE)
//				.addWithFunction(Pizza::addIngredient, Ingredient.CHICKEN);
		return pizza;
	}
}

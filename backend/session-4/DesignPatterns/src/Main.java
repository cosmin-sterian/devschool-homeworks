import PizzaStore.Employee.Employable;
import PizzaStore.*;
import PizzaStore.Menu.Menu;
import PizzaStore.Menu.Pizza.Ingredient;
import PizzaStore.Payment.CardPaymentStrategy;
import PizzaStore.Payment.FreePizzaCouponStrategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    	PizzaStore pizzaStore = PizzaStore.getInstance();
		pizzaStore.addEmployee(Employable.EmployeeType.BAKER);
		pizzaStore.addEmployee(Employable.EmployeeType.CUSTOMER_SERVICE);

		new Customer(pizzaStore, "Alex", new CardPaymentStrategy(50.0f)) {{
			choosePizza(Menu.PizzaType.TUNA_PIZZA);
			Arrays.asList(Ingredient.BACON, Ingredient.SAUSAGES, Ingredient.GARLIC_SAUCE, Ingredient.CORN)
					.forEach(this::addExtra);
			placeOrder();
			placeOrder();
			choosePizza(Menu.PizzaType.CHICKEN_BARBEQUE_PIZZA);
			placeOrder();
		}};

		new Customer(pizzaStore, "Dan", new FreePizzaCouponStrategy()) {{
			choosePizza(Menu.PizzaType.PROSCIUTTO_FUNGHI_PIZZA);
			placeOrder();
		}};
    }
}

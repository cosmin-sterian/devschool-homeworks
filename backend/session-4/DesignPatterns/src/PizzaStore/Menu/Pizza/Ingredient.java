package PizzaStore.Menu.Pizza;

public enum Ingredient {
	FISH(2.0f), CORN(0.5f), GARLIC_SAUCE(0.6f), SAUSAGES(1.0f),
	CHICKEN(1.5f), BACON(1.0f), TOMATO_SAUCE(0.2f), ONION(0.2f),
	BARBEQUE_SAUCE(0.7f), MOZZARELLA(0.1f), HAM(0.4f), MUSHROOMS(0.3f),
	OLIVES(0.3f), HOT_SAUCE(0.5f), PEPPERONI(0.5f);

	private float price;

	Ingredient(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}

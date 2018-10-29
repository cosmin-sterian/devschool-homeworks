package OOPPrinciplesChallenge;

public class HealthyBurger extends Hamburger {
    private final String PEPPER = "pepper";
    private final String ONION = "onion";

    public HealthyBurger(String name, String meat, int basePrice) {
        super(name, "brown rye", meat, basePrice);
    }

    public void addPepper(int price) {
        if (containsAddition(PEPPER))
            return;
        Addition pepper = new Addition(PEPPER, price);
        addAddition(pepper);
    }

    public void removePepper() {
        removeAddition(PEPPER);
    }

    public void addOnion(int price) {
        if (containsAddition(ONION))
            return;
        Addition onion = new Addition(ONION, price);
        addAddition(onion);
    }

    public void removeOnion() {
        removeAddition(ONION);
    }

}

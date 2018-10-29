package OOPPrinciplesChallenge;

import java.util.HashMap;
import java.util.Map;

public class Hamburger {
    private final String LETTUCE = "lettuce";
    private final String TOMATO = "tomato";
    private final String CARROT = "carrot";
    private final String PICKLE = "pickle";

    protected class Addition {
        private String name;
        private int price;

        public Addition(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Addition " + name + " costs " + price;
        }
    }

    protected String name;
    protected String breadRollType;
    protected String meat;
    protected int basePrice;
    protected HashMap<Addition, Boolean> additions;

    public Hamburger(String name, String breadRollType, String meat, int basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
        this.additions = new HashMap<>();
    }

    protected boolean containsAddition(String name) {
        for (Map.Entry<Addition, Boolean> entry : additions.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                if (entry.getValue()) {
                    System.out.println("Hamburger already contains addition: " + entry.getKey().getName());
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    protected void removeAddition(String name) {
        for (Map.Entry<Addition, Boolean> entry : additions.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                entry.setValue(false);
                return;
            }
        }
    }

    protected void addAddition(Addition addition) {
        /*
         * Used to check if addition with the same
          * name already exists in the map before
          * adding it
         */
        for (Map.Entry<Addition, Boolean> entry : additions.entrySet()) {
            if (entry.getKey().getName().equals(addition.getName())) {
                entry.setValue(true);
                return;
            }
        }
        additions.put(addition, true);
    }

    public void addLettuce(int price) {
        if (containsAddition(LETTUCE))
            return;
        Addition lettuce = new Addition(LETTUCE, price);
        addAddition(lettuce);
    }

    public void removeLettuce() {
        removeAddition(LETTUCE);
    }

    public void addTomato(int price) {
        if (containsAddition(TOMATO))
            return;
        Addition tomato = new Addition(TOMATO, price);
        addAddition(tomato);
    }

    public void removeTomato() {
        removeAddition(TOMATO);
    }

    public void addCarrot(int price) {
        if (containsAddition(CARROT))
            return;
        Addition carrot = new Addition(CARROT, price);
        addAddition(carrot);
    }

    public void removeCarrot() {
        removeAddition(CARROT);
    }

    public void addPickle(int price) {
        if (containsAddition(PICKLE))
            return;
        Addition pickle = new Addition(PICKLE, price); // PICKLE RIIICK
        addAddition(pickle);
    }

    public void removePickle() {
        removeAddition(PICKLE);
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void printBurger() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + " with " + meat + " meat and " +
                breadRollType + " bread roll with base price = " + basePrice +
                " contains the following additions:");

        int finalPrice = basePrice;

        for (Map.Entry<Addition, Boolean> entry : additions.entrySet()) {
            if (entry.getValue()) {
                // The burger contains this addition
                result.append("\n").append(entry.getKey());
                finalPrice += entry.getKey().getPrice();
            }
        }
        result.append("\n Final price: ").append(finalPrice);

        return result.toString();
    }

    private static void printHeader(String name) {
        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }

    public static void testHamburger() {
        printHeader("Casual Hamburger Test");
        new Hamburger("Hamburger Test", "Classic", "Chicken", 5) {{
           addCarrot(2);
           addLettuce(2);
           printBurger();
           removePickle();
           printBurger();
           addPickle(3);
           addTomato(2);
           addPickle(2);
           printBurger();
        }};

        printHeader("Healthy Burger Test");
        new HealthyBurger("HealthyBurgerTest", "Bio Steak", 10) {{
            addCarrot(5);
            addCarrot(5);
            printBurger();
            addOnion(2);
            addPepper(3);
            printBurger();
            addLettuce(1);
            addTomato(2);
            addPickle(2);
            printBurger();
            removeCarrot();
            printBurger();
        }};

        printHeader("Deluxe Hamburger Test");
        new DeluxeHamburger("DeluxeHamburgerTest", "Rustic", "Steak", 20) {{
           printBurger();
           addChips();
           printBurger();
           addLettuce(2);
           printBurger();
           removeCarrot();
           printBurger();
           removeDrinks();
           printBurger();
        }};
    }
}

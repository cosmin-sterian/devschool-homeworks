package OOPPrinciplesChallenge;

public class DeluxeHamburger extends Hamburger {
    private final String CHIPS = "chips";
    private final String DRINKS = "drinks";

    public DeluxeHamburger(String name, String breadRollType, String meat, int basePrice) {
        super(name, breadRollType, meat, basePrice);
        addChips();
        addDrinks();
    }

    /*
     * These methods are public so that the client can
     * remove the additions or add them back again.
     * Also, I assumed that the Chips and Drinks additions
     * are part of the Deluxe Hamburger menu so they cost 0,
     * otherwise the price can be parsed as an argument
     */
    public void addChips() {
        if (containsAddition(CHIPS))
            return;
        Addition chips = new Addition(CHIPS, 0);
        addAddition(chips);
    }

    public void removeChips() {
        removeAddition(CHIPS);
    }

    public void addDrinks() {
        if (containsAddition(DRINKS))
            return;
        Addition drinks = new Addition(DRINKS, 0);
        addAddition(drinks);
    }

    public void removeDrinks() {
        removeAddition(DRINKS);
    }

    public void printOtherAdditionsError() {
        System.out.println("Sorry, this burger can't contain the required addition.");
    }

    @Override
    public void addLettuce(int price) {
        printOtherAdditionsError();
    }

    @Override
    public void removeLettuce() {
        printOtherAdditionsError();
    }

    @Override
    public void addTomato(int price) {
        printOtherAdditionsError();
    }

    @Override
    public void removeTomato() {
        printOtherAdditionsError();
    }

    @Override
    public void addCarrot(int price) {
        printOtherAdditionsError();
    }

    @Override
    public void removeCarrot() {
        printOtherAdditionsError();
    }

    @Override
    public void addPickle(int price) {
        printOtherAdditionsError();
    }

    @Override
    public void removePickle() {
        printOtherAdditionsError();
    }
}
package Polymorphism;

public class Nissan extends Car {

    public Nissan(int cylindersCount, String name) {
        super(cylindersCount, name);
    }

    @Override
    public boolean getEngine() {
        System.out.println("Nissan engine is " + engine);
        return engine;
    }

    @Override
    public int getWheelsCount() {
        System.out.println("There are " + wheelsCount + " wheels on this Nissan");
        return wheelsCount;
    }

    @Override
    public int getCylindersCount() {
        System.out.println("This " + name + " has a V" + cylindersCount + " engine");
        return cylindersCount;
    }

}

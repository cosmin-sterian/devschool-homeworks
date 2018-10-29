package Polymorphism;

public class Mazda extends Car {

    public Mazda(int cylindersCount, String name) {
        super(cylindersCount, name);
    }

    @Override
    public boolean getEngine() {
        System.out.println(name + "'s engine is " + engine);
        return engine;
    }

    @Override
    public int getWheelsCount() {
        System.out.println("There are " + wheelsCount + " wheels on this " + name);
        return wheelsCount;
    }

    @Override
    public int getCylindersCount() {
        System.out.println("This " + name + "'s engine has " + cylindersCount + " cylinders");
        return cylindersCount;
    }

}

package Polymorphism;

public class FordMustang extends Car {

    public FordMustang(int cylindersCount, String name) {
        super(cylindersCount, name);
    }

    @Override
    public boolean getEngine() {
        System.out.println("This Mustang's engine is " + engine);
        return engine;
    }

    @Override
    public int getWheelsCount() {
        System.out.println("This 'stang has " + wheelsCount + " wheels");
        return wheelsCount;
    }

    @Override
    public int getCylindersCount() {
        System.out.println(name + " got a V" + cylindersCount + " engine");
        return cylindersCount;
    }
}

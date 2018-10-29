package Polymorphism;

public class Car {

    boolean engine;
    int wheelsCount;
    int cylindersCount;
    protected String name;

    public Car(int cylindersCount, String name) {
        this.cylindersCount = cylindersCount;
        this.name = name;
        this.engine = true;
        this.wheelsCount = 4;
    }

    public boolean getEngine() {
        System.out.println("Car engine is " + engine);
        return engine;
    }

    public int getWheelsCount() {
        System.out.println("There are " + wheelsCount + " wheels on this car");
        return wheelsCount;
    }

    public int getCylindersCount() {
        System.out.println("The car's engine has " + cylindersCount + " cylinders");
        return cylindersCount;
    }

    public String getName() {
        System.out.println("This car's name is " + name);
        return name;
    }

    public void getAll() {
        getEngine();
        getWheelsCount();
        getCylindersCount();
        getName();
    }

    public static void testCar() {

        new Mazda(4, "Mazda 3").getAll();
        new FordMustang(8, "Ford Mustang Shelby GT350").getAll();
        new Nissan(8, "Nissan GT-R Nismo").getAll();

    }

}

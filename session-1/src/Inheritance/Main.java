package Inheritance;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle() {{
            System.out.println(toString());
            incSpeed();
            System.out.println(toString());
            setSteering(Steering.RIGHT);
            System.out.println(toString());
        }};
        System.out.println("Vehicle test ended.\n");

        Car car = new Car(){{
            System.out.println(toString());
            incSpeed();
            incGear();
            System.out.println(toString());
            setSteering(Steering.LEFT);
            setSpeedModifier(2f);
            System.out.println(toString());
            incGear();
            System.out.println(toString());
        }};
        System.out.println("Car test ended.\n");

        SuperCar superCar = new SuperCar(8, 2.5f) {{
            System.out.println(toString());
            incSpeed();
            incSpeed();
            incGear();
            System.out.println(toString());
            decGear();
            System.out.println(toString());
            incGear();
            incGear();
            System.out.println(toString());
            setMinGear(10);
            System.out.println(toString());
        }};
        System.out.println("Supercar test ended.\n");

        SuperCar superCarSanityCheck = new SuperCar(-1) {{
            System.out.println(toString());
            incGear();
            System.out.println(toString());
        }};
        System.out.println("Supercar sanity check test ended.\n");
    }
}

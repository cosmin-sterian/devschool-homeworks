import Composition.HouseRoom;
import OOPPrinciplesChallenge.Hamburger;
import Polymorphism.Car;

public class Main {

    public static void main(String[] args) {

        System.out.println("Testing HouseRoom...");
        HouseRoom.testHouseRoom();
        System.out.println("Done testing HouseRoom\n");

        System.out.println("Testing Car...");
        Car.testCar();
        System.out.println("Done testing Car\n");

        System.out.println("Testing Hamburger...");
        Hamburger.testHamburger();
        System.out.println("Done testing Hamburger");
    }

}

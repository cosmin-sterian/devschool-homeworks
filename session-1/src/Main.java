import BarkingDog.Doggo;
import EqualSumChecker.EqualSumChecker;
import Inheritance.Inheritance;
import MinutesToDateCalculator.MinutesToDate;

public class Main {

    public static void main(String[] args) {

        // Inheritance
        System.out.println("\nTesting Inheritance...");
        Inheritance.testInheritance();
        System.out.println("Done testing Inheritance\n");

        // Barking Dog
        System.out.println("\nTesting Barking Dog...");
        Doggo.testBarkingDog();
        System.out.println("Done testing Barking Dog\n");

        // Equal Sum Checker
        System.out.println("\nTesting Equal Sum Checker...");
        EqualSumChecker.testEqualSumChecker();
        System.out.println("Done testing Equal Sum Checker\n");

        // Minutes To Years and Days Calculator
        System.out.println("\nTesting Minutes To Years and Days Calculator...");
        MinutesToDate.testMinutesToDate();
        System.out.println("Done testing Minutes To Years and Days Calculator\n");

    }

}

package BarkingDog;

public class Doggo {
    private static boolean safetyCheck(int hourOfDay) {
        return (hourOfDay > 0 && hourOfDay < 23);
    }

    public static boolean bark(boolean barking, int hourOfDay) {
        return (safetyCheck(hourOfDay) && barking && (hourOfDay < 8 || hourOfDay > 22));
    }

    public static void main(String[] args) {

        System.out.println(bark(true, 1));
        System.out.println(bark(false, 2));
        System.out.println(bark(true, 8));
        System.out.println(bark(true, -1));

    }
}

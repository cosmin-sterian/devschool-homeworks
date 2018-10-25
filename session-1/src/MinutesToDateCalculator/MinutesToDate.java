package MinutesToDateCalculator;

public class MinutesToDate {
    private static final int HOUR_TO_MINUTES = 60;
    private static final int DAY_TO_HOURS = 24;
    private static final int YEAR_TO_DAYS = 365;
    private static final int YEAR_TO_MINUTES = YEAR_TO_DAYS * DAY_TO_HOURS * HOUR_TO_MINUTES;
    private static final int DAY_TO_MINUTES = DAY_TO_HOURS * HOUR_TO_MINUTES;

    private static void printYearsAndDays(int minutes) {
        int years = minutes / YEAR_TO_MINUTES;
        int days = (minutes % YEAR_TO_MINUTES) / DAY_TO_MINUTES; // remainder = minutes % YEAR_TO_MINUTES

        System.out.println(
                        minutes + " min = " + years + " y " +
                        "and " + days + " d"
        );
    }

    public static void main(String[] args) {

        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);

    }
}

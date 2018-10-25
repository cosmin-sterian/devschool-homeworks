package EqualSumChecker;

public class EqualSumChecker {
    private static boolean hasEqualsSum(int a, int b, int c) {
        return ((a + b) == c);
    }

    public static void testEqualSumChecker() {

        System.out.println(
                        hasEqualsSum(1, 1, 1) + "\n" +
                        hasEqualsSum(1, 1, 2) + "\n" +
                        hasEqualsSum(1, -1, 0)
        );

    }
}

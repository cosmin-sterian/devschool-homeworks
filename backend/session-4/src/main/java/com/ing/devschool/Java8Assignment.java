package com.ing.devschool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Assignment {

    public static void main(String[] args) {
        /**
         * Given the following input data.
         */
        List<Integer> numbers = IntStream.range(0, 1_000)
                .boxed()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("One", "Two", "three", "four", "five", "six", "seven", "Eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "Fourteen", "fifteen", "sixteen", "Nineteen", "twenty");

        /**
         * Implement ONE method PER exercise given todos:
         */

        /**
         * For each
         */
        // 1: using "numbers" as input, print first ten numbers
//        example(numbers);
        // 2: using "numbers" as input print first ten odd numbers
        // 3: using "numbers" as input print first ten even numbers
        // 4: implement 1, 2, 3 using one method

        /**
         * Sums
         */
        // 5. using "numbers" as input print their sum
        // 6. using "numbers" as input print the sum of the odd numbers
        // 7. using "numbers" as input print the sum of the even numbers
        // 8. using "numbers" as input print the sum of the even numbers which contain '7'
        // 9. implement 5, 6, 7, 8 using one method

        /**
         * Mixed map/filter/reduce
         */
        // 10. using "numbers" calculate the sum of the double of even numbers
        // 11. using "numbers" calculate the sum of the triple of odd numbers
        // 12. using "numbers" calculate the sum of their half (1/2)
        // 13 implement 10, 11, 12 using one method

        /**
         * Collectors
         */
        // 14. using "words" as input print a string with each UPPERCASED word separated by ', '
        // 15. using "words" as input create a List containing all words starting with a vowel
        // 16. using "words" as input create a List containing all words ending in 'teen'
        // 17. implement 11 and 12 using one method
        // 18. using words as input create a Set of words with an odd number of letters
        // 19. using words as input create a Set containing the number of letters in a word

        /**
         * Converting to java 8
         */
        // 20. convert the following code to java 8
        nonJava8Method(numbers);

        /**
         * Optional<T>
         */
        // 21. using "numbers" as input print the first odd number that can be divided by 121, if it does not exist print -1
    }

    private static void example(List<Integer> numbers) {
        numbers.stream()
                .limit(10)
                .forEach(System.out::print);
    }

    private static void nonJava8Method(List<Integer> numbers) {
        int sum = 0;
        int counter = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int num = 0;

            if (numbers.get(i) % 2 == 0) {
                num = numbers.get(i) + 5;
            } else {
                sum += 0;
                continue;
            }

            num = num * 7;
            if (num % 20 == 3) {
                num = num / 20;
            }

            sum += (num / 10);

            if (++counter > 5) {
                break;
            }
        }

        System.out.println(sum);
    }
}

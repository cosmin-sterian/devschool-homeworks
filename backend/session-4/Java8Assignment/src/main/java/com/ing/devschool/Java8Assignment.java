package com.ing.devschool;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Assignment {

	public static void main(String[] args) {
		/*
		 * Given the following input data.
		 */
		List<Integer> numbers = IntStream.range(0, 1_000)
				.boxed()
				.collect(Collectors.toList());

		List<String> words = Arrays.asList("One", "Two", "three", "four", "five", "six", "seven", "Eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "Fourteen", "fifteen", "sixteen", "Nineteen", "twenty");

		/*
		 * Implement ONE method PER exercise given todos:
		 */

		/*
		 * For each
		 */
		// 1: using "numbers" as input, print first ten numbers
//        example(numbers)
		printExerise(1);
		numbers.stream().limit(10).forEach(e -> System.out.print(e + " "));
		printNewLine();
		/*
		 * another version, but requiring to call println over the result
		 * String result = numbers.stream().limit(10).map(Object::toString).reduce("", (acc, e) -> acc+e+" ");
		 * System.out.println(result);
		 */
		/*
		 * Cristi's fix to reduce numbers with a String accumulator
		 * StringBuilder result = numbers.stream().limit(10).reduce(new StringBuilder(), (acc, e) -> acc.append(e).append(" "), (acc1, acc2) -> acc1.append(acc2));
		 * System.out.println(result);
		 */
		// printSeparator();

		// 2: using "numbers" as input print first ten odd numbers
		printExerise(2);
		numbers.stream().filter(n -> n % 2 != 0).limit(10).forEach(e -> System.out.print(e + " "));
		printNewLine();

		// 3: using "numbers" as input print first ten even numbers
		printExerise(3);
		numbers.stream().filter(n -> n % 2 == 0).limit(10).forEach(e -> System.out.print(e + " "));
		printNewLine();

		// 4: implement 1, 2, 3 using one method
		printExerise(4);
		printNewLine();
		printFilterLimit(numbers, (n -> true), 10);
		printFilterLimit(numbers, (n -> n % 2 != 0), 10);
		printFilterLimit(numbers, (n -> n % 2 == 0), 10);
		System.out.println("End of ForEach exercises...\n");
		/*
		 * Sums
		 */
		// 5. using "numbers" as input print their sum
		printExerise(5);
		System.out.println(numbers.stream().reduce(0, (acc, e) -> acc + e));
		// 6. using "numbers" as input print the sum of the odd numbers
		printExerise(6);
		System.out.println(numbers.stream().filter(n -> n % 2 != 0).reduce(0, (acc, e) -> acc + e));
		// 7. using "numbers" as input print the sum of the even numbers
		printExerise(7);
		System.out.println(numbers.stream().filter(n -> n % 2 == 0).reduce(0, (acc, e) -> acc + e));
		// 8. using "numbers" as input print the sum of the even numbers which contain '7'
		printExerise(8);
		System.out.println(
				numbers.stream()
						.filter(n -> containsDigit(n, 7))
						.filter(n -> n % 2 == 0)
						.reduce(0, (acc, e) -> acc + e));
		/*
		 * A shorter but hack-ish option:
		 * System.out.println(numbers.stream().filter(n -> n.toString().contains("7")).filter(n -> n % 2 == 0).reduce(0, (acc, e) -> acc + e));
		 */
		// 9. implement 5, 6, 7, 8 using one method
		printExerise(9);
		printNewLine();
		printFilterFilterReduce(numbers, e -> true, e -> true, 0, (acc, e) -> acc + e);
		printFilterFilterReduce(numbers, n -> n % 2 != 0, e -> true, 0, (acc, e) -> acc + e);
		printFilterFilterReduce(numbers, n -> n % 2 == 0, e -> true, 0, (acc, e) -> acc + e);
		printFilterFilterReduce(
				numbers, n -> containsDigit(n, 7), n -> n % 2 == 0, 0, (acc, e) -> acc + e
		);
		System.out.println("End of Sums exercises...\n");
		/*
		 * Mixed map/filter/reduce
		 */
		// 10. using "numbers" calculate the sum of the double of even numbers
		printExerise(10);
		System.out.println(numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (acc, e) -> acc + e));
		// 11. using "numbers" calculate the sum of the triple of odd numbers
		printExerise(11);
		System.out.println(numbers.stream().filter(n -> n % 2 != 0).map(n -> n * 3).reduce(0, (acc, e) -> acc + e));
		// 12. using "numbers" calculate the sum of their half (1/2)
		printExerise(12);
		System.out.println(numbers.stream().map(n -> n / 2).reduce(0, (acc, e) -> acc + e));
		// 13 implement 10, 11, 12 using one method
		printExerise(13);
		printFilterMapReduce(numbers, n -> n % 2 == 0, n -> n * 2, 0, (acc, e) -> acc + e);
		printFilterMapReduce(numbers, n -> n % 2 != 0, n -> n * 3, 0, (acc, e) -> acc + e);
		printFilterMapReduce(numbers, n -> true, n -> n / 2, 0, (acc, e) -> acc + e);
		System.out.println("End of Mixed map/filter/reduce exercises\n");
		/*
		 * Collectors
		 */
		// 14. using "words" as input print a string with each UPPERCASED word separated by ', '
		printExerise(14);
		System.out.println(
				words.stream()
						.map(String::toUpperCase)
						.collect(Collectors.joining(", "))
		);
		// 15. using "words" as input create a List containing all words starting with a vowel
		printExerise(15);
		System.out.println(
				words.stream()
						.filter(str -> str.matches("^[AEIOUaeiou]+.*"))
						.collect(Collectors.toList())
		);
		// 16. using "words" as input create a List containing all words ending in 'teen'
		printExerise(16);
		System.out.println(
				words.stream()
						.filter(str -> str.endsWith("teen"))
						.collect(Collectors.toList())
		);
		// 17. implement 11 and 12 using one method
		printExerise(17);
		printNewLine();
		printFilterMapReduce(numbers, n -> n % 2 != 0, n -> n * 3, 0, (acc, e) -> acc + e);
		printFilterMapReduce(numbers, n -> true, n -> n / 2, 0, (acc, e) -> acc + e);
		// 18. using words as input create a Set of words with an odd number of letters
		printExerise(18);
		System.out.println(
				words.stream()
						.filter(str -> str.length() % 2 != 0)
						.collect(Collectors.toSet())
		);
		// 19. using words as input create a Set containing the number of letters in a word
		printExerise(19);
		System.out.println(
				words.stream()
						.map(String::length)
						.collect(Collectors.toSet())
		);
		System.out.println("End of Collectors exercises...\n");
		/*
		 * Converting to java 8
		 */
		// 20. convert the following code to java 8
		printExerise(20);
		printNewLine();
		nonJava8Method(numbers);
		System.out.println(
				numbers.stream()
						.filter(n -> n % 2 == 0)
						.limit(6)
						.map(n -> n + 5)
						.map(n -> n * 7)
						.map(n -> n % 20 == 3 ? n / 20 : n)
						.reduce(0, (acc, e) -> acc + (e / 10))
		); // functional & λ ftw
		/*
		 * Optional<T>
		 */
		// 21. using "numbers" as input print the first odd number that can be divided by 121, if it does not exist print -1
		// numbers = numbers.stream().filter(n -> n % 121 != 0).collect(Collectors.toList()); // Uncomment this line to test orElse case
		printExerise(21);
		System.out.println(
				"Optional: " +
						numbers.stream().filter(n -> n % 2 != 0).filter(n -> n % 121 == 0).findFirst().orElse(-1)
		);
	}

	private static <T, R> void printFilterMapReduce(
			List<T> tList, Predicate<T> predicate, Function<T, R> function,
			R accInitialValue, BinaryOperator<R> binaryOperator
	) {
		System.out.println(tList.stream().filter(predicate).map(function).reduce(accInitialValue, binaryOperator));
		// printSeparator();
	}

	private static <T> void printFilterFilterReduce(
			List<T> tList, Predicate<T> predicate1, Predicate<T> predicate2,
			T accInitialValue, BinaryOperator<T> binaryOperator
	) {
		System.out.println(tList.stream().filter(predicate1).filter(predicate2).reduce(accInitialValue, binaryOperator));
		// printSeparator();
	}

	private static <T> void printFilterLimit(List<T> tList, Predicate<T> predicate, int count) {
		tList.stream().filter(predicate).limit(count).forEach(e -> System.out.print(e + " "));
		System.out.println();
		// printSeparator();
	}

	private static boolean containsDigit(int number, int digit) {
		return (number != 0) && (number % 10 == digit || containsDigit(number / 10, digit));
	}

	private static void printSeparator() {
		System.out.println("------------------------------\n");
	}

	private static void printExerise(int index) {
		System.out.print("[ex " + index + "] ");
	}
	private static void printNewLine() {
		System.out.println();
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

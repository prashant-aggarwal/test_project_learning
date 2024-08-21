package com.pc.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfIterateGenerateExample {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Num1", "Num2", "Num3");
		stream.forEach(System.out::println);

		Stream.iterate(2, num -> num + 1).limit(5).forEach(System.out::println);

		Supplier<Integer> supplier = new Random()::nextInt;
		Stream.generate(supplier).limit(5).forEach(System.out::println);
	}
}

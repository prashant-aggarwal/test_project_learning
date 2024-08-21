package com.pc.stream.numeric;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreamExample {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("Sum: " + sum(numList));
		System.out.println("Sum IntStream: " + sumIntStream());

		System.out.println("IntStream.range: " + IntStream.range(1, 5).count());
		System.out.println("IntStream.rangeClosed: " + IntStream.rangeClosed(1, 5).count());

		DoubleStream doubleStream = IntStream.rangeClosed(1, 5).asDoubleStream();
		doubleStream.forEach(System.out::println);
	}

	// Unboxing of Integer to int is done here.
	private static int sum(List<Integer> numList) {
		return numList.stream().reduce(0, (num1, num2) -> num1 + num2);
	}

	// Unboxing of Integer to int is done here.
	private static int sumIntStream() {
		return IntStream.rangeClosed(1, 10).sum();
	}
}

package com.pc.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	static BinaryOperator<Integer> binaryOperator=(num1, num2) -> num1+num2;
	
	static Comparator<Integer> comparator=(a, b) -> a.compareTo(b);
	static BinaryOperator<Integer> maxBinaryOperator=BinaryOperator.maxBy(comparator);
	static BinaryOperator<Integer> minBinaryOperator=BinaryOperator.minBy(comparator);
	
	public static void main(String[] args) {
		System.out.println(binaryOperator.apply(3, 4));
		System.out.println(maxBinaryOperator.apply(4, 5));
		System.out.println(minBinaryOperator.apply(4, 5));
	}
}

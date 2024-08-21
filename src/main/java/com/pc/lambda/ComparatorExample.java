package com.pc.lambda;

import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		
		/*
		 * Prior to Java 8
		 */
		Comparator<Integer> comparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(String.format("Result of the comparator is: %d", comparator1.compare(93,45)));
		
		/*
		 * Lambda way
		 */
		Comparator<Integer> comparator2 = (num1, num2) -> {
			return num1.compareTo(num2);
		};
		System.out.println(String.format("Result of the comparator is: %d", comparator2.compare(93,450)));
		
		/*
		 * Lambda way even simpler
		 */
		Comparator<Integer> comparator3 = (num1, num2) -> num1.compareTo(num2);
		System.out.println(String.format("Result of the comparator is: %d", comparator3.compare(4, 4)));
	}

}

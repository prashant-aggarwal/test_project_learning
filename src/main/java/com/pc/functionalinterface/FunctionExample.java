package com.pc.functionalinterface;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> sampleFunction = (str) -> str.toUpperCase();
	static Function<String, String> functionConcat = (str) -> str.toUpperCase().concat(" agg");

	public static void main(String[] args) {
		System.out.println("Upper case: " + sampleFunction.apply("pras"));
		System.out.println("Result of addThen is: " + sampleFunction.andThen(functionConcat).apply("pras"));
		System.out.println("Result of compose is: " + sampleFunction.compose(functionConcat).apply("pras"));
	}
}

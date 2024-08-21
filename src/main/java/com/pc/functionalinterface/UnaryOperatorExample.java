package com.pc.functionalinterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

	static UnaryOperator<String> unaryOperator=(str) -> str.concat(" concatenated");
	
	public static void main(String[] args) {
		System.out.println("Unary operator output is: " + unaryOperator.apply("String"));
	}

}

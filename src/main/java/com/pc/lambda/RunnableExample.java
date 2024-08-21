package com.pc.lambda;

public class RunnableExample {

	public static void main(String[] args) {
		/*
		 * Prior to Java 8
		 */
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable 1 !");
			}
		};
		new Thread(runnable).start();
		
		/*
		 * Java 8 Lambda
		 */
		Runnable runnableLambda = () -> {
			System.out.println("Inside Runnable 2 !");
		};
		new Thread(runnableLambda).start();
		
		/*
		 * Java 8 Lambda Even Simpler for 1 LOC
		 * Curly braces {} are MANDATORY for multiple statements
		 */
		Runnable runnableLambda1 = () -> System.out.println("Inside Runnable 3 !");
		new Thread(runnableLambda1).start();
		
		/*
		 * Java 8 Lambda Simplifying it further for 1 LOC
		 */
		new Thread(() -> System.out.println("Inside Runnable 4 !")).start();
	}
}

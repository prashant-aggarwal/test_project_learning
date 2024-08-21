package com.pc.functionalinterface;

import java.util.List;
import java.util.function.BiConsumer;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class BiConsumerExample {

	static List<Student> students = StudentDataBase.getAllStudents();

	public static void main(String[] args) {

		BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println("str1: " + str1 + " str2: " + str2);
		biConsumer.accept("Prashant", "Aggarwal");

		BiConsumer<Integer, Integer> multiply = (num1, num2) -> System.out
				.println("Mulitplication result: " + num1 * num2);
		multiply.accept(30, 5);

		BiConsumer<Integer, Integer> division = (num1, num2) -> System.out.println("Division result: " + num1 / num2);
		division.accept(30, 5);

		multiply.andThen(division).accept(30, 5);

		displayNameAndActivities();

	}

	private static void displayNameAndActivities() {

		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out
				.println("Name: " + name + " Activities: " + activities);
		students.forEach((student) -> biConsumer.accept(student.getName(), student.getActivities()));

	}
}

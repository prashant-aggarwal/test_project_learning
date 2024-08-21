package com.pc.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.pc.data.Student;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<Student> supplier = () -> {
			return new Student();
		};
		System.out.println("Student => " + supplier.get());
		
		Supplier<Student> supplier1 = () -> {
			return new Student("Prashant", 8, 5.5, "Male", Arrays.asList("Cooking","Typing","Learning"));
		};
		System.out.println("Student => " + supplier1.get());
		
		Supplier<List<Student>> supplier2 = () -> {
			List<Student> listStudents = new ArrayList<>();
			listStudents.add(new Student("Prashant", 8, 5.5, "Male", Arrays.asList("Typing","Learning")));
			listStudents.add(new Student("Pragya", 9, 6.5, "Female", Arrays.asList("Cooking","Reading","Coloring")));
			return listStudents;
		};
		System.out.println("Student => " + supplier2.get());
	}
}

package com.pc.constructorreference;

import java.util.function.Function;
import java.util.function.Supplier;

import com.pc.data.Student;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		Supplier<Student> supplierStudent = Student::new;
		System.out.println(supplierStudent.get());
		
		Function<String, Student> functionStudent = Student::new;
		System.out.println(functionStudent.apply("Prashant"));
	}

}

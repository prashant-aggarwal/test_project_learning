package com.pc.optional;

import java.util.Optional;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class OptionalExample {

	private static String getName() {
		Student student = StudentDataBase.studentSupplier.get();
		if (student != null) {
			return student.getName();
		}

		return null;
	}

	private static Optional<String> getNameOptional() {
		// Optional<Student> stOptional =
		// Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> stOptional = Optional.ofNullable(null);
		if (stOptional.isPresent()) {
			return stOptional.map(Student::getName);
		}

		return Optional.empty();
	}

	public static void main(String[] args) {
		String name = getName();
		if (name != null)
			System.out.println("Length of student name: " + name.length());
		else
			System.out.println("Name unavailable");

		Optional<String> stNameOptional = getNameOptional();
		if (stNameOptional.isPresent())
			System.out.println("Length of student name: " + stNameOptional.get().length());
		else
			System.out.println("Optional name unavailable");
	}
}

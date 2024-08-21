package com.pc.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamMapExample {

	public static void main(String[] args) {

		List<Student> students = StudentDataBase.getAllStudents();
		List<String> namesList = students
				.stream()
				.map(Student::getName) // Transforming data
				.map(String::toUpperCase) // Performing operations over each element
				.collect(Collectors.toList()); //.toList() can also be used
		System.out.println(namesList);
		
		Set<String> namesSet = students
				.stream()
				.map(Student::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toSet());
		System.out.println(namesSet);
	}
}

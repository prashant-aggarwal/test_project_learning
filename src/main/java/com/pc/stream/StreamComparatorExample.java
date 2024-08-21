package com.pc.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamComparatorExample {

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
				
		List<Student> sortedStudents = students
				.stream()
				.distinct() // won't work here because this is a list of students
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		System.out.println(sortedStudents);
		
		 sortedStudents = students
					.stream()
					.distinct() // won't work here because this is a list of students
					.sorted(Comparator.comparing(Student::getName).reversed())
					.collect(Collectors.toList());
			System.out.println(sortedStudents);
	}
}

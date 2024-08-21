package com.pc.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamMapReduceExample {

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();

		Integer totalGrade = students
				.stream()
				.map(Student::getGradeLevel)
				// .distinct()
				.reduce(0, (num1, num2) -> num1 + num2);
		System.out.println("With initial value using Identity:" + totalGrade);

		Optional<Integer> totalGrades = students
				.stream()
				.map(Student::getGradeLevel)
				.distinct()
				.reduce(Integer::sum);
		System.out.println("Without initial value totalGrades.isPresent(): " + totalGrades.isPresent());
		if (totalGrades.isPresent())
			System.out.println("totalGrades.get(): " + totalGrades.get());

		Optional<Student> studentHighestGpa = students
				.stream()
				.reduce((a, b) -> {
					if (a.getGpa() > b.getGpa())
						return a;
					else
						return b;
				});
		if (studentHighestGpa.isPresent())
			System.out.println("studentHighestGpa with traditional way: " + studentHighestGpa.get());
		
		studentHighestGpa = students
				.stream()
				.max(Comparator.comparing(Student::getGpa));
		if (studentHighestGpa.isPresent())
			System.out.println("studentHighestGpa with max function: " + studentHighestGpa.get());
		
		studentHighestGpa = students
				.stream()
				.reduce((a, b) -> CustomComparator.compareGpa(a, b));
		if (studentHighestGpa.isPresent())
			System.out.println("studentHighestGpa with CustomComparator: " + studentHighestGpa.get());
		
		Optional<Student> studentMinGradeTraditional = students
				.stream()
				.reduce((a, b) -> a.getGradeLevel() <= b.getGradeLevel() ? a : b);
		if (studentMinGradeTraditional.isPresent())
			System.out.println("studentMinGradeTraditional with traditional way: " + studentMinGradeTraditional.get());
		
		Optional<Student> studentMinGrade = students
				.stream()
				.min(Comparator.comparing(Student::getGradeLevel));
		if (studentMinGrade.isPresent())
			System.out.println("studentMinGrade with min function: " + studentMinGrade.get());
	}
}

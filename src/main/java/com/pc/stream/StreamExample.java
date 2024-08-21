package com.pc.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamExample {

	private static Predicate<Student> predicateGradeLevel = (student) -> student.getGradeLevel() >= 3;
	private static Predicate<Student> predicateGpa = (student) -> student.getGpa() >= 3.9;

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		Map<String, List<String>> mapStudent = students.stream()
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println("\n1. " + mapStudent);

		mapStudent = students.stream()
				.filter(predicateGradeLevel.and(predicateGpa)) //.filter(predicateGradeLevel).filter(predicateGpa)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println("\n2. " + mapStudent);
	}
}

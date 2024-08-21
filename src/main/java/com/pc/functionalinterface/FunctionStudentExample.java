package com.pc.functionalinterface;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class FunctionStudentExample {

	static Function<List<Student>, HashMap<String, Double>> funcStudent = (listStudents -> {
		HashMap<String, Double> mapGrade = new HashMap<>();
		listStudents.forEach(student -> {
			if (PredicateExample.predicateStudentGpa.test(student)) {
				mapGrade.put(student.getName(), student.getGpa());
			}
		});
		return mapGrade;
	});

	static HashMap<String, Double> funcStudent(List<Student> listStudents) {
		HashMap<String, Double> mapGrade = new HashMap<>();
		listStudents.forEach(student -> {
			if (PredicateExample.predicateStudentGpa.test(student)) {
				mapGrade.put(student.getName(), student.getGpa());
			}
		});
		return mapGrade;
	}
	
	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		System.out.println("Result of Lambda: " + funcStudent.apply(students));
		System.out.println("Result of Method: " + funcStudent(students));
	}
}

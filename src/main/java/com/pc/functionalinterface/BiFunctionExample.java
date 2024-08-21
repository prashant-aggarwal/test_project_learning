package com.pc.functionalinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class BiFunctionExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (listStudent, predicateStudent) -> {
		Map<String, Double> mapStudentGpa = new HashMap<>();
		listStudent.forEach((student) -> {
			if (predicateStudent.test(student)) {
				mapStudentGpa.put(student.getName(), student.getGpa());
			}
		});
		return mapStudentGpa;
	};

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		System.out.println(biFunction.apply(students, PredicateExample.predicateStudentGradeLevel));
	}
}

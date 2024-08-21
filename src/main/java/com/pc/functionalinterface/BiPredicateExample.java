package com.pc.functionalinterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class BiPredicateExample {

	BiPredicate<Integer, Double> biPredicateStudent = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
	BiConsumer<String, List<String>> biConsumerStudent = (name, activities) -> System.out
			.println("Name: " + name + " Activities: " + activities);
	Consumer<Student> consumerStudent = (student) -> {
		if(biPredicateStudent.test(student.getGradeLevel(), student.getGpa())) {
			biConsumerStudent.accept(student.getName(), student.getActivities());
		}
	};

	public void displayNameAndActivities(List<Student> students) {
		students.forEach(consumerStudent);
	}

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		new PredicateAndConsumerExample().displayNameAndActivities(students);
	}
}

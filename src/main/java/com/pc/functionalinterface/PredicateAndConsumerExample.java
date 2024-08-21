package com.pc.functionalinterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class PredicateAndConsumerExample {

	Predicate<Student> predicateStudentGradeLevel = (student) -> student.getGradeLevel() >= 3;
	Predicate<Student> predicateStudentGpa = (student) -> student.getGpa() >= 3.9;
	BiConsumer<String, List<String>> biConsumerStudent=(name, activities) -> System.out.println("Name: " + name + " Activities: " + activities);
	Consumer<Student> consumerStudent=(student) -> {
		if(predicateStudentGradeLevel.and(predicateStudentGpa).test(student)) {
			biConsumerStudent.accept(student.getName(), student.getActivities());;
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

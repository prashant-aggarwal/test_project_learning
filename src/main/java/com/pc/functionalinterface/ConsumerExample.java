package com.pc.functionalinterface;

import java.util.List;
import java.util.function.Consumer;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class ConsumerExample {

	static List<Student> students = StudentDataBase.getAllStudents();
	static Consumer<Student> consumerStudent = (student) -> System.out.println(student);
	static Consumer<Student> consumerStudentNames = (student) -> System.out.print(student.getName());
	static Consumer<Student> consumerStudentActivities = (student) -> System.out.println(student.getActivities());
	
	public static void main(String[] args) {
		
		Consumer<String> consumer1 = (str) -> System.out.println(str.toUpperCase());
		consumer1.accept("prashant");
		
		System.out.println("\n=====================================");
		displayStudents();
		System.out.println("\n=====================================");
		displayStudentNameAndActivities();
		System.out.println("\n=====================================");
		displayStudentNameAndActivitiesWithCondition();
	}
	
	public static void displayStudents() {
		students.forEach(consumerStudent);
	}
	
	public static void displayStudentNameAndActivities() {
		students.forEach(consumerStudentNames.andThen(consumerStudentActivities));
	}
	
	public static void displayStudentNameAndActivitiesWithCondition() {
		students.forEach((student) -> {
			if (student.getGradeLevel() >=3) {
				consumerStudentNames.andThen(consumerStudentActivities).accept(student);
			}
		});
	}
}

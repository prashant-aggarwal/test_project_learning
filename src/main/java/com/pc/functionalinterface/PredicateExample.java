package com.pc.functionalinterface;

import java.util.List;
import java.util.function.Predicate;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class PredicateExample {

	static Predicate<Integer> predicateDivByTwo = (num) -> (num % 2 == 0);
	static Predicate<Integer> predicateDivByFive = (num) -> (num % 5 == 0);

	static List<Student> students = StudentDataBase.getAllStudents();
	static Predicate<Student> predicateStudentGradeLevel = (student) -> student.getGradeLevel() >= 3;
	static Predicate<Student> predicateStudentGpa = (student) -> student.getGpa() >= 3.9;

	public static void main(String[] args) {

		Predicate<Integer> predicate = (num) -> {
			return (num % 2 == 0);
		};
		System.out.println("Result: " + predicate.test(35));

		// It is a Lambda expression which can be re-used
		Predicate<Integer> predicate1 = (num) -> (num % 2 == 0);
		System.out.println("Result: " + predicate1.test(30));

		predicateAnd();
		predicateOr();
		predicateNegate();
		System.out.println("======== filterStudentByGrade =============");
		filterStudentByGrade();
		System.out.println("========= filterStudentByGradeAndGpa ============");
		filterStudentByGradeAndGpa();
	}

	private static void predicateAnd() {
		System.out.println("Predicate AND result is: " + predicateDivByTwo.and(predicateDivByFive).test(14));
		System.out.println("Predicate AND result is: " + predicateDivByTwo.and(predicateDivByFive).test(40));
	}

	private static void predicateOr() {
		System.out.println("Predicate OR result is: " + predicateDivByTwo.or(predicateDivByFive).test(13));
		System.out.println("Predicate OR result is: " + predicateDivByTwo.or(predicateDivByFive).test(40));
	}

	private static void predicateNegate() {
		System.out.println(
				"Predicate OR Negate result is: " + predicateDivByTwo.or(predicateDivByFive).negate().test(13));
		System.out.println(
				"Predicate OR Negate result is: " + predicateDivByTwo.or(predicateDivByFive).negate().test(40));
	}

	private static void filterStudentByGrade() {
		students.forEach((student) -> {
			if (predicateStudentGradeLevel.test(student)) {
				System.out.println("Student: " + student);
			}
		});
	}

	private static void filterStudentByGradeAndGpa() {
		students.forEach((student) -> {
			if (predicateStudentGradeLevel.and(predicateStudentGpa).test(student)) {
				System.out.println("Student: " + student);
			}
		});
	}
}

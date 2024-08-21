package com.pc.stream.terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamTerminalOperationsExample {
	public static void main(String[] args) {
		joining();
		counting();
		mapping();
		averaging();
		minBy();
		maxBy();
		summing();
		groupingBy();
		partitionBy();
	}

	private static void groupingBy() {
		List<Student> students = StudentDataBase.getAllStudents();
		Map<String, List<Student>> studentsListType1 = students.stream()
				.collect(Collectors.groupingBy(Student::getGender));
		System.out.println("groupingBy One Level Gender: " + studentsListType1);
		studentsListType1 = students.stream()
				.collect(Collectors.groupingBy(student -> student.getGpa() > 3.6 ? "Outstanding" : "Average"));
		System.out.println("groupingBy One Level GPA: " + studentsListType1);

		Map<String, Map<String, List<Student>>> studentsListType2_1 = students.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.groupingBy(student -> student.getGpa() > 3.6 ? "Outstanding" : "Average")));
		System.out.println("groupingBy Two Level: " + studentsListType2_1);

		Map<String, Integer> studentsListType2_2 = students.stream().collect(Collectors.groupingBy(Student::getGender,
				Collectors.summingInt(student -> student.getActivities().size())));
		System.out.println("groupingBy Two Level: " + studentsListType2_2);

		LinkedHashMap<String, Integer> studentsListType3_1 = students.stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new,
						Collectors.summingInt(student -> student.getActivities().size())));
		System.out.println("groupingBy Three Level 1: " + studentsListType3_1);

		Map<String, Optional<Student>> studentsListType3_2= students.stream().collect(Collectors.groupingBy(Student::getGender, 
																		Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println("groupingBy Three Level 2: " + studentsListType3_2);
		
		Map<String, Student> studentsListType3_3 = students
				.stream()
				.collect(Collectors.groupingBy(Student::getGender, 
												Collectors.collectingAndThen(
														Collectors.maxBy(Comparator.comparing(Student::getGpa)), 
														Optional::get)));
		System.out.println("groupingBy Three Level 3: " + studentsListType3_3);
	}
	
	private static void partitionBy() {
		List<Student> students = StudentDataBase.getAllStudents();
		Map<Boolean, List<Student>> studentList1 = students.stream()
				.collect(Collectors.partitioningBy(student -> student.getGender().equalsIgnoreCase("male")));
		System.out.println("partitionBy studentList1: " + studentList1);
		
		Map<Boolean, Optional<Student>> studentList2 = students.stream()
				.collect(Collectors.partitioningBy(
										student -> student.getGender().equalsIgnoreCase("male"),
										Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println("partitionBy studentList2: " + studentList2);
		
		Map<Boolean, Student> studentList3 = students.stream()
				.collect(Collectors.partitioningBy(
										student -> student.getGender().equalsIgnoreCase("male"),
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparing(Student::getGpa)), 
												Optional::get)));
		System.out.println("partitionBy studentList3: " + studentList3);
	}

	private static void summing() {
		List<Student> students = StudentDataBase.getAllStudents();
		int summingInt = students.stream().collect(Collectors.summingInt(Student::getGradeLevel));
		System.out.println("summingInt Result: " + summingInt);
		long summingLong = students.stream().collect(Collectors.summingLong(Student::getNoteBooks));
		System.out.println("summingLong Result: " + summingLong);
		Double summingDouble = students.stream().collect(Collectors.summingDouble(Student::getGpa));
		System.out.println("summingDouble Result: " + summingDouble);
	}

	private static void maxBy() {
		List<Student> students = StudentDataBase.getAllStudents();
		Optional<Student> student = students.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Student::getGradeLevel)));
		System.out.println("Student with max grade level: " + student);
	}

	private static void minBy() {
		List<Student> students = StudentDataBase.getAllStudents();
		Optional<Student> student = students.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(Student::getGradeLevel)));
		System.out.println("Student with min grade level: " + student);
	}

	private static void averaging() {
		List<Student> students = StudentDataBase.getAllStudents();
		Double avgDouble = students.stream().collect(Collectors.averagingInt(Student::getGradeLevel));
		System.out.println("averagingInt Result: " + avgDouble);
		avgDouble = students.stream().collect(Collectors.averagingLong(Student::getNoteBooks));
		System.out.println("averagingLong Result: " + avgDouble);
		avgDouble = students.stream().collect(Collectors.averagingDouble(Student::getGpa));
		System.out.println("averagingDouble Result: " + avgDouble);
	}

	private static void mapping() {
		List<Student> students = StudentDataBase.getAllStudents();
		List<String> names = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		System.out.println("Mapping Result 1: " + names);
	}

	private static void counting() {
		List<Student> students = StudentDataBase.getAllStudents();
		long result = students.stream().map(Student::getName).collect(Collectors.counting());
		System.out.println("Counting Result 1: " + result);
		result = students.stream().filter(st -> st.getGender().equalsIgnoreCase("male")).count();
		System.out.println("Counting Result 2: " + result);
	}

	private static void joining() {
		List<Student> students = StudentDataBase.getAllStudents();
		String result = students.stream().map(Student::getName).collect(Collectors.joining());
		System.out.println("Joining Result 1: " + result);

		result = students.stream().map(Student::getName).collect(Collectors.joining(","));
		System.out.println("Joining Result 2: " + result);

		result = students.stream().map(Student::getName).collect(Collectors.joining("','", "'", "'"));
		System.out.println("Joining Result 3: " + result);
	}
}
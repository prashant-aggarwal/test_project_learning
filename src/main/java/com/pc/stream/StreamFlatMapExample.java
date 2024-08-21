package com.pc.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class StreamFlatMapExample {

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		List<String> activitiesList = students.stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println("1. " + activitiesList);
		
		List<String> distinctActivitiesList = students.stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("2. " + distinctActivitiesList);
		
		List<String> distinctSortedActivitiesList = students.stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("3. " + distinctSortedActivitiesList);
		
		Set<String> activitiesSet = students.stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.collect(Collectors.toSet());
		System.out.println("4. " + activitiesSet);
	}

}

package com.pc.defaultmethods;

import java.util.Comparator;
import java.util.List;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class DefaultMethodExample {

	public static void main(String[] args) {
		List<Student> listStudents = StudentDataBase.getAllStudents();
		listStudents.sort(Comparator.comparing(Student::getName));
		System.out.println("listStudents ascending: " + listStudents);
		
		listStudents.sort(Comparator.comparing(Student::getName).reversed());
		System.out.println("listStudents descending: " + listStudents); 
	}
}

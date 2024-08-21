package com.pc.stream;

import java.util.Comparator;

import com.pc.data.Student;

public final class CustomComparator implements Comparator<Student> {
	public static Student compareGpa(Student s1, Student s2) {
		return s1.getGpa() >= s2.getGpa() ? s1 : s2;
	}

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getGpa() >= o2.getGpa() ? 1 : -1;
	}
}

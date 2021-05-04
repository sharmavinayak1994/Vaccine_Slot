package com.dsa.linear;

import java.util.Comparator;

import com.dsa.utility.Student;

public class ComparatorforQueue implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.age < s2.age) {
			return -1;
		}else {
			return 1;
		}
	}

}

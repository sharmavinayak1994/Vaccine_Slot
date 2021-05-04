package com.java.practice;

/**
 * @author vinayak sharma
 * <p>in java we have to use colne() or define copy constructor to clone Objects
 * if we just use '=' then it won't create new memory reference it points to same memory as
 * previous object's refer to example below.<p>
 * **/

public class JavaConcepts {

	int test;
	String testConcept;
	
	public JavaConcepts() {
		test =1;
		testConcept = "this is original";
	}
	public JavaConcepts(JavaConcepts concept) {
		this.test = concept.test;
		this.testConcept = concept.testConcept;
	}
	public static void main(String[] args) {
		JavaConcepts concepts = new JavaConcepts();
		JavaConcepts concepts2 = new JavaConcepts();
		JavaConcepts concepts3 = concepts;
		System.out.println(concepts2.test);
		System.out.println(concepts2.testConcept);
		System.out.println("----------");
		
		concepts2 = concepts;
		
		concepts3.test = 0;
		concepts3.testConcept = "this is changed";
		
		System.out.println(concepts2.test);
		System.out.println(concepts2.testConcept);
		System.out.println("----------");

		System.out.println(concepts.test);
		System.out.println(concepts.testConcept);
		
	}
}

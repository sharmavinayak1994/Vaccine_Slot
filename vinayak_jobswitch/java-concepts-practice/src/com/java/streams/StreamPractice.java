package com.java.streams;

import java.util.stream.Stream;

public class StreamPractice {

	public void workWithStream() {
		
		Stream<String> stream = Stream.empty();
		stream = Stream.of("a", "b", "c");
		// to create a stream out of existing array[]  we can use Arrays.stream();
		/**
		 * ways to create stream builder(), generate(), collection, iterate()
		 * To work with primitive data type stream provide IntStream, DoubleStream, LongStream 
		 * Streams can't be reused, create a stream object perform an operation such as stream.findAny()
		 * and then try to perform another operation it might fail as stream does not store elements**/
		
		
		
		
	}
}

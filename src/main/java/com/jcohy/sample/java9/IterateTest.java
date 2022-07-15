package com.jcohy.sample.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/16:01:57
 * @since 2022.04.0
 */
public class IterateTest {

	// tag::java8[]
	@Test
	void java8() {
		List<Integer> numbers = Stream.iterate(1, i -> i+1)
				.limit(10)
				.collect(Collectors.toList());
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println(numbers);
	}
	// end::java8[]

	// tag::java9[]
	@Test
	void java9() {
		List<Integer> numbers = Stream.iterate(1, i -> i <= 10 ,i -> i+1)
				.collect(Collectors.toList());

		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println(numbers);
	}
	// end::java9[]
}

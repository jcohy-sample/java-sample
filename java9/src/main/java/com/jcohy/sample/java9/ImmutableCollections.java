package com.jcohy.sample.java9;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/16:01:15
 * @since 2022.04.0
 */
public class ImmutableCollections {

	// tag::list[]
	@Test
	void list() {
		List<String> names = List.of("Lokesh", "Amit", "John");

		//Preserve the elements order
		// [Lokesh, Amit, John]
		System.out.println(names);

		//names.add("Brian"); //UnsupportedOperationException occured

		//java.lang.NullPointerException
		//List<String> names2 = List.of("Lokesh", "Amit", "John", null);
	}
	// end::list[]

	// tag::set[]
	@Test
	void set() {
		Set<String> names = Set.of("Lokesh", "Amit", "John");

		// Elements order not fixed
		// [Amit, Lokesh, John]
		System.out.println(names);

		//names.add("Brian"); //UnsupportedOperationException occured

		//java.lang.NullPointerException
		//Set<String> names2 = Set.of("Lokesh", "Amit", "John", null);

		//java.lang.IllegalArgumentException
		//Set<String> names3 = Set.of("Lokesh", "Amit", "John", "Amit");
	}
	// end::set[]

	// tag::map[]
	@Test
	void map() {
		Map<String, String> names = Map.ofEntries(
				Map.entry("1", "Lokesh"),
				Map.entry("2", "Amit"),
				Map.entry("3", "Brian"));

		// {1=Lokesh, 2=Amit, 3=Brian}
		System.out.println(names);

		//UnsupportedOperationException
		//names.put("2", "Ravi");
	}
	// end::map[]
}

package com.jcohy.sample.java12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:12:07
 * @since 2022.0.1
 */
public class StringTest {

    // tag::indent[]
    @Test
    void indent() {

        System.out.println("======test java 12 indent======");
        String result = "Java\n Python\nC++".indent(3);
        //   Java
        //    Python
        //   C++
        System.out.println(result);
    }
    // end::indent[]

    // tag::transform[]
    @Test
    void transform() {
        List<String> names = List.of(
                "   Alex",
                "brian");

        List<String> transformedNames = new ArrayList<>();

        for (String name : names) {
            String transformedName = name.transform(String::strip)
                    .transform(String::toLowerCase);
            // alex
            // brian
            transformedNames.add(transformedName);
            System.out.println(transformedName);
        }
    }
    // end::transform[]

    // tag::transform2[]
    @Test
    void transform2() {
        System.out.println("======test java 12 transform======");
        List<String> list1 = List.of("Java", " Python", " C++ ");
        List<String> list2 = new ArrayList<>();
        list1.forEach(element -> list2.add(element.transform(String::strip)
                .transform(String::toUpperCase)
                .transform((e) -> "Hi," + e))
        );
        // Hi,JAVA
        // Hi,PYTHON
        // Hi,C++
        list2.forEach(System.out::println);
    }
    // end::transform2[]

    // tag::transform3[]
    @Test
    void transform3() {
        System.out.println("======test before java 12 ======");
        List<String> list1 = List.of("Java ", " Python", " C++ ");
        Stream<String> stringStream = list1.stream().map(element ->
                element.strip()).map(String::toUpperCase).map(element -> "Hello," + element);
        List<String> list2 = stringStream.collect(Collectors.toList());
        //Hello,JAVA
        //Hello,PYTHON
        //Hello,C++
        list2.forEach(System.out::println);
    }
    // end::transform3[]
}

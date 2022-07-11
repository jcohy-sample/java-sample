package com.jcohy.sample.java9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:16:45
 * @since 2022.0.1
 */
public class Tests {

    // tag::interface1[]
    @Test
    void flattenStrings(List<String>... lists) {
        Set<String> set = new HashSet<>() {};
        for (List<String> list : lists) {
            set.addAll(list);
        }
        System.out.println(new ArrayList<>(set));
    }
    // end::interface1[]

    // tag::resource1[]
    @Test
    void resource() {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            //流的操作
            reader.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // end::resource1[]

    // tag::resource2[]
    @Test
    void resource2() {
        try (InputStreamReader reader = new InputStreamReader(System.in)) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // end::resource2[]

    // tag::resource3[]
    @Test
    void resource3() {
        // jdk 1.9
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) {
            // reader 是 final 的,不可再被赋值
            // reader = null;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // end::resource3[]

    // tag::collection1[]
    @Test
    void collection1() {
        List.of();
        List.of("Hello", "World");
        List.of(1, 2, 3);
        Set.of();
        Set.of("Hello", "World");
        Set.of(1, 2, 3);
        Map.of();
        Map.of("Hello", 1, "World", 2);
    }
    // end::collection1[]

    // tag::testDropWhile[]
    @Test
    void testDropWhile() {
        final long count = Stream.of(1, 2, 3, 4, 5)
                .dropWhile(i -> i % 2 != 0)
                .count();
        // 2 3 4 5
        assertEquals(4, count);
    }
    // end::testDropWhile[]

    // tag::testFlatMapping[]
    @Test
    public void testFlatMapping() throws Exception {
        final Set<Integer> result = Stream.of("a", "ab", "abc")
                .collect(Collectors.flatMapping(v -> v.chars().boxed(),
                        Collectors.toSet()));
        // result: [97, 98, 99]
        System.out.println(result);
        assertEquals(3, result.size());
    }
    // end::testFlatMapping[]

    // tag::testStream[]
    @Test
    public void testStream() throws Exception {
        final long count = Stream.of(
                        Optional.of(1),
                        Optional.empty(),
                        Optional.of(2)
                ).flatMap(Optional::stream)
                .count();
        assertEquals(2, count);
    }
    // end::testStream[]
}

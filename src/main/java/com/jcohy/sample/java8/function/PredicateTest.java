package com.jcohy.sample.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:54
 * @since 2022.0.1
 */
public class PredicateTest {

	// tag::predicate[]
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    @Test
    public void predicate() {
        List<String> list = Arrays.asList("hellsssso", "world", "atcj", "jcohy");
        List<String> str = filterStr(list, (x) -> x.length() > 4);
        for (String str1 : str) {
            /**
             * result:
             * hellsssso
             * world
             * jcohy
             */
            System.out.println(str1);
        }
    }
	// end::predicate[]

}

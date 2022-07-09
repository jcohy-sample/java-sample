package com.jcohy.sample.java8.method;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:57
 * @since 2022.0.1
 */
public class MethodTest {

    // tag::method01[]
    @Test
    void method01() {
        //例如
        Consumer<String> consumer = (x) -> System.out.println(x);
        //等同于
        Consumer<String> consumer1 = System.out::println;

        //例如:
        BinaryOperator<Double> binaryOperator = (x,y) ->Math.pow(x,y);
        //等同于:
        BinaryOperator<Double> binaryOperator1 = Math::pow;

        //例如:
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        //等同于
        Comparator<Integer> comparator2 = Integer::compare;
    }
    // end::method01[]

    // tag::method02[]
    class MyClass {
        Integer name;

        public MyClass(Integer name) {
            this.name = name;
        }
    }
    @Test
    void method02() {
        //例如:
        Function<Integer,MyClass> fun = (n) -> new MyClass(n);
        //等同于
        Function<Integer,MyClass> fun2 = MyClass::new;
    }
    // end::method02[]

    // tag::method03[]
    @Test
    void method03() {
        // 例如:
        Function<Integer,Integer[]> fun = (n) -> new Integer[n];
        // 等同于
        Function<Integer,Integer[]> fun2 = Integer[]::new;
    }
    // end::method03[]
}

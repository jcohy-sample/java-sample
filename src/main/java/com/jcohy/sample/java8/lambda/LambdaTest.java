package com.jcohy.sample.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;


/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/5:19:02
 * @since 2022.0.1
 */
public class LambdaTest {

    // tag::lambda1[]
    // 语法格式一: 无参数,无返回值: **() -> System.out.println("hello world")**;
    @Test
    public void lambda1() {
        System.out.println("------从匿名类到 Lambda 的转换------");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        runnable.run();

        System.out.println("-------------------------");
        Runnable runnable2 = () -> System.out.println("hello world");
        runnable2.run();
    }
    // end::lambda1[]

    // tag::lambda2[]
    // 语法格式二: 有一个参数参数,无返回值: **(x) -> System.out.println(x)**;
    @Test
    public void lambda2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello world");
    }
    // end::lambda2[]

    // tag::lambda3[]
    // 语法格式三: 若只有一个参数,小括号可以省略不写
    @Test
    public void lambda3() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hello world");
    }
    // end::lambda3[]

    // tag::lambda4[]
    // 语法格式四: 有两个以上参数,并且有返回值,并且 Lambda 体中有多条语句
    @Test
    public void lambda4() {
        Comparator<Integer> comparable = (x, y) -> {
            System.out.println("函数式编程");
            return Integer.compare(x, y);
        };
    }
    // end::lambda4[]

    // tag::lambda5[]
    // 语法格式五: 若 Lambda 体中只有一条语句,return 和大括号都可以省略不写
    @Test
    public void lambda5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }
    // end::lambda5[]

}


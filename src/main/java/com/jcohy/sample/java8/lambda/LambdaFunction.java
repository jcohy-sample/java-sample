package com.jcohy.sample.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:30
 * @since 2022.0.1
 */
public class LambdaFunction {

    // tag::lambdafunction1[]
    @FunctionalInterface
    interface Myfun {
        public Integer getValue(Integer num);
    }

    public Integer operation(Integer num,Myfun myfun) {
        return myfun.getValue(num);
    }
    @Test
    void lambda1() {
        Integer integer = operation(100,(x) -> x * x);
        // result: 10000
        System.out.println(integer);
    }
    // end::lambdafunction1[]



    // tag::lambdafunction2[]
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,1111.11),
            new Employee(102,"李四",59,2222.22),
            new Employee(103,"王五",28,3333.33),
            new Employee(104,"赵六",8,4444.44),
            new Employee(105,"田七",38,5555.55),
            new Employee(106,"董八",42,6666.66),
            new Employee(107,"周十",69,7777.77)
    );
    @Test
    void lambda2() {
        Collections.sort(emps,(e1,e2) -> {
            if(Objects.equals(e1.getAge(), e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
    }
    // end::lambdafunction2[]

    // tag::lambdafunction3[]
    public String operation(String num,Func1 myFun){
        return myFun.getValue(num);
    }

    @Test
    void lambda3() {
        // 可以使用方法引用优化
        String helloWorld = operation("Hello World", (str) -> str.toUpperCase());
        String helloWorld1 = operation("Hello World", (str) -> str.substring(2,5));
        // result: HELLO WORLD
        System.out.println(helloWorld);
        // result: llo
        System.out.println(helloWorld1);

    }
    // end::lambdafunction3[]

    // tag::lambdafunction4[]
    public void calculate(Long num1,Long num2,Func2<Long,Long> func2) {
        System.out.println(func2.getValue(num1,num2));
    }
    @Test
    void lambda4() {
        // result: 300
        calculate(100L,200L,(a,b) -> a + b);
        // result: 20000
        calculate(100L,200L,(a,b) -> a*b);
    }
    // end::lambdafunction4[]

}

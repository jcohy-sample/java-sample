package com.jcohy.sample.java8.annotations;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:12
 * @since 2022.0.1
 */
public class TestAnnotation {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : myAnnotations) {
            System.out.println(myAnnotation);
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show() {

    }
}
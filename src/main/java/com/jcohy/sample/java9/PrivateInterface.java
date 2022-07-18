package com.jcohy.sample.java9;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:16:39
 * @since 2022.0.1
 */
public interface PrivateInterface {

    public abstract void method1();

    public default void method2() {
        method4();  //private method inside default method
        method5();  //static method inside other non-static method
        System.out.println("default method");
    }

    public static void method3() {
        method5(); //static method inside other static method
        System.out.println("static method");
    }

    private void method4(){
        System.out.println("private method");
    }

    private static void method5(){
        System.out.println("private static method");
    }
}

class CustomClass implements PrivateInterface {

    @Override
    public void method1() {
        System.out.println("abstract method");
    }

    public static void main(String[] args){
        PrivateInterface instance = new CustomClass();
        instance.method1();
        instance.method2();
        PrivateInterface.method3();
        // 输出：
        // abstract method
        // private method
        // private static method
        // default method
        // private static method
        // static method
    }
}


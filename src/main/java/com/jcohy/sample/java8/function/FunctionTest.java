package com.jcohy.sample.java8.function;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:49
 * @since 2022.0.1
 */
public class FunctionTest {


    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    @Test
    void function() {
        String newStr = strHandler("\\t\\t\\t 哈哈哈哈哈哈哈  ", (str) -> str.trim());
        // result: \t\t\t 哈哈哈哈哈哈哈
        System.out.println(newStr);
    }
}

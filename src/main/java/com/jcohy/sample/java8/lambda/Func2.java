package com.jcohy.sample.java8.lambda;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:39
 * @since 2022.0.1
 */
@FunctionalInterface
public interface Func2<R,T> {
    R getValue(T t1, T t2);
}

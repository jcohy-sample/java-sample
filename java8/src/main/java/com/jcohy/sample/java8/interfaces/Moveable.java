package com.jcohy.sample.java8.interfaces;

/**
 * 描述: .
 *
 * <p>
 * Copyright © 2023 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 1.0.0 2023/2/24 16:37
 * @since 1.0.0
 */
public interface Moveable {

    default void move(){
        System.out.println("I am moving");
    }
}

package com.jcohy.sample.java8.function;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/12:23:54
 * @since 2022.04.0
 */
public interface Moveable {
	default void move(){
		System.out.println("I am moving");
	}
}

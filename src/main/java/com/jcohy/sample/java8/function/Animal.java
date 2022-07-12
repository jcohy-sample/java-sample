package com.jcohy.sample.java8.function;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/13:00:06
 * @since 2022.04.0
 */
public class Animal implements Moveable {
	public static void main(String[] args){
		Animal tiger = new Animal();
		// result: I am moving
		tiger.move();
	}
}

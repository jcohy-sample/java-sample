package com.jcohy.sample.java8.date;

import java.time.LocalDate;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/13:00:55
 * @since 2022.04.0
 */
public class TestLocalDate {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());                //2022-07-13
		System.out.println(localDate.getDayOfWeek().toString()); //WEDNESDAY
		System.out.println(localDate.getDayOfMonth());           //13
		System.out.println(localDate.getDayOfYear());            //194
		System.out.println(localDate.isLeapYear());              //false
		System.out.println(localDate.plusDays(12).toString());   //2022-07-25
	}
}

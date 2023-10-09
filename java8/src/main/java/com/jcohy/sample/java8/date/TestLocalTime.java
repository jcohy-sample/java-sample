package com.jcohy.sample.java8.date;

import java.time.LocalTime;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/13:00:56
 * @since 2022.04.0
 */
public class TestLocalTime {

	public static void main(String[] args) {
//		LocalTime localTime = LocalTime.now();     // toString() in format 00:57:41.065299
		LocalTime localTime = LocalTime.of(12, 20);
		System.out.println(localTime.toString());    //12:20
		System.out.println(localTime.getHour());     //12
		System.out.println(localTime.getMinute());   //20
		System.out.println(localTime.getSecond());   //0
		System.out.println(localTime.MIDNIGHT);      //00:00
		System.out.println(localTime.NOON);          //12:00
	}
}

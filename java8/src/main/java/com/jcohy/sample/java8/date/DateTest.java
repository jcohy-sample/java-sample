package com.jcohy.sample.java8.date;

import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/13:01:06
 * @since 2022.04.0
 */
public class DateTest {

	// tag::createDate[]
	@Test
	void createDate() {
		//Builder pattern used to make date object
		OffsetDateTime date1 = Year.of(2022)
				.atMonth(Month.MAY).atDay(15)
				.atTime(0, 0)
				.atOffset(ZoneOffset.of("+03:00"));
		//2022-05-15T00:00+03:00
		System.out.println(date1);

		//factory method used to make date object
		OffsetDateTime date2 = OffsetDateTime.
				of(2022, 5, 15, 0, 0, 0, 0, ZoneOffset.of("+03:00"));
		// 2022-05-15T00:00+03:00
		System.out.println(date2);
	}
	// end::createDate[]

	// tag::offsetDateTime[]
	@Test
	void test2() {
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println(offsetDateTime.toString());              //2022-07-13T01:06:06.384828+08:00

		offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
		System.out.println(offsetDateTime.toString());              //2022-07-12T22:36:06.385210+05:30

		offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
		System.out.println(offsetDateTime.toString());              //2022-07-12T10:36:06.385245-06:30

		ZonedDateTime zonedDateTime =
				ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(zonedDateTime.toString());           //2022-07-13T01:20:37.832566+08:00[Asia/Shanghai]
	}
	// end::offsetDateTime[]
}

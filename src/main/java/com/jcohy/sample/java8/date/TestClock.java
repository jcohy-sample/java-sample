package com.jcohy.sample.java8.date;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/13:01:16
 * @since 2022.04.0
 */
public class TestClock {

	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock);            //SystemClock[Asia/Shanghai]
		System.out.println(clock.instant().toString()); //2022-07-12T17:19:45.518392Z
		System.out.println(clock.getZone());      //Asia/Shanghai

		Clock anotherClock = Clock.system(ZoneId.of("Asia/Shanghai"));
		System.out.println(anotherClock);           //SystemClock[Asia/Shanghai]
		System.out.println(anotherClock.instant().toString());  //2022-07-12T17:19:45.528479Z
		System.out.println(anotherClock.getZone());       //Asia/Shanghai

		Clock forwardedClock  = Clock.tick(anotherClock, Duration.ofSeconds(600));
		System.out.println(forwardedClock.instant().toString());  //2022-07-12T17:10:00Z
	}
}

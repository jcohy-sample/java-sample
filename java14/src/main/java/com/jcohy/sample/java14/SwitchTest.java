package com.jcohy.sample.java14;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:17:19
 * @since 2022.0.1
 */
public class SwitchTest {

    // tag::switch1[]
    @Test
    void switch1() {
        System.out.println(isWeekDayV1_1(Day.MON));		//true
        System.out.println(isWeekDayV1_2(Day.MON));		//true
        System.out.println(isWeekDayV2(Day.MON));		//true
    }
    enum Day {
        MON, TUE, WED, THUR, FRI, SAT, SUN
    };

    public static Boolean isWeekDayV1_1 (Day day)
    {
        Boolean result = switch(day) {
            case MON, TUE, WED, THUR, FRI -> true;
            case SAT, SUN -> false;
        };
        return result;
    }

    public static Boolean isWeekDayV1_2 (Day day)
    {
        Boolean result = switch(day) {
            case MON, TUE, WED, THUR, FRI : yield true;
            case SAT, SUN : yield false;
        };
        return result;
    }

    //2 - Multiple statements in case block

    public static Boolean isWeekDayV2 (Day day)
    {
        Boolean result = switch(day) {
            case MON, TUE, WED, THUR, FRI ->
            {
                System.out.println("It is WeekDay");
                yield true;
            }
            case SAT, SUN ->
            {
                System.out.println("It is Weekend");
                yield false;
            }
        };
        return result;
    }
    // end::switch1[]

    // tag::switch2[]
    @Test
    void switch2() {
        // one
        howMany(1);
        // two
        howMany(2);
        // many
        howMany(3);
    }
    static void howMany(int k) {
        switch (k) {
            case 1  -> System.out.println("one");
            case 2  -> System.out.println("two");
            default -> System.out.println("many");
        }
    }
    // end::switch2[]

    // tag::switch3[]
    @Test
    void switch3() {

    }
    static void howMany2(int k) {
        System.out.println(
                switch (k) {
                    case  1 -> "one";
                    case  2 -> "two";
                    default -> "many";
                }
        );
    }
    // end::switch3[]

    // tag::switch4[]
    @Test
    void switch4() {

    }
    // end::switch4[]
}

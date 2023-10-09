package com.jcohy.sample.java9;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:18:01
 * @since 2022.0.1
 */
public class IteratedLoopTest {
    static int body(final int sum, final String value) {
        return sum + value.length();
    }

    @Test
    public void testIteratedLoop() throws Throwable {
        final MethodHandle iterator = MethodHandles.constant(
                Iterator.class,
                List.of("a", "bc", "def").iterator());
        final MethodHandle init = MethodHandles.zero(int.class);
        final MethodHandle body = MethodHandles
                .lookup()
                .findStatic(
                        IteratedLoopTest.class,
                        "body",
                        MethodType.methodType(
                                int.class,
                                int.class,
                                String.class));
        final MethodHandle iteratedLoop = MethodHandles
                .iteratedLoop(iterator, init, body);
        assertEquals(6, iteratedLoop.invoke());
    }
}

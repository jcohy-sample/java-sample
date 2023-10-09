package com.jcohy.sample.java9;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:17:34
 * @since 2022.0.1
 */
public class VarHandleTest {

    private HandleTarget handleTarget;

    private VarHandle varHandle;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        this.handleTarget = new HandleTarget();
        this.varHandle = MethodHandles.lookup()
                .findVarHandle(HandleTarget.class, "count", int.class);
    }

    @Test
    void testGet() {
        assertEquals(1, this.varHandle.get(this.handleTarget));
        assertEquals(1, this.varHandle.getVolatile(this.handleTarget));
        // 返回变量的值
        assertEquals(1, this.varHandle.getOpaque(this.handleTarget));
        assertEquals(1, this.varHandle.getAcquire(this.handleTarget));
    }

}

class HandleTarget {
    public int count = 1;
}
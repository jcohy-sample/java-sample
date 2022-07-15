package com.jcohy.sample.java11;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:16:24
 * @since 2022.0.1
 */
public class OptionalApi {

    // tag::optional[]
    @Test
    void optional() {
        String currentTime = null;

        assertTrue(!Optional.ofNullable(currentTime).isPresent());  //It's negative condition
        assertTrue(Optional.ofNullable(currentTime).isEmpty());   //Write it like this

        currentTime = "12:00 PM";

        assertFalse(!Optional.ofNullable(currentTime).isPresent()); //It's negative condition
        assertFalse(Optional.ofNullable(currentTime).isEmpty());  //Write it like this
    }
    // end::optional[]
}

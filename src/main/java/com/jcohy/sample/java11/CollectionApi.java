package com.jcohy.sample.java11;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:16:14
 * @since 2022.0.1
 */
public class CollectionApi {

    // tag::toArray[]
    @Test
    void toArray() {
        List<String> names = new ArrayList<>();
        names.add("alex");
        names.add("brian");
        names.add("charles");

        String[] namesArr1 = names.toArray(new String[names.size()]);   // Before Java 11

        String[] namesArr2 = names.toArray(String[]::new);          // Since Java 11
    }
    // end::toArray[]
}

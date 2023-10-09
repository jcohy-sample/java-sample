package com.jcohy.sample.java18.snippets.snippet;

import java.util.Optional;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/14:14:57
 * @since 2022.0.1
 */
public class ShowOptional {

    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet file="ShowOptional.java" region="example"}
     */
    public void show(Optional<String> v) {
        // @start region="example"
        if (v.isPresent()) {
            System.out.println("v: " + v.get());
        }
        // @end
    }
}

package com.jcohy.sample.java9;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:17:53
 * @since 2022.0.1
 */
public class Process {

    @Test
    void process() throws IOException {
        final ProcessBuilder processBuilder = new ProcessBuilder("top")
                .inheritIO();
        final ProcessHandle processHandle = processBuilder.start().toHandle();
        processHandle.onExit().whenCompleteAsync((handle, throwable) -> {
            if (throwable == null) {
                System.out.println(handle.pid());
            }
            else {
                throwable.printStackTrace();
            }
        });
    }
}

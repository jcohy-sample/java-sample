package com.jcohy.sample.java9;

import java.io.IOException;
import java.util.stream.Stream;

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

    // tag::process1[]
    @Test
    void process1() {
        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processInfo = processHandle.info();

        System.out.println( processHandle.pid() );
        System.out.println( processInfo.arguments().isPresent() );
        System.out.println( processInfo.command().isPresent() );
        System.out.println( processInfo.command().get().contains("java") );
        System.out.println( processInfo.startInstant().isPresent() );
    }
    // end::process1[]

    // tag::process2[]
    @Test
    void process2() {
        String javaPrompt = ProcessUtils.getJavaCmd().getAbsolutePath();
        ProcessBuilder processBuilder = new ProcessBuilder(javaPrompt, "-version");
        Process process = processBuilder.inheritIO().start();
        ProcessHandle processHandle = process.toHandle();
    }
    // end::process2[]

    // tag::process3[]
    @Test
    void process3() {
        Stream<ProcessHandle> children    = ProcessHandle.current().children();
        Stream<ProcessHandle> descendants = ProcessHandle.current().descendants();
    }
    // end::process3[]

    // tag::process[]
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
    // end::process[]
}

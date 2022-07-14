package com.jcohy.sample.java18.web;

import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/13:16:24
 * @since 2022.0.1
 */
// tag::serve1[]
public class SimpleFileServerTest {

    public static void main(String[] args) throws InterruptedException {
        var fileServer = SimpleFileServer.createFileServer(
                new InetSocketAddress(8080),
                Path.of("E:\\picture"),
                OutputLevel.INFO);
        fileServer.start();
    }
}
// end::serve1[]
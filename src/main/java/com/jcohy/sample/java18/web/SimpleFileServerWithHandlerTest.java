package com.jcohy.sample.java18.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/13:17:05
 * @since 2022.0.1
 */
// tag::serve2[]
public class SimpleFileServerWithHandlerTest {

    static class SomePutHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // do something
        }
    }

    public static void main(String[] args) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8080),10, "/store/", new SomePutHandler());
        var handler = SimpleFileServer.createFileHandler(Path.of("E:\\picture"));
        server.createContext("/browse",handler);
        server.start();
    }
}
// end::serve2[]

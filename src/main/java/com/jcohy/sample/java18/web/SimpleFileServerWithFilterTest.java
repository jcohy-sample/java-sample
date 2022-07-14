package com.jcohy.sample.java18.web;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/13:17:05
 * @since 2022.0.1
 */
// tag::serve3[]
public class SimpleFileServerWithFilterTest {


    static class SomePutHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // do something
        }
    }

    public static void main(String[] args) throws IOException {
        var filter = SimpleFileServer.createOutputFilter(System.out, OutputLevel.INFO);
        var server = HttpServer.create(new InetSocketAddress(8080),10, "/store/", new SomePutHandler(),filter);
        server.start();

    }
}
// end::serve3[]

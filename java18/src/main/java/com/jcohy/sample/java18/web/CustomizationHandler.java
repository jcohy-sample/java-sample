package com.jcohy.sample.java18.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/13:17:40
 * @since 2022.0.1
 */
public class CustomizationHandler {

    static class SomePutHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // do something
        }
    }

    static class SomeHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // do something
        }
    }

    public static void main(String[] args) throws IOException {
        var handler = HttpHandlers.handleOrElse(r -> r.getRequestMethod().equals("PUT"), new SomePutHandler(), new SomeHandler());
        var filter = Filter.adaptRequest("Add Foo header", request -> request.with("Foo", List.of("Bar")));
        var server = HttpServer.create(new InetSocketAddress(8080),10,"/",handler,filter);
        server.start();
    }
}

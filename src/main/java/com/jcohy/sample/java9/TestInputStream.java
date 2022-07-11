package com.jcohy.sample.java9;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:18:03
 * @since 2022.0.1
 */
public class TestInputStream {
    private static final String CONTENT = "Hello World";

    private InputStream inputStream;

    @BeforeEach
    public void setUp() throws Exception {
        this.inputStream =
                TestInputStream.class.getResourceAsStream("/input.txt");
    }

    @Test
    public void testReadAllBytes() throws Exception {
        final String content = new String(this.inputStream.readAllBytes());
        assertEquals(CONTENT, content);
    }

    @Test
    public void testReadNBytes() throws Exception {
        final byte[] data = new byte[5];
        this.inputStream.readNBytes(data, 0, 5);
        assertEquals("Hello", new String(data));
    }

    @Test
    public void testTransferTo() throws Exception {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        this.inputStream.transferTo(outputStream);
        assertEquals(CONTENT, outputStream.toString());
    }
}
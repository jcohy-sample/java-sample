package com.jcohy.sample.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:16:16
 * @since 2022.0.1
 */
public class FilesApi {

    // tag::readString[]
    @Test
    void readString() throws IOException {
        Path filePath = Path.of("c:/temp/demo.txt");

        String content = Files.readString(filePath);
    }
    // end::readString[]

    // tag::writeString[]
    @Test
    void writeString() {
        Path filePath = Paths.get("C:/", "temp", "test.txt");

        try {
            //Write content to file
            Files.writeString(filePath, "Hello World !!", StandardOpenOption.APPEND);

            //Verify file content
            String content = Files.readString(filePath);

            // Hello World !!
            System.out.println(content);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // end::writeString[]
}

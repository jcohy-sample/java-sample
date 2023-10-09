package com.jcohy.sample.java12;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:12:17
 * @since 2022.0.1
 */
public class FileTest {

    //tag::mismatch[]
    @TempDir
    private Path tempDir;
    @Test
    void mismatch() throws IOException {
        FileWriter fileWriter = new FileWriter("tmp\\a.txt");
        fileWriter.write("a");
        fileWriter.write("b");
        fileWriter.write("c");
        fileWriter.close();
        FileWriter fileWriterB = new FileWriter("tmp\\b.txt");
        fileWriterB.write("a");
        fileWriterB.write("1");
        fileWriterB.write("c");
        fileWriterB.close();
        // false
        System.out.println(Files.mismatch(Path.of("tmp/a.txt"),Path.of("tmp/b.txt")));
    }
    //end::mismatch[]
}

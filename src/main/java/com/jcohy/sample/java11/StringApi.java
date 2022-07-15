package com.jcohy.sample.java11;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:15:41
 * @since 2022.0.1
 */
public class StringApi {

    // tag::repeat[]
    @Test
    void repeat() {
        String str = "Abc";
        // result: AbcAbcAbc
        System.out.println(str.repeat(3));
    }
    // end::repeat[]

    // tag::repeatWithRegex[]
    @Test
    void repeatWithRegex() {
        String str = "Abc";

        String repeated = new String(new char[3]).replace("\0", str);
        // result: AbcAbcAbc
        System.out.println(repeated);
    }
    // end::repeatWithRegex[]

    // tag::isBlank[]
    @Test
    void isBlank() {
        System.out.println( "ABC".isBlank() );      //false
        System.out.println( " ABC ".isBlank() );    //false
        System.out.println( "  ".isBlank() );     //true
        System.out.println( "".isBlank() );       //true
    }
    // end::isBlank[]

    // tag::isEmpty[]
    @Test
    void isEmpty() {
        System.out.println( "ABC".isBlank() );    //false
        System.out.println( "  ".isBlank() );   //true

        System.out.println( "ABC".isEmpty() );    //false
        System.out.println( "  ".isEmpty() );   //false
    }
    // end::isEmpty[]

    // tag::strip[]
    @Test
    void strip() {
        String str = "  Hello World !!   ";
        //"Hello World !!"
        System.out.println( str.strip() );
        //"Hello World !!   "
        System.out.println( str.stripLeading() );
        //"  Hello World !!"
        System.out.println( str.stripTrailing() );
    }
    // end::strip[]

    // tag::stripWithRegex[]
    @Test
    void stripWithRegex() {
        String str = "  Hello World !!   ";
        //"Hello World !!"
        System.out.println( str.replaceAll("^[ \t]+|[ \t]+$", "") );
        //"Hello World !!   "
        System.out.println( str.replaceAll("^[ \t]+", "") );
        //"  Hello World !!"
        System.out.println( str.replaceAll("[ \t]+$", "") );
    }
    // end::stripWithRegex[]

    // tag::lines[]
    @Test
    void lines() {
        String str = "A \n B \n C \n D";

        Stream<String> lines = str.lines();
        /**
         * A
         * B
         * C
         * D
         */
        lines.forEach(System.out::println);
    }
    // end::lines[]

}

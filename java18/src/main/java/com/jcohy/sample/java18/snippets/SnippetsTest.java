package com.jcohy.sample.java18.snippets;

import java.util.Optional;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/14:11:13
 * @since 2022.0.1
 */
public class SnippetsTest {

    // tag::snippet[]
    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet :
     * if (v.isPresent()) {
     *     System.out.println("v: " + v.get());
     * }
     * }
     */
    public void snippet(Optional<String> v) {
        if (v.isPresent()) {
            System.out.println("v: " + v.get());
        }
    }
    // end::snippet[]

    // tag::snippet2[]
    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet file="ShowOptional.java" region="example"}
     */
    public void show(Optional<String> v) {
        // @start region="example"
        if (v.isPresent()) {
            System.out.println("v: " + v.get());
        }
        // @end
    }
    // end::snippet2[]


    // tag::snippet3[]
    /**
     * A simple program.
     * {@snippet :
     * class HelloWorld {
     *     public static void main(String... args) {
     *         System.out.println("Hello World!");      // @highlight substring="println"
     *     }
     * }
     * }
     */
    public void show3(Optional<String> v) {
    }
    // end::snippet3[]

    // tag::snippet4[]
    /**
     * {@snippet :
     *   public static void main(String... args) {
     *       for (var arg : args) {                 // @highlight region regex = "\barg\b"
     *           if (!arg.isBlank()) {
     *               System.out.println(arg);
     *           }
     *       }                                      // @end
     *   }
     *   }
     */
    public void show4(Optional<String> v) {
    }
    // end::snippet4[]

    // tag::snippet5[]
    /**
     * {@snippet :
     *   public static void main(String... args) {
     *       for (var arg : args) {                 // @highlight region regex = "\barg\b"
     *           if (!arg.isBlank()) {
     *               System.out.println(arg);
     *           }
     *       }                                      // @end
     *   }
     *   }
     */
    public void show5(Optional<String> v) {
    }
    // end::snippet5[]

    // tag::snippet6[]
    /**
     * A simple program.
     * {@snippet :
     * class HelloWorld {
     *     public static void main(String... args) {
     *         System.out.println("Hello World!");  // @link substring="System.out" target="System#out"
     *     }
     * }
     * }
     */
    public void show6(Optional<String> v) {
    }
    // end::snippet6[]

    // tag::snippet7[]
    /**
     * Here are the configuration properties:
     * {@snippet file="config.properties"}
     */
    public void show7(Optional<String> v) {
    }
    // end::snippet7[]

    // tag::snippet8[]
    /**
     * Here are some example properties:
     * {@snippet lang=properties :
     *   local.timezone=PST
     *   # @highlight regex="[0-9]+" :
     *   local.zip=94123
     *   local.area-code=415
     *   }
     */
    public void show8(Optional<String> v) {
    }
    // end::snippet8[]
}

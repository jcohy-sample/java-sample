package com.jcohy.sample.java10;

import java.lang.Runtime.Version;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:10:17
 * @since 2022.0.1
 */
public class VersionTest {

    void version() {
        Version version = Runtime.version();
        // 10
        System.out.println(version.feature());
        // 0
        System.out.println(version.interim());
        // 1
        System.out.println(version.update());
        // 0
        System.out.println(version.patch());

        Version parse = Version.parse("10.0.1");

        // 解析已存在的版本
        // 10
        System.out.println(parse.feature());
        // 0
        System.out.println(parse.interim());
        // 1
        System.out.println(parse.update());
        // 0
        System.out.println(parse.patch());
    }
}

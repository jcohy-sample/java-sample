package com.jcohy.sample.java9;

import java.lang.System.Logger.Level;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:17:54
 * @since 2022.0.1
 */
public class Log {

    private static final System.Logger LOGGER = System.getLogger("Main");

    public static void main(final String[] args) {
        LOGGER.log(Level.INFO, "Run!");
    }
}

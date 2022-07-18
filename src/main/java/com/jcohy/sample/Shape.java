package com.jcohy.sample;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:17:45
 * @since 2022.0.1
 */
public abstract sealed class Shape permits Circle {
}

final class Circle extends Shape {}


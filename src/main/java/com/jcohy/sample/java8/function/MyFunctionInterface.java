package com.jcohy.sample.java8.function;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/12:19:02
 * @since 2022.0.1
 */
@FunctionalInterface
public interface MyFunctionInterface {

    public void firstWork();

    @Override
    public String toString();                //Overridden from Object class

    @Override
    public boolean equals(Object obj);
}

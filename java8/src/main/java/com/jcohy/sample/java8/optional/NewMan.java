package com.jcohy.sample.java8.optional;

import java.util.Optional;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:18
 * @since 2022.0.1
 */
public class NewMan {

    private Optional<Godness> godness;

    public NewMan() {
    }

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public Optional<Godness> getGodness() {
        return this.godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }
}

package com.jcohy.sample.java9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:18:04
 * @since 2022.0.1
 */
public class SHA3 {
    public static void main(final String[] args) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("SHA3-224");
        final byte[] digest = instance.digest("".getBytes());
        System.out.println(Hex.encodeHexString(digest));
    }
}

package com.jcohy.sample.java9;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:18:37
 * @since 2022.0.1
 */
public class Main implements CustomCalculator {

    public static void main(String[] args) {
        CustomCalculator demo = new Main();

        int sumOfEvens = demo.addEvenNumbers(1,2,3,4,5,6,7,8,9);
        // 20
        System.out.println(sumOfEvens);

        int sumOfOdds = demo.addOddNumbers(1,2,3,4,5,6,7,8,9);
        // 25
        System.out.println(sumOfOdds);
    }
}

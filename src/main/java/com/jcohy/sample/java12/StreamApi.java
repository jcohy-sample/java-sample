package com.jcohy.sample.java12;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:11:40
 * @since 2022.0.1
 */
public class StreamApi {

    // tag::teeing[]
    @Test
    void teeing() {
        SalaryRange  minmax = Stream.of(56700, 67600, 45200, 120000, 77600, 85000)
                .collect(Collectors.teeing(
                        minBy(Comparator.naturalOrder()),
                        maxBy(Comparator.naturalOrder()),
                        (Optional<Integer> a, Optional<Integer> b) -> new SalaryRange(a.orElse(Integer.MIN_VALUE), b.orElse(Integer.MAX_VALUE))));
        // SalaryRange {min=45200, max=120000}
        System.out.println(minmax.toString());
    }
    class SalaryRange  {
        private final Integer min;
        private final Integer max;
        public SalaryRange (Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "MinMax {" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
    // end::teeing[]
}

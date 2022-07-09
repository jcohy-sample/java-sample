package com.jcohy.sample.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jcohy.sample.java8.lambda.Employee;
import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:17:54
 * @since 2022.0.1
 */
public class EndStream {
    // tag::supplier[]
    // end::supplier[]

    @Test
    void endStream() {
        List<Employee> list = Arrays.asList(
                new Employee(101,"张三",18,1111.11),
                new Employee(102,"李四",59,2222.22),
                new Employee(103,"王五",28,3333.33),
                new Employee(104,"赵六",8,4444.44),
                new Employee(105,"田七",38,5555.55),
                new Employee(106,"董八",42,6666.66),
                new Employee(107,"周十",69,7777.77)
        );
        //toList
        List<Employee> emps=list.stream().collect(Collectors.toList());

        //toSet
        Set<Employee> emps2=list.stream().collect(Collectors.toSet());

        //toCollection
        Collection<Employee> emps3=list.stream().collect(Collectors.toCollection(ArrayList::new));

        //counting
        long count=list.stream().collect(Collectors.counting());

        //summingInt
        int total=list.stream().collect(Collectors.summingInt(Employee::getSalary));

        //averagingInt
        double avg=list.stream().collect(Collectors.averagingInt(Employee::getSalary));

        //summarizingInt
        IntSummaryStatistic siss=list.stream().collect(Collectors.summarizingInt(Employee::getSalary));

        //joining
        String str=list.stream().map(Employee::getName).collect(Collectors.joining());

        //maxBy
        Optional<Emp> max=list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));

        //minBy
        Optional<Emp> min=list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));

        //reducing
        int total=list.stream().collect(Collectors.reducing(0,Employee::getSalar,Integer::sum));

        //collectingAndThen
        int how=list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),List::size));

        //groupingBy
        Map<Emp.Status, List<Emp>> map= list.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        //partitioningBy
        Map<Boolean,List<Emp>> vd=list.stream().collect(Collectors.partitioningBy(Employee::getManage));
    }
}

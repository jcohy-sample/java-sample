package com.jcohy.sample.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

import com.jcohy.sample.java8.Employee;
import com.jcohy.sample.java8.Status;
import org.junit.jupiter.api.Test;

import static java.util.Comparator.comparingInt;

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
                new Employee(101, "张三", 18, 1111.11, Status.BUSY, 2, true),
                new Employee(102, "李四", 59, 2222.22, Status.FREE, 5, false),
                new Employee(103, "王五", 28, 3333.33, Status.VOCATION, 16, true),
                new Employee(104, "赵六", 8, 4444.44, Status.FREE, 22, false),
                new Employee(105, "田七", 38, 5555.55, Status.FREE, 6, false),
                new Employee(106, "董八", 42, 6666.66, Status.VOCATION, 20, true),
                new Employee(107, "周十", 69, 7777.77, Status.FREE, 10, true)
        );
        // toList
        List<Employee> toList = list.stream().collect(Collectors.toList());
        // result: ...
        System.out.println(toList);

        // toSet
        Set<Employee> toSet = list.stream().collect(Collectors.toSet());
        // result: ...
        System.out.println(toSet);

        // toCollection
        Collection<Employee> toCollection = list.stream().collect(Collectors.toCollection(ArrayList::new));
        // result: ...
        System.out.println(toCollection);

        // counting
        long count = list.stream().collect(Collectors.counting());
        // result: 7
        System.out.println(count);

        // summingInt
        int summingInt = list.stream().collect(Collectors.summingInt(Employee::getSalary));
        // result: 81
        System.out.println(summingInt);

        // averagingInt
        double averagingInt = list.stream().collect(Collectors.averagingInt(Employee::getSalary));
        // result: 11.571428571428571
        System.out.println(averagingInt);

        // summarizingInt
        IntSummaryStatistics summarizingInt = list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
        // result: IntSummaryStatistics{count=7, sum=81, min=2, average=11.571429, max=22}
        System.out.println(summarizingInt);

        // joining
        String str = list.stream().map(Employee::getName).collect(Collectors.joining());
        // result: 张三李四王五赵六田七董八周十
        System.out.println(str);

        // maxBy
        Optional<Employee> max = list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
        // result: Optional[Employee{num=104, name='赵六', age=8, score=4444.44, status=FREE, salary=22, manage=false}]
        System.out.println(max);

        //minBy
        Optional<Employee> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
        // result: Optional[Employee{num=101, name='张三', age=18, score=1111.11, status=BUSY, salary=2, manage=true}]
        System.out.println(min);

        // reducing
        int reducing = list.stream().collect(Collectors.reducing(0, Employee::getSalary, Integer::sum));
        // result: 81
        System.out.println(reducing);

        // collectingAndThen
        int how = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        // result: 7
        System.out.println(how);

        // groupingBy
        Map<Status, List<Employee>> map = list.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        // result: {
        // VOCATION=[Employee{num=103, name='王五'}, Employee{num=106, name='董八'}],
        // FREE=[Employee{num=102, name='李四'}, Employee{num=104, name='赵六'}, Employee{num=105, name='田七'},Employee{num=107, name='周十'}],
        // BUSY=[Employee{num=101, name='张三'}]}
        System.out.println(map);

        // partitioningBy
        Map<Boolean, List<Employee>> vd = list.stream().collect(Collectors.partitioningBy(Employee::getManage));
        // result: {
        // false=[Employee{num=102, name='李四'}, Employee{num=104, name='赵六'}, Employee{num=105, name='田七'}],
        // true=[Employee{num=101, name='张三'}, Employee{num=103, name='王五'}, Employee{num=106, name='董八'}, Employee{num=107, name='周十'}]}
        System.out.println(vd);
    }
}

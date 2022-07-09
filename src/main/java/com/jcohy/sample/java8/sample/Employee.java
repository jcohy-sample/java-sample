package com.jcohy.sample.java8.sample;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:16
 * @since 2022.0.1
 */
public class Employee {

    private Integer num;

    private String name;

    private Integer age;

    private double score;

    private Status status;

    public Employee(Integer num, String name, Integer age, double score, Status status) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.score = score;
        this.status = status;
    }

    public Integer getNum() {
        return this.num;
    }

    public Employee setNum(Integer num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return this.age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public double getScore() {
        return this.score;
    }

    public Employee setScore(double score) {
        this.score = score;
        return this;
    }

    public Status getStatus() {
        return this.status;
    }

    public Employee setStatus(Status status) {
        this.status = status;
        return this;
    }
}

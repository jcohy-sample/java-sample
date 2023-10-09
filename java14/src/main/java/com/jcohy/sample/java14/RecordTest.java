package com.jcohy.sample.java14;

import java.beans.Transient;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:16:36
 * @since 2022.0.1
 */
public class RecordTest {

    // tag::record[]
    record EmployeeRecord(Long id,
                          String firstName,
                          String lastName,
                          String email,
                          int age) {

    }

    @Test
    void record() {
        EmployeeRecord e1 = new EmployeeRecord
                (1l, "Lokesh", "Gupta", "jia_chao23@126.com", 38);

        // 1
        System.out.println(e1.id());
        // jia_chao23@126.com
        System.out.println(e1.email());
        // EmployeeRecord[id=1, firstName=Lokesh, lastName=Gupta, email=jia_chao23@126.com, age=38]
        System.out.println(e1);
    }
    // end::record[]

    // tag::record2[]
    record EmployeeRecord2(@Transient  Long id,
                          String firstName,
                          String lastName,
                          String email,
                          int age) {

    }
    // end::record2[]


    // tag::record3[]
    record EmployeeRecord3(
                           Long id,
                           String firstName,
                           String lastName,
                           String email,
                           int age) implements Serializable {

    }

    @Test
    void record3() {
        EmployeeRecord e1 = new EmployeeRecord
                (1l, "Lokesh", "Gupta", "jia_chao23@126.com", 38);

        writeToFile(e1, "employee1");
        // EmployeeRecord[id=1, firstName=Lokesh, lastName=Gupta,
        //      email=jia_chao23@126.com, age=38]
        System.out.println(readFromFile("employee1"));
    }
    static void writeToFile(EmployeeRecord obj, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(path))){
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static EmployeeRecord readFromFile(String path) {
        EmployeeRecord result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            result = (EmployeeRecord) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    // end::record3[]

    // tag::record4[]
    public record EmployeeRecord4(
            Long id,
            String firstName,
            String lastName,
            String email,
            int age) implements Serializable
    {
        //additional field
        static boolean minor;

        //additional method
        public String fullName()
        {
            return firstName + " " + lastName;
        }
    }
    // end::record4[]

    // tag::record5[]
    public record EmployeeRecord5(
            Long id,
            String firstName,
            String lastName,
            String email,
            int age) implements Serializable
    {
        public EmployeeRecord5
        {
            if(age > 18)
            {
                throw new IllegalArgumentException(
                        "You cannot hire a minor person as employee");
            }
        }
    }
    // end::record5[]
}

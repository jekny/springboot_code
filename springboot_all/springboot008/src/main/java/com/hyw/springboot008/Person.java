package com.hyw.springboot008;

import lombok.Builder;
import lombok.ToString;

/**
 * ClassName: Person
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 16:08
 * @Version 1.0
 */
@Builder
@ToString
public class Person {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Person person = Person.builder()
                .name("lihua")
                .age(21)
                .build();
        System.out.println(person.toString());
    }
}


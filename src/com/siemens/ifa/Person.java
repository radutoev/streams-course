package com.siemens.ifa;

import java.time.LocalDate;
import java.time.Period;

public class Person {
   private String name;
   private LocalDate dob;
   private Sex sex;

    public Person(String name, LocalDate dob, Sex sex) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Sex getSex() {
        return sex;
    }

    public int age() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                '}';
    }
}

package com.siemens.ifa;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        final List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Person> people = generatePeople();


        //collect: toList, toSet, toMap.

        //ex: double of even numbers
//        List<Integer> doubleOfEvents = new ArrayList<>();
        List<Integer> doubleOfEvents  = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
//                .forEach(doubleOfEvents::add); //shared mutability
                .collect(Collectors.toList());
        System.out.println(doubleOfEvents);

        //nr of operations?? 18
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            if(person.age() > 25) {
                names.add(person.getName());
            }
        }

        //
        people.stream() //list size 6
            .filter(p -> p.age() > 25) //list size 4
            .map(Person::getName)
            .collect(Collectors.toList());

        /**
         *  MALE ->
         *
         */
        Map<Sex, List<Person>> map = people.stream()
                .collect(Collectors.groupingBy(p -> p.getSex()));
        System.out.println(map);

//
////        final Predicate<Integer> gt25 = new Predicate<Integer>() {
////            @Override
////            public boolean test(Integer integer) {
////                return integer > 25;
////            }
////        };
//        final Predicate<Integer> gt25 = age -> age > 25;
//
//        TimeIT.code(() ->
//            people.parallelStream()
//                    .map(p -> compute(p))
//                    .map(Person::age) //Person -> age (int)
//                    .filter(gt25) //age(int)
//                    .reduce(0, (acc, x) -> acc += x)
//        );
//
//        String names = people.stream()
//                .map(p -> p.getName())
//                .reduce("", (carry, n) -> carry += n + ",");
//        System.out.println(names.substring(0, names.length() - 1));
    }

    static Person compute(Person p) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }

    static List<Person> generatePeople() {
        return asList(
            new Person("Radu", LocalDate.of(1986, 8, 6), Sex.MALE),
            new Person("Mihai", LocalDate.of(1998, 8, 6), Sex.MALE),
            new Person("Mihaela", LocalDate.of(1996, 8, 6), Sex.FEMALE),
            new Person("Andreea", LocalDate.of(1989, 8, 6), Sex.FEMALE),
            new Person("Roxana", LocalDate.of(1987, 8, 6), Sex.FEMALE),
            new Person("Ana", LocalDate.of(1986, 8, 6), Sex.FEMALE)
        );
    }
}

package com.siemens.ifa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        final List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //double the even values and sum them
        int result = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) { //filtrare
                final int x = number * 2; //mapare x -> x`
                result += x;
            }
        }
        System.out.println(result);

        //internal iterator
        System.out.println(numbers
                .stream() //stream init
                //aplicare de functii -> functional composition
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                //terminal operation, stream termination
                .reduce(0, (acc, x) -> acc += x));

        List<Person> people = generatePeople();

//        final Predicate<Integer> gt25 = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer > 25;
//            }
//        };
        final Predicate<Integer> gt25 = age -> age > 25;

        TimeIT.code(() ->
            people.parallelStream()
                    .map(p -> compute(p))
                    .map(Person::age) //Person -> age (int)
                    .filter(gt25) //age(int)
                    .reduce(0, (acc, x) -> acc += x)
        );

        String names = people.stream()
                .map(p -> p.getName())
                .reduce("", (carry, n) -> carry += n + ",");
        System.out.println(names.substring(0, names.length() - 1));
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

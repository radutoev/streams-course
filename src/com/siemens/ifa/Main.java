package com.siemens.ifa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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

        System.out.println(numbers.stream() //internal iterator
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (acc, x) -> acc += x));
    }
}

package com.kodilla.testing2.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {

        List<Integer> evens = new ArrayList<>();

        for (Integer evenNumber : numbers) {
            if (evenNumber % 2 == 0) {
                evens.add(evenNumber);
            }
        }
        return evens;
    }
}

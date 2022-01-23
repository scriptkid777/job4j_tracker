package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalRange {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> values = new ArrayList<>();
        for (int i = start; i < end; i++) {
             values.add(func.apply((double) i));
        }
        return values;
    }
}

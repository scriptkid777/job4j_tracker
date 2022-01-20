package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalRange {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> values = new ArrayList<>();
        double rsl;
        for (int i = start; i < end; i++) {
            rsl = func.apply((double) i);
            values.add(rsl);
        }
        return values;
    }
}

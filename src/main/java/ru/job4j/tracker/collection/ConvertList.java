package ru.job4j.tracker.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();

        for (int[] num:list) {
            for (int cell : num) {
                rsl.add(cell);
            }
        }

        return rsl;
    }
}
package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String[] firstSplit = first.split("/");
        String[] secondSplit = second.split("/");
        int rsl = secondSplit[0].compareTo(firstSplit[0]);
        return rsl == 0 ? first.compareTo(second) : second.compareTo(first);
    }
}

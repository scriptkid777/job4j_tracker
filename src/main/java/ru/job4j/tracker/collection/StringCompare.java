package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
       int result;
       int size = Math.min(left.length(), right.length());
       for (int i = 0; i < size; i++) {
           result = Character.compare(left.charAt(i), right.charAt(i));
           if (result != 0) {
               return result;
           }
       }
        return Integer.compare(left.length(), right.length());
    }
}
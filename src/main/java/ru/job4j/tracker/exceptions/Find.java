package ru.job4j.tracker.exceptions;

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data =  {"one", "two", "thre"};
        String rsl = Find.get(data, 0);
        System.out.println(rsl);
    }
}

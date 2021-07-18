package ru.job4j.tracker.exceptions;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(3);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть больше 0!");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        System.out.println(rsl);
        return rsl;
    }
}

package ru.job4j.tracker.exceptions;

public class Fact {
    public static void main(String[] args) {
        calc(-1);
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть равно, либо больше 0!");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}

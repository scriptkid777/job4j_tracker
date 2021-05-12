package ru.job4j.tracker;

public class Calculator {
    public static double add(double first, double second) {
        return first + second;
    }

    public static double add(double first, double second, double third) {
        return add(
                first,
                add(second, third)
        );
    }
    public static double add(double first, double second, double third, double fourth){
        return add(first, second, add(third,fourth));
    }

}

package ru.job4j.tracker;

public class Calculator {
    public  double max(double first, double second) {
        if (first > second) {
            return first;
        }
        else {
            return second;
        }
    }

    public  double max(double first, double second, double third) {
        return max(first, max(second, third));
    }

    public  double max(double first, double second, double third, double fourth){
        return max(first, max(second, max(third,fourth)));
    }

}

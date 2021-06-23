package ru.job4j.tracker.poly;

public class Bus  implements Transport {

    @Override
    public void move() {

    }

    @Override
    public void passengers(int passeng) {

    }

    @Override
    public double fuel(double fuel) {
        double price = 39.5;
         return  price * fuel;
    }
}

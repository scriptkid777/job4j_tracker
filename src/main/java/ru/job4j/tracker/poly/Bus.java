package ru.job4j.tracker.poly;

public class Bus  implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passeng) {
        System.out.println("Количество пассажиров:" + passeng);
    }

    @Override
    public double fuel(double fuel) {
        double price = 19.5;
         return  price * fuel;
    }
}

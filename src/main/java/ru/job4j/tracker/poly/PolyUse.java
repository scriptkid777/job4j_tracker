package ru.job4j.tracker.poly;

public class PolyUse {
    public static void main(String[] args) {
        Vehicle vbus = new VBus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();

        Vehicle[] vehicle = new Vehicle[] {vbus, plane, train};
        for (Vehicle vehicle1:vehicle) {
           vehicle1.move();
        }
    }
}

package ru.job4j.tracker;

public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(10);
        Battery battery1 = new Battery(5);
        System.out.println("Заряд первой батареи: " + battery.load + " Заряд второй батареи: " + battery1.load);
        battery1.exchange(battery);
        System.out.println("После обмена заряд первой батареи: " + battery.load + " Заряд второй батареи: " + battery1.load);
    }
}

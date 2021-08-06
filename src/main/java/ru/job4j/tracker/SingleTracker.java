package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker instance = null;

    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
          instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean delete(int id) {
       return tracker.delete(id);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

}
package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        int id;
        Item created = new Item();
        LocalDateTime create = created.getTime();
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String current = create.format(formatter);
        System.out.println(current);
        Item id1 = new Item("test");

        Tracker tracker = new Tracker();
        tracker.add(id1);
        id = id1.getId();
        System.out.println(tracker.findById(id).getName());
    }
}

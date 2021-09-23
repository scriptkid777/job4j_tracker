package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
     public String name() {
        return "=== Showing all the items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}

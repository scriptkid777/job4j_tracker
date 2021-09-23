package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output output;

    public FindNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Looking for an item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Имя заявки для поиска:");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " не найдена.");
        }
        return true;
    }
}

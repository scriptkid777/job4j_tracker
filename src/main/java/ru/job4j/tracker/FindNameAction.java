package ru.job4j.tracker;

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
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдена.");
        }
        return true;
    }
}

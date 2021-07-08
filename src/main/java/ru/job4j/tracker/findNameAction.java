package ru.job4j.tracker;

public class findNameAction implements UserAction{
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
            System.out.println("Заявки с именем:" + name + " не найдены.");
        }
        return true;
    }
}

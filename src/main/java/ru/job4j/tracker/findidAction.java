package ru.job4j.tracker;

public class findidAction  implements UserAction{
    @Override
    public String name() {
        return "=== Looking for an item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Write id of the item to find: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id:" + id + "не найдена.");
        }
        return true;
    }
}

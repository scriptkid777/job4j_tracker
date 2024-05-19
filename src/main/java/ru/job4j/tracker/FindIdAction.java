package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output output;

    public FindIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Looking for an item by id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Write id of the item to find: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}

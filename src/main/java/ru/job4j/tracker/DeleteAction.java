package ru.job4j.tracker;

public class DeleteAction implements UserAction {
   private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Deleting an item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Write id of the item to delete: ");
        tracker.delete(id);
        Item item = tracker.findById(id);
        out.println(item != null ? "Item is deleted successfully." : "Cannot delete the item.");
        return true;
    }
}

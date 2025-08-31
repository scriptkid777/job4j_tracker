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
        out.println("=== Delete item ===");
        int id = input.askInt("Write id of the item to delete: ");
        tracker.delete(id);
        if (tracker.findById(id) == null) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}

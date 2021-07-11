package ru.job4j.tracker;

public class DeleteAction implements UserAction{
   private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Deleting an item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Write id of the item to delete: ");
        if (tracker.delete(id)) {
            out.println("Заявка успешно удалена.");
        } else {
            out.println("Ошибка удаления заявки.");
        }

        return true;
    }
}

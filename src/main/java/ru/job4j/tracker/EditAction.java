package ru.job4j.tracker;

public class EditAction implements UserAction {
    private  Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
         return "=== Editing an item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Write id of the item to edit: ");
        Item item = new Item(input.askStr("Введите имя редактируемой заявки"));
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}

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
        int id = input.askInt("Write id of the item to edit: ");
        Item item = new Item(input.askStr("Введите имя редактируемой заявки"));
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Что-то пошло не так.Заявка не может быть изменена");
        }
        return true;
    }
}

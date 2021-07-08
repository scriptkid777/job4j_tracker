package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
         return "=== Editing an item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Write id of the item to edit: ");
        Item item = new Item(input.askStr("Введите имя редактируемой заявки"));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Что-то пошло не так.Заявка не может быть изменена");
        }
        return true;
    }
}

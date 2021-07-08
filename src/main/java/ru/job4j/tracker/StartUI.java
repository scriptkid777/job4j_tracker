package ru.job4j.tracker;

public class StartUI {

    public static  void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Введите имя заявки ");
        Item item1 = new Item(name);
        tracker.add(item1);
        System.out.println("Добавленная заявка: " + item1);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Showing all the items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deleting an item ===");
        int did = input.askInt("Write id of the item to delete: ");
        if (tracker.delete(did)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Editing an item ===");
        System.out.print("");
        int id = input.askInt("Write id of the item to edit: ");
        Item item = new Item(input.askStr("Введите имя редактируемой заявки"));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Что-то пошло не так.Заявка не может быть изменена");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Looking for an item by id ===");
        int fid = input.askInt("Write id of the item to find: ");
        Item item2 = tracker.findById(fid);
        if (item2 != null) {
            System.out.println(item2);
        } else {
            System.out.println("Заявка с введенным id:" + fid + "не найдена.");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Looking for an item by name ===");
        String name1 = input.askStr("Имя заявки для поиска:");
        Item[] items1 = tracker.findByName(name1);
        if (items1.length > 0) {
            for (Item item3 : items1) {
                System.out.println(item3);
            }
        } else {
            System.out.println("Заявки с именем:" + name1 + " не найдены.");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
           run = action.execute(input, tracker);
        }
    }

        private void showMenu(UserAction[] actions) {

        System.out.println("Menu.");
            for (int i = 0; i < actions.length; i++) {
                System.out.println(i + ". " + actions[i].name());
            }
        }

        public static void main(String[]args) {
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(),
                    new DeleteAction(),
                    new EditAction(),
                    new findidAction(),
                    new findNameAction(),
                    new FindAllAction(),
                    new ExitAction()
            };
            new StartUI().init(input, tracker, actions);
        }
    }


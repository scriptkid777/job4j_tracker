package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ===");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item1 = new Item(name);
                    tracker.add(item1);
                    System.out.println("Добавленная заявка: " + item1);
                    break;

                case 1:
                    System.out.println("=== Showing all the items ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Хранилище еще не содержит заявок");
                    }
                    break;

                case 2:
                    System.out.println("=== Editing an item ===");
                    System.out.print("Write id of the item to edit: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Write new name of the item: ");
                    Item item = new Item(scanner.nextLine());
                    if (tracker.replace(id, item)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Что-то пошло не так.Заявка не может быть изменена");
                    }
                    break;

                case 3:
                    System.out.println("=== Deleting an item ===");
                    System.out.print("Write id of the item to delete: ");
                    int did = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(did)) {
                        System.out.println("Заявка успешно удалена.");
                    } else {
                        System.out.println("Ошибка удаления заявки.");
                    }
                    break;

                case 4:
                    System.out.println("=== Looking for an item by id ===");
                    System.out.print("Write id of the item to find: ");
                    int fid = Integer.valueOf(scanner.nextLine());
                    Item item2 = tracker.findById(fid);
                    if (item2 != null) {
                        System.out.println(item2);
                    } else {
                        System.out.println("The item with id=" + fid + " is not found");
                    }
                    break;

                case 5:
                    System.out.println("=== Looking for an item by name ===");
                    System.out.print("Write name of the item to find: ");
                    String name1 = scanner.nextLine();
                    Item[] items1 = tracker.findByName(name1);
                    if (items1.length > 0) {
                        for (Item item3 : items1) {
                            System.out.println(item3);
                        }
                    } else {
                        System.out.println("Item with the given name \"" + name1 + "\" is not found");
                    }
                    break;

                case 6:
                    System.out.println("=== Exiting the program ===");
                    run = false;
                    break;
                default:

            }
        }
    }

        private void showMenu() {
            String[] menu = {
                    "Add new Item", "Show all items", "Edit item",
                    "Delete item", "Find item by id", "Find items by name",
                    "Exit Program"
            };
        System.out.println("Menu.");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + ". " + menu[i]);
            }
        }

        public static void main(String[]args) {
            Scanner scanner = new Scanner(System.in);
            Tracker tracker = new Tracker();
            new StartUI().init(scanner, tracker);
        }
    }


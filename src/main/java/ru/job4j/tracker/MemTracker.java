package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

public class MemTracker  implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().equals(key)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    @Override
    public void close() throws Exception {

    }

    public boolean replace(int id, Item item) {

        int index = indexOf(id);
        if (index != -1) {
           item.setId(id);
           items.set(index, item);
           return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
    }
}
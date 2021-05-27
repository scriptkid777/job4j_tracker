package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll(){
        int size = 0;
       Item[] itemsoutnull = new Item[items.length];
        for (Item item : items) {
            if (item != null) {
                itemsoutnull[size] = item;
                size++;
            }
        }
        return itemsoutnull = Arrays.copyOf(itemsoutnull, size);
    }
}
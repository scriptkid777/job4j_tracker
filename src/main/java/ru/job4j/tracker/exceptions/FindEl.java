package ru.job4j.tracker.exceptions;

public class FindEl {
    public static int indexOf(String[] value, String key) throws  ElementNotFoundException {
        int rsl = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Индекс элемента не найден");
        }
        return rsl;
    }

    public static void main(String[] args)  {
        try {
        indexOf(new String[]{"A", "B", "C", "D", "E"},"G");
        } catch (ElementNotFoundException t) {
            t.printStackTrace();
        }
    }
}

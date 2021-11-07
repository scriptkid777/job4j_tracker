package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortById() {
        List<Item> rsl  = Arrays.asList(new Item("First", 1),
                new Item("Second", 2),
                new Item("Third", 3));
        List<Item> expect  = Arrays.asList(new Item("Third", 3),
                new Item("Second", 2),
                new Item("First", 1));
        Collections.sort(rsl, Collections.reverseOrder());
        assertThat(rsl, is(expect));
    }

    @Test
    public void sortByName() {
        List<Item> rsl  = Arrays.asList(new Item("Cookie"),
                new Item("Banana"),
                new Item("Apple"));
        List<Item> expect = Arrays.asList(new Item("Apple"),
                new Item("Banana"),
                new Item("Cookie"));
        Collections.sort(rsl, new SortByItemsName());
        assertThat(rsl, is(expect));
    }

    @Test
    public void sortByNameReversed() {
        List<Item> rsl  = Arrays.asList(new Item("Apple"),
                new Item("Banana"),
                new Item("Cookie"));
        List<Item> expect = Arrays.asList(new Item("Cookie"),
                new Item("Banana"),
                new Item("Apple"));
        Collections.sort(rsl, new SortByItemsNameReverse());
        assertThat(rsl, is(expect));
    }
}
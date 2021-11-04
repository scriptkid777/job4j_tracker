package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import java.util.List;
import java.util.Collections;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void sortById() {
        Tracker tracker = new Tracker();
        Item first = new Item("First", 1);
        Item second = new Item("Second", 2);
        Item third = new Item("Third", 3);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, Collections.reverseOrder());
        assertThat(rsl, is(expect));
    }

    @Test
    public void sortByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("Cookie");
        Item second = new Item("Banana");
        Item third = new Item("Apple");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, new SortByItemsName());
        assertThat(rsl, is(expect));
    }

    @Test
    public void sortByNameReversed() {
        Tracker tracker = new Tracker();
        Item first = new Item("Apple");
        Item second = new Item("Banana");
        Item third = new Item("Cookie");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, new SortByItemsNameReverse());
        assertThat(rsl, is(expect));
    }

}
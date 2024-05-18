package ru.job4j.tracker;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import java.util.List;

public class StartUITest {

      @Test
       public void whenCreateItem() {
          Output output = new ConsoleOutput();
           Input in = new StubInput(List.of("0", "Item name", "1"));
           MemTracker memTracker = new MemTracker();
           List<UserAction> actions = List.of(new CreateAction(output), new ExitAction(output));
           new StartUI(output).init(in, memTracker, actions);
           assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
       }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        /* Добавим в memTracker новую заявку */
        Item item = memTracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(List.of("0", String.valueOf(item.getId()), replacedName, "1"));
        List<UserAction> actions = List.of(new EditAction(output), new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
        /* Добавим в memTracker новую заявку */
        Item item = memTracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(List.of("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = List.of(new DeleteAction(output), new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0"));
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("новая заявка"));
        Input in = new StubInput(List.of("0", "1"));
        List<UserAction> actions = List.of(new FindAllAction(output), new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Showing all the items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Showing all the items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
     Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        String name = "заявка";
        Input in = new StubInput(List.of("0", "заявка", "1"));
        List<UserAction> actions  = List.of(new FindNameAction(output), new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. === Looking for an item by name ===" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Заявки с именем: " + name + " не найдена." + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Looking for an item by name ===" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("item"));
        Input in = new StubInput(List.of("0", "1", "1"));
        List<UserAction> actions = List.of(new FindIdAction(output), new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. === Looking for an item by id ===" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                        + "0. === Looking for an item by id ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("7", "0"));
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}
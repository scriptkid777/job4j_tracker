package ru.job4j.tracker;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

      @Test
       public void whenCreateItem() {
          Output output = new ConsoleOutput();
           Input in = new StubInput(
                   new String[] {"0", "Item name", "1"}
           );
           Tracker tracker = new Tracker();
           UserAction[] actions = {
                   new CreateAction(output),
                   new ExitAction(output)
           };
           new StartUI(output).init(in, tracker, actions);
           assertThat(tracker.findAll()[0].getName(), is("Item name"));
       }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("новая заявка"));
        Input in = new StubInput(
                new String[]{"0", "1"});
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Showing all the items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + "Item{id=1, name='новая заявка'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Showing all the items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
     Output output = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "заявка";
        //Item item = tracker.add(new Item(name));
        Input in = new StubInput(new String[]{"0", "заявка", "1"});
        UserAction[] actions  = {new FindNameAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. === Looking for an item by name ===" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Заявки с именем:" + name + " не найдена." + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(1));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
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
package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputTrue() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenvalidInputmore() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        assertThat(selected1, is(2));
        assertThat(selected2, is(3));
    }

    @Test
    public void whenInvalidInputminus() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }

}
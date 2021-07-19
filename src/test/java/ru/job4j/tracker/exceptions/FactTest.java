package ru.job4j.tracker.exceptions;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FactTest {

     @Test(expected = IllegalArgumentException.class)
    public void whenNlessZero() {
       int rsl = Fact.calc(-2);
        assertThat(rsl,is(2));
    }
}
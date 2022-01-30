package ru.job4j.tracker.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void check() {
        Citizen citizen = new Citizen("2e55f", "Petr");
        Citizen citizen1 = new Citizen("2e55f","Alex");
        PassportOffice office = new PassportOffice();
        office.add(citizen);

        assertFalse(office.add(citizen1));
    }

}
package ru.job4j.tracker.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "543872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("543872");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindZero() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "543872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Novosib");
        assertThat(persons.size(), is(0));
    }
}
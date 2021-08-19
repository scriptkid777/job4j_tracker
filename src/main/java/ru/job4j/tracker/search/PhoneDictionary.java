package ru.job4j.tracker.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (key.equals(person.getName()) || key.equals(person.getSurname())
                    || key.equals(person.getPhone()) || key.equals(person.getAddress())) {
                result.add(person);
            }
        }
        return result;
    }
}
package ru.job4j.tracker.bank;

import java.util.Objects;

public class User {
private String passport;
private String username;

    /**
     * Конструктор
     *
     * @param passport - данные паспорта
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределения метода equals для сравнивания объектв модели
     *
     * @param o - объект пользователь
     * @return true -если равны,false - если не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return passport.equals(user.passport);
    }

    /**
     * Переопределение hashCode() метода
     *
     * @return hashcode паспорт
     */

    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}

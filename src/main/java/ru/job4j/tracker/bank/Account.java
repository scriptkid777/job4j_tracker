package ru.job4j.tracker.bank;

import java.util.Objects;
/**
 * Модель счета пользователя
 *
 * @author OnufrienkoI
 * @version 1.0
 */
public class Account {
    /**
     * requisite- хранит значения реквизитов счета ползователя
     */
    private String requisite;

    /**
     * balance - баланс счета пользователя
     */
    private double balance;

    /**
     * Конструктор, для иницилиазии данных полей
     *
     * @param requisite - реквизиты
     * @param balance   - баланс
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Переопределения метода equals для сравнивания объектов модели
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }
    /**
     * Переопределение hashCode() метода
     *
     * @return hashcode реквизитов
     */

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}

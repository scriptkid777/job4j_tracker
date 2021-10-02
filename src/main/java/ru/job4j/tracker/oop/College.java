package ru.job4j.tracker.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman(); /* Объект класса Freshman */
        Student student = freshman; /*приведение к типу родителя Student, up casting */
        Object obj = freshman; /* приведение к типу родителя Object, up casting */
    }
}

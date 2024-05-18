package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Alexey Ivanovich Ivanov");
        student.setGroup("pi-04");
        student.setReceipt(new Date(7760000));
        System.out.println(student.getFio()
                + "  " + student.getGroup() + "  " + student.getReceipt());
    }
}

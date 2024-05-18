package ru.job4j.tracker;

public class Surgeon extends Doctor {
    private String operation;

    public Surgeon(String name, String surname, String education,
                   String birthday, String diagnosis, String preparat, String operation) {
        super(name, surname, education, birthday, diagnosis, preparat);
        this.operation = operation;
    }

    public  String getOperation() {
        return operation;
    }

    public Surgeon fixPatient(Doctor doctor) {
        return null;
    }
}

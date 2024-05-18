package ru.job4j.tracker;

public class Dentist extends Doctor {
    private final String consultate;

    public Dentist(String name, String surname, String education, String birthday,
                   String diagnosis, String preparat, String consultate) {
        super(name, surname, education, birthday, diagnosis, preparat);
        this.consultate = consultate;
    }

    public  String getConsultate() {
        return consultate;
    }

    public  void deleteTeeth() {

    }
}

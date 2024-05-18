package ru.job4j.tracker;

public class Programmer extends  Engineer {
    private  String languages;
    private  String level;

    public Programmer(String name, String surname,
                      String education, String birthday,
                      boolean certificate, String languages, String level) {
        super(name, surname, education, birthday, certificate);
        this.languages = languages;
        this.level = level;
    }

    public void  code() {

    }

    public void testCode() {

    }

    public String getLanguages() {
        return languages;
    }

    public String getLevel() {
        return level;
    }
}

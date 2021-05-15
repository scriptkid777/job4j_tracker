package ru.job4j.tracker;

public class Doctor extends Profession {
    private String diagnosis;
    private String preparat;

    public Doctor(String name, String surname, String education, String birthday,String diagnosis, String preparat){
        super(name,surname,education,birthday);
        this.diagnosis = diagnosis;
        this.preparat = preparat;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPreparat() {
        return preparat;
    }

}

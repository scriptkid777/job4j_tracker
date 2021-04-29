package ru.job4j.tracker;

public class DummyDic {
    public String engToRus(String eng) {
       eng = "Неизвестное слово. " + eng;
        return eng;
    }

    public static void main(String[] args) {
        DummyDic slovar = new DummyDic();
       String en = slovar.engToRus("test");
        System.out.println(en);
    }
}

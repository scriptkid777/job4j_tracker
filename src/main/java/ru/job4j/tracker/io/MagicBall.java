package ru.job4j.tracker.io;
import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer != 0 && answer != 1) {
            System.out.println("Может быть");
        } else if (answer == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}

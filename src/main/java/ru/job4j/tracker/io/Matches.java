package ru.job4j.tracker.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        int matches = -1;
        while (count > 0) {
            while (matches < 0 || matches > 3) {
                System.out.println("Количество спичек на столе:" + count);
                String player = turn ? "Первый игрок" : "Второй игрок";
                System.out.println(player + " введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
            }
            count -= matches;
            matches = -1;
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }

}

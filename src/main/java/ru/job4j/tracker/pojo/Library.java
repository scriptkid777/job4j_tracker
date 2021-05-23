package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean Code" ,475);
        Book book1 = new Book("Java in Action" , 1200);
        Book book2 = new Book("Java 8",1100);
        Book book3 = new Book("Start java", 875);

        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (Book lib:books) {
            System.out.println(lib.getBookname() + "-" + lib.getCountpage());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (Book lib:books) {
            System.out.println(lib.getBookname());
        }

        for (Book lib:books) {
            if (("Clean Code").equals(lib.getBookname())){
                System.out.println(lib.getCountpage());
            }
        }
    }
}

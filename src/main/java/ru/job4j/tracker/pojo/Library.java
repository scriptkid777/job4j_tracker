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
        for (int i = 0; i < books.length; i++) {
            Book st = books[i];
            System.out.println(st.getBookname() +"-"+st.getCountpage());
        }
        Book tmp= books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookname());
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookname().equals("Clean Code")){
                System.out.println(books[i].getCountpage());
            }
        }
    }
}

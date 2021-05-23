package ru.job4j.tracker.pojo;

public class Book {
    private String bookname;
    private int countpage;

    public Book(String bookname ,int countpage){
        this.bookname  = bookname;
        this.countpage = countpage;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        bookname = bookname;
    }

    public int getCountpage() {
        return countpage;
    }

    public void setCountpage(int countpage) {
        this.countpage = countpage;
    }
}

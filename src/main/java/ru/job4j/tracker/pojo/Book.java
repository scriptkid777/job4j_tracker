package ru.job4j.tracker.pojo;

public class Book {
    private String Bookname;
    private int countpage;

    public Book(String Bookname ,int countpage){
        this.Bookname  = Bookname;
        this.countpage = countpage;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public int getCountpage() {
        return countpage;
    }

    public void setCountpage(int countpage) {
        this.countpage = countpage;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist;

/**
 *
 * @author Phi
 */
public class Book {
    private String bookName;
    private String authorName;
    private String pulisher;
    private int year;

    public Book(String bookName, String authorName, String pulisher, int year) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pulisher = pulisher;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPulisher() {
        return pulisher;
    }

    public void setPulisher(String pulisher) {
        this.pulisher = pulisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("|%-25s|%-15s|%-10s|%-5d|", bookName, authorName, pulisher, year);
    }
    
    
}

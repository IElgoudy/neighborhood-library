package com.pluralsight;

public class Book {
    private int bookId;
    private String bookIsbn;
    private String bookTitle;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int bookId, String bookIsbn, String bookTitle) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.isCheckedOut = false;
        this.checkedOutTo = "";

    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isCheckedOut()
    {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut)
    {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo()
    {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo)
    {
        this.checkedOutTo = checkedOutTo;
    }


    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book Checked out to " + name + "!");
        } else {
            System.out.println("The Selected book is already checked out. Please try a different one or come back another time. Thank you.");
        }
    }


    public void checkIn()
    {
        if(isCheckedOut)
        {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Return process completed");
        }
        else
        {
            System.out.println("Book is currently available");
        }
    }
    public String toString()
    {
        return "Book{" +  "id=" + bookId + ", isbn='" + bookIsbn + '\'' +", title='" + bookTitle + '\'' +  ", isCheckedOut=" + isCheckedOut + ", checkedOutTo='" + checkedOutTo + '\'' +  '}';
    }
}

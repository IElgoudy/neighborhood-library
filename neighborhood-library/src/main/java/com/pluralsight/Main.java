package com.pluralsight;


import java.util.Scanner;
public class Main {
    static Scanner userInput = new Scanner(System.in);

public static void main(String [] args)
    {
        Book[] libraryBooks = {
        new Book(1, "10001", "The Kite Runner"),
        new Book(2, "10002", "The Alchemist"),
        new Book(3, "10003", "The Picture of Dorian Gray"),
        new Book(4, "10004", "Moby-Dick"),
        new Book(5, "10005", "The Hitchiker Guide to the Galaxy"),
        new Book(6, "10006", "Gone with the Wind"),
        new Book(7, "10007", "The Hunger Games"),
        new Book(8, "10008", "The Da Vinci Code"),
        new Book(9, "10009", "Animal Farm"),
        new Book(10, "10010", "The Lord of the Rings"),
        new Book(11, "10011", "Codex Leicester"),
        new Book(12, "10012", "Shakespeare's First Folio"),
        new Book(13, "10013", "The Gutenberg Bible"),
        new Book(14, "10014", "Birds of America"),
        new Book(15, "10015", "The Tales of Beedle the Bard"),
        new Book(16, "10016", "The Voynich Manuscript"),
        new Book(17, "10017", "The Canterbury Tales"),
        new Book(18, "10018", "The Hobbit"),
        new Book(19, "10019", "Ulysses"),
        new Book(20, "10020", "The Wealth of Nations")
        };

        int choice =0;
        while(choice != 3)
        {
            System.out.println();
            System.out.println("    *Neighborhood Library Portal*    ");
            System.out.println("    -----------------------------");
            System.out.println("1 - Available Books");
            System.out.println("2 - Checked Out Books");
            System.out.println("3 - Exit");
            System.out.println();
            System.out.println("Enter your command: ");
            choice = Integer.parseInt(userInput.nextLine());

            switch (choice)
             {
                case 1:
             showAvailableBooks(libraryBooks);
            System.out.println("-".repeat(155));
            System.out.println("1) Checkout Book");
            System.out.println("2) Return to Menu");
            int subChoice = Integer.parseInt(userInput.nextLine());
           switch (subChoice)
            {
            case 1:
            checkOutBook(libraryBooks);
                break;
            }

                break;
            case 2:
            showCheckedOutBooks(libraryBooks);
            System.out.println();
            System.out.println("(C) Check in Book");
            System.out.println("(X) Return to menu");
            String subInput = userInput.nextLine().strip().toUpperCase();
            switch (subInput) {
            case "C":
            checkInBook(libraryBooks);
                break;
            case "X":
                break;
            default:
            System.out.println("Invalid Choice");
                break;
            }
                break;

            case 3:
            System.out.println();
            System.out.println("See you next time!");
                    break;

            default:
            System.out.println();
            System.out.println("Input not recognized");
            }
            System.out.println();
            System.out.println("Hit Enter to proceed further.");
            userInput.nextLine();

        }
    }

public static void showAvailableBooks(Book[] libraryBooks)
        {
            System.out.println();
            System.out.println("Available Books");
            System.out.println("-".repeat(155));
            System.out.println("Book ID:                              Book ISBN:                           Book Title:                          is Checked Out:                  ");


        for (Book book : libraryBooks) {
            if (!book.isCheckedOut()) {
            System.out.printf("%-35d | %-35s | %-35s | %-35b | %-35s\n",book.getBookId(), book.getBookIsbn(), book.getBookTitle(), book.isCheckedOut(), book.getCheckedOutTo());
            }
        }

    }

public static void showCheckedOutBooks(Book[] libraryBooks) {
        System.out.println("Books Checked out");
        System.out.println("-".repeat(14));

        for (Book book : libraryBooks) {
            if (book.isCheckedOut()) {
                System.out.printf("%-30d | %-30s | %-30s | %-30b | %-30s\n", book.getBookId(), book.getBookIsbn(), book.getBookTitle(), book.isCheckedOut(), book.getCheckedOutTo());
            }
        }
    }


public static void checkOutBook(Book[] libraryBooks) {
        System.out.println("Enter Book ID:");
        int bookId = Integer.parseInt(userInput.nextLine());

        for(Book book : libraryBooks) {
            if(book.getBookId() == bookId) {
                if(!book.isCheckedOut()) {
                    System.out.println("Enter your name");
                    String name = userInput.nextLine();
                    book.checkOut(name);
                } else {
                    System.out.println("Book is already checked out");
                }
                return;
            }
        }

        System.out.println("Book not found");//when invalid input
    }


public static void checkInBook(Book[] libraryBooks)
    {
        System.out.println("\n Enter Book ID");
        int bookId = Integer.parseInt(userInput.nextLine());

        boolean bookFound = false;
        for(Book book : libraryBooks)
        {
            if (book.getBookId() == bookId && book.isCheckedOut())
            {
                book.checkIn();
                bookFound =true;
                break;
            }
        }
        if(!bookFound)
        {
            System.out.println("Book is not checked out");
        }
    }
}


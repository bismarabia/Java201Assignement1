package com.bisma;

import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book("The Raven", "Rabia");
        Book book3 = new Book("Untitled Book", "Bisma", 2, 36);

        book1.setName("Strange Book");
        book1.setAuthor("it's me");
        book1.setReserved_month(3);
        book1.setReservation_amount(35);

        book2.setReserved_month(9);
        book2.setReservation_amount(21);


        System.out.println("SHOW BOOKS IN BOOKSTORE");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        Book book4 = new Book();
        Scanner s = new Scanner(System.in);
        System.out.println("ADD A NEW BOOK");
        System.out.print("name of the book? ");
        book4.setName(s.next());
        System.out.print("\nAuthor? ");
        book4.setAuthor(s.next());
        System.out.print("\nReserved month? ");
        book4.setReserved_month(s.nextInt());
        System.out.print("\nReservation amount? ");
        book4.setReservation_amount(s.nextInt());

        Book[] books = {book1, book2, book3, book4};

        System.out.println("\nLIST OF FEES FOR EACH RESERVED BOOK");
        for (Book book : books)
            System.out.println("Book is: " + book.getName()
                    + "\nAuthor is: " + book.getAuthor()
                    + "\nReserved month is: " + book.getReserved_month()
                    + " --- Current month is: " + book.currentMonth
                    + " --- Fee is: " + book.getFee(book.currentMonth) + "\n");

        System.out.println("FIND THE POPULAR BOOK");
        for (int i=0; i<books.length-1; i++){
            books[i].findPopular(book4);
        }
    }
}




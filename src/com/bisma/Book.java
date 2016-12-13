package com.bisma;

public class Book {

    String name, author;
    int reserved_month, reservation_amount;
    final int currentMonth = 11;

    public Book() {
        this.name = "";
        this.author = "";
        this.reserved_month = 0;
        this.reservation_amount = 0;
    }
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.reserved_month = 0;
        this.reservation_amount = 0;
    }
    public Book(String name, String author, int reserved_month, int reservation_amount) {
        this.name = name;
        this.author = author;
        this.reserved_month = reserved_month;
        this.reservation_amount = reservation_amount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setReserved_month(int reserved_month) {
        this.reserved_month = reserved_month;
    }
    public void setReservation_amount(int reservation_amount) {
        this.reservation_amount = reservation_amount;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getReserved_month() {
        return reserved_month;
    }
    public int getReservation_amount() {
        return reservation_amount;
    }

    @Override
    public String toString() {
        return "Name: " + name  +
                "\nAuthor: " + author  +
                "\nReserved_month: " + reserved_month +
                "\nReservation_amount: " + reservation_amount +'\n';
    }

    public double getFee(int currentMonth){
        // anyone has the right to take a book for one month without paying any fees..
        if (currentMonth - this.reserved_month == 1)
            return 0;
        //otherwise
        return (currentMonth - this.reserved_month ) * 0.5;
    }

    public void findPopular(Book book){
        if (this.getReservation_amount() > book.getReservation_amount())
            System.out.println(this.getName() + " is more popular than " +
                                    book.getName());
        else if (this.getReservation_amount() < book.getReservation_amount())
            System.out.println(book.getName() + " is more popular than " +
                    this.getName());
        else
            System.out.println(this.getName() + " and " + book.getName() +
                    " are the same in terms of popularity");

    }
}

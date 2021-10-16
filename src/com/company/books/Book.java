package com.company.books;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        StringBuilder builderAuthors= new StringBuilder();
        for (int i =0; i< authors.length;i++) {
            if (i==authors.length-1) builderAuthors.append(authors[i].toString())   ;
            else
            builderAuthors.append(authors[i].toString()+", ");
        }
        return "Book [name = " + name +
                ", authors = {" + builderAuthors.toString() +
                "}, price = " + price +
                ", qty = " + qty;
    }
}

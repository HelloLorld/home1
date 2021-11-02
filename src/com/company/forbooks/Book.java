package com.company.forbooks;

import java.util.Arrays;

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
    public String getAuthorNames() {
        StringBuilder authors = new StringBuilder();
        for (Author author : this.authors) {
            authors.append(author.getName());
            authors.append(", ");
        }
        return authors.substring(0,authors.length()-2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (Double.compare(book.price, price) != 0) return false;
        if (qty != book.qty) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(authors);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + qty;
        return result;
    }
}

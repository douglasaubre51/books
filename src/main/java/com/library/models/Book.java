package com.library.models;

public class Book {
    public String name;
    public String author;
    public String price;

    @Override
    public String toString() {
        return "name:" + name + "\n" + "author:" + author + "\n" + "price:" + price;
    }
}

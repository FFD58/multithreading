package ru.fafurin.lesson3;

public class Product {
    private String title;
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + ". Price: " + price;
    }
}

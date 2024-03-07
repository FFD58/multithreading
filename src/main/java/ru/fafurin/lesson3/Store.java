package ru.fafurin.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final MockProductFactory factory;

    private final List<Product> products = new ArrayList<>();

    int maxProductCount;
    int productCount;

    public Store(MockProductFactory factory, int maxProductCount) {
        this.factory = factory;
        this.maxProductCount = maxProductCount;
    }

    public void put() {
        Product product = factory.createRandomProduct();
        products.add(product);
        productCount++;
        System.out.printf("%s added\n", product);
        System.out.printf("Product count: %s\n", productCount);
    }

    public void get() {
        Product product = products.get(0);
        products.remove(product);
        productCount--;
        System.out.printf("%s purchased\n", product);
        System.out.printf("Product count: %s\n", productCount);
    }
}

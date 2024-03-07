package ru.fafurin.lesson3;

import java.util.Random;

public class MockProductFactory {
    private final Random random = new Random();

    public Product createRandomProduct() {
        String[] titles = {"Rye bread", "Cheesecake", "Cookie", "Cake", "Wheat bread", "Croutons", "Rum cake"};
        int[] prices = {57, 178, 278, 98, 59, 77, 87};

        return new Product(titles[random.nextInt(titles.length)], prices[random.nextInt(titles.length)]);
    }
}

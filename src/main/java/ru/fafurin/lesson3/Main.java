package ru.fafurin.lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Store store = new Store(new MockProductFactory(), 10);
        Thread producer = new Producer(store);

        Thread consumer1 = new Consumer(store, 4000);
        Thread consumer2 = new Consumer(store, 2500);
        Thread consumer3 = new Consumer(store, 3000);

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().length() != 0) {
            producer.interrupt();
            consumer1.interrupt();
            consumer2.interrupt();
            consumer3.interrupt();
        }
    }
}

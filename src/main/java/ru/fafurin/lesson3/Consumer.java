package ru.fafurin.lesson3;

public class Consumer extends Thread {
    private final Store store;
    private int millis;

    public Consumer(Store store, int millis) {
        this.store = store;
        this.millis = millis;
    }

    @Override
    public synchronized void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(millis);
                if (store.productCount > 1) {
                    store.get();
                }
                notify();
            } catch (InterruptedException e) {
                System.out.println("Store closed!");
                break;
            }
        }
    }
}
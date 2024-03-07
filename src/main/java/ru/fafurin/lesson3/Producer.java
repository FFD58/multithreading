package ru.fafurin.lesson3;

public class Producer extends Thread {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public synchronized void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
                while (store.productCount == store.maxProductCount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                store.put();
            } catch (InterruptedException e) {
                System.out.println("Store closed!");
                break;
            }
        }
    }
}
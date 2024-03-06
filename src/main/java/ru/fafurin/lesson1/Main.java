package ru.fafurin.lesson1;

public class Main {
    public static void main(String[] args) {
        NewThread thread = new NewThread();
        thread.start();
        Thread thread1 = new Thread(getThread());
        thread1.start();
        Thread thread2 = new Thread(() -> {
            System.out.println("Another thread");
        });
        thread2.start();
    }

    private static Runnable getThread() {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("New thread");
                }
            }
        };
    }
}

class NewThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName());
        }
    }
}

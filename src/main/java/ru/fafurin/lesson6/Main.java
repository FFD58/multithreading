package ru.fafurin.lesson6;

public class Main {
    public static void main(String[] args) {
// 1. Создать класс расширяющий Thread
        // 1. Создать класс NewThread расширяющий Thread.
        // 2. Переопределить метод run(). В цикле for вывести на консоль символ 100 раз.
        // 3. Создать экземпляр класса и запустить новый поток.
        NewThread newThread = new NewThread();
        newThread.start();

// 2. Создать класс реализующий Runnable
        // 1. Создать класс, реализующий интерфейс Runnable.
        // 2. Переопределить run() метод. Создать цикл for. В цикле распечатываем значения от 0
        //    до 100 делящиеся на 10 без остатка.
        // 3. Используем статический метод Thread.sleep(), чтобы сделать паузу.
        // 4. Создать три потока, выполняющих задачу распечатки значений.

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runner());
            thread.start();
        }
   }

}
// 1
class NewThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Idiocy + " + i);
        }
    }
}

// 2
class Runner implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
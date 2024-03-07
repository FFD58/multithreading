package ru.fafurin.lesson4;
// Расскажите своими словами, что такое семафоры в контексте многопоточности в JAVA?


// Ответ. Семафор - класс, отвечающий за управление доступом к ресурсу, ограничивая количество одновременно запускаемых потоков.

import java.util.concurrent.Semaphore;

// Решение задачи про поезда из лекции
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Depot depot = new Depot();

        for (int i = 0; i < 20; i++) {
            TrainThread thread = new TrainThread(semaphore, depot, new Train());
            thread.start();
        }
    }
}


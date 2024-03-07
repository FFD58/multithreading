package ru.fafurin.lesson4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TrainThread extends Thread {

    private final Random random = new Random();
    private final Semaphore semaphore;
    private final Depot depot;
    private final Train train;

    int counter = 0;

    public TrainThread(Semaphore semaphore, Depot depot, Train train) {
        this.semaphore = semaphore;
        this.depot = depot;
        this.train = train;
    }

    @Override
    public void run() {
        try {
            while (counter < 2) {
                semaphore.acquire();
                trainSimulation();
                semaphore.release();
                counter++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void trainSimulation() {
        try {
            depot.addTrain(train);
            sleep(random.nextInt(1000, 4000));
            depot.removeTrain(train);
            sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
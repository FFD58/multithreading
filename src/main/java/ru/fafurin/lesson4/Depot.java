package ru.fafurin.lesson4;

import java.util.ArrayList;
import java.util.List;

class Depot {
    List<Train> trains = new ArrayList<>();
    public synchronized void addTrain(Train train) {
        trains.add(train);
        System.out.printf("%s arrived at the depot...\n", train.title);
    }
    public synchronized void removeTrain(Train train) {
        trains.remove(train);
        System.out.printf("%s left the depot...\n", train.title);
    }
}
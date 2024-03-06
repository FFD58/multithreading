package ru.fafurin.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new StopwatchThread(new Stopwatch()));
        thread.start();
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().length() != 0) thread.interrupt();
    }
}

class StopwatchThread implements Runnable {

    private final Stopwatch stopwatch;

    public StopwatchThread(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void run() {
        Stopwatch stopwatch = new Stopwatch();
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(1000);
                stopwatch.runTimer();
            }
        } catch (InterruptedException e) {
            System.out.println("Stopwatch stopped!");
        }
    }
}

class Stopwatch {
    int counter = 1;
    private final List<Integer> timer = new ArrayList<>();

    public Stopwatch() {
        timer.add(0, 0); // seconds
        timer.add(1, 0); // minutes
        timer.add(2, 0); // hours
    }

    public void runTimer() {
        timer.set(0, counter);
        addTimeUnit(0);
        addTimeUnit(1);
        printTimer();
        counter++;
    }

    private void addTimeUnit(int unit) {
        if (timer.get(unit) == 60) {
            timer.set(unit + 1, timer.get(unit + 1) + 1);
            timer.set(unit, 0);
            counter = 0;
        }
    }

    private void printTimer() {
        System.out.printf("%s:%s:%s\n",
                addZeroToDigitLess10(timer.get(2)),
                addZeroToDigitLess10(timer.get(1)),
                addZeroToDigitLess10(timer.get(0)));
    }

    private String addZeroToDigitLess10(int x) {
        if (x < 10) return "0" + x;
        return String.valueOf(x);
    }
}

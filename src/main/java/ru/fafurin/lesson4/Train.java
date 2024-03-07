package ru.fafurin.lesson4;

import java.util.Random;

public class Train {
    Random random = new Random();
    String title;

    public Train() {
        this.title = "The train " + random.nextInt(1, 200);
    }
}

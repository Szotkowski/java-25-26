package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Main0 {
    static void main() {
        AtomicInteger hodnota = new AtomicInteger(0);
        int opakovani = 1_000_000;

        Thread plus = new Thread(() -> {
            for (int i = 0; i < opakovani; i++) {
                hodnota.incrementAndGet();
            }
        });

        Thread minus = new Thread(() -> {
            for (int i = 0; i < opakovani; i++) {
                hodnota.decrementAndGet();
            }
        });

        plus.start();
        minus.start();

        try {
            plus.join();
            minus.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Konečná hodnota: " + hodnota.get());
    }
}

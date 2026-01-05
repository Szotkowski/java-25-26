package org.example;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    static void main() throws InterruptedException {

        int pocetCisel = 1_000_000;
        int pocetVlaken = 4;

        Random r = new Random();
        double[] cisla = new double[pocetCisel];

        for (int i = 0; i < pocetCisel; i++) {
            cisla[i] = r.nextDouble() * Math.PI;
        }

        ExecutorService executor = Executors.newFixedThreadPool(pocetVlaken);
        List<Future<VysledekVlakna>> vysledky = new ArrayList<>();

        int cast = pocetCisel / pocetVlaken;

        for (int i = 0; i < pocetVlaken; i++) {
            int start = i * cast;
            int end = (i == pocetVlaken - 1) ? pocetCisel : start + cast;

            Callable<VysledekVlakna> worker = () -> {
                long begin = System.currentTimeMillis();
                double sum = 0;

                for (int j = start; j < end; j++) {
                    sum += Math.tan(cisla[j]);
                }

                long endT = System.currentTimeMillis();
                return new VysledekVlakna(endT - begin, sum);
            };

            vysledky.add(executor.submit(worker));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        long nejpomalejsi = 0;
        double celkovySoucet = 0;

        System.out.println("Výsledky jednotlivých vláken:");
        for (Future<VysledekVlakna> f : vysledky) {
            VysledekVlakna v = null;
            try {
                v = f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            assert v != null;
            System.out.println("  čas: " + v.time + " ms, součet: " + v.soucet);

            if (v.time > nejpomalejsi) nejpomalejsi = v.time;
            celkovySoucet += v.soucet;
        }

        System.out.println("\nNejpomalejší vlákno: " + nejpomalejsi + " ms");
        System.out.println("Celkový součet: " + celkovySoucet);
    }
}

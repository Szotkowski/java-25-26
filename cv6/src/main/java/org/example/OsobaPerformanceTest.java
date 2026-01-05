package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OsobaPerformanceTest {
    private static final int POCET_INSTANCI = 100000;

    private static void runTest(String className, Class<? extends Osoba> clazz) {
        System.out.println("\n--- Test: " + className + " ---");
        Set<Osoba> set = new HashSet<>(POCET_INSTANCI);
        Osoba[] pole = new Osoba[POCET_INSTANCI];
        long startTime = System.nanoTime();
        try {
            for (int i = 0; i < POCET_INSTANCI; i++) {
                Osoba osoba = clazz.getDeclaredConstructor().newInstance();
                set.add(osoba);
                pole[i] = osoba;
            }
        } catch (Exception e) {
            System.err.println("Chyba při vytváření instancí pro test: " + e.getMessage());
            return;
        }
        long endTime = System.nanoTime();
        long generationTimeMs = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Vytvoření a vložení " + POCET_INSTANCI + " instancí: " + generationTimeMs + " ms");
        startTime = System.nanoTime();
        int pocetNalezenych = 0;
        for (Osoba osoba : pole) {
            if (set.contains(osoba)) {
                pocetNalezenych++;
            }
        }
        endTime = System.nanoTime();
        long containsTimeMs = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Testování set.contains() pro všechny prvky (" + pocetNalezenych + " nalezeno): " + containsTimeMs + " ms");
        startTime = System.nanoTime();
        int pocetOdstranenych = 0;
        for (int i = 0; i < POCET_INSTANCI; i += 10) {
            if (set.remove(pole[i])) {
                pocetOdstranenych++;
            }
        }
        endTime = System.nanoTime();
        long removeTimeMs = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Odstranění " + pocetOdstranenych + " instancí (každá 10. instance): " + removeTimeMs + " ms");
        System.out.println("Velikost Setu po odstranění: " + set.size());
    }

    public static void runAllTests() {
        runTest("PerfektniOsoba (Správný HashCode)", PerfektniOsoba.class);
        runTest("ExtraNevhodnaOsoba (Konstantní HashCode 5)", ExtraNevhodnaOsoba.class);
        runTest("NevhodnaOsoba (Náhodná proměnná v HashCode)", NevhodnaOsoba.class);
    }
}

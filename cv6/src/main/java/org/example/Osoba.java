package org.example;

import java.util.Random;

public class Osoba {
    private final String jmeno;
    private final boolean muz;
    private final int vyska;

    private static final Random RANDOM = new Random();

    public Osoba() {
        this.jmeno = generateRandomName();
        this.muz = RANDOM.nextBoolean();
        this.vyska = RANDOM.nextInt(51) + 150;
    }

    private String generateRandomName() {
        int length = RANDOM.nextInt(4) + 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + RANDOM.nextInt(26)));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "jmeno='" + jmeno + '\'' +
                ", muz=" + muz +
                ", vyska=" + vyska +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        if (vyska != osoba.vyska) return false;
        if (muz != osoba.muz) return false;
        return jmeno.equals(osoba.jmeno);
    }

    @Override
    public int hashCode() {
        int vysledek = 1;
        vysledek = 31 * vysledek + vyska;
        vysledek = 31 * vysledek + (muz ? 1 : 0);
        vysledek = 31 * vysledek + jmeno.hashCode();
        return vysledek;
    }
}

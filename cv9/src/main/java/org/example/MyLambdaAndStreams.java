package org.example;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MyLambdaAndStreams {
    public static class MinDiff3Predicate implements BiPredicate<Integer, Integer> {
        @Override
        public boolean test(Integer a, Integer b) {
            return Math.abs(a - b) >= 3;
        }
    }

    public static void convertSetToSetMinDiff(
            Set<Integer> inSet,
            Set<Integer> outSet,
            BiPredicate<Integer, Integer> predicate
    ) {
        for (Integer x : inSet) {
            boolean ok = true;
            for (Integer y : outSet) {
                if (!predicate.test(x, y)) {
                    ok = false;
                    break;
                }
            }
            if (ok) outSet.add(x);
        }
    }

    enum Pohlavi {
        MUZ,
        ZENA;

        public String getPohlavi() {
            return this == MUZ ? "Muž" : "Žena";
        }
    }

    static class Osoba {
        private final String jmeno;
        private final Pohlavi pohlavi;

        public Osoba(String jmeno, Pohlavi pohlavi) {
            this.jmeno = jmeno;
            this.pohlavi = pohlavi;
        }

        public Pohlavi getPohlaviEnum() {
            return pohlavi;
        }

        public String getPohlavi() {
            return pohlavi.getPohlavi();
        }

        @Override
        public String toString() {
            return jmeno + " (" + getPohlavi() + ")";
        }
    }

    public static Stream<Osoba> genRandomOsoby() {
        Random r = new Random();

        return Stream.generate(() -> {
            String name = String.valueOf(100000000 + r.nextInt(900000000));
            Pohlavi p = r.nextBoolean() ? Pohlavi.MUZ : Pohlavi.ZENA;
            return new Osoba(name, p);
        });
    }

    static void main() {
        Set<Integer> intSet1 = IntStream.rangeClosed(1, 30)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> outSet = new TreeSet<>();

        convertSetToSetMinDiff(intSet1, outSet, new MinDiff3Predicate());
        System.out.println("Výsledná množina outSet: " + outSet);

        Set<Integer> outSetLambda = new TreeSet<>();
        convertSetToSetMinDiff(intSet1, outSetLambda,
                (a, b) -> Math.abs(a - b) >= 3);
        System.out.println("Výsledná množina (lambda): " + outSetLambda);

        List<Osoba> osoby = genRandomOsoby()
                .limit(50)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("\nVygenerované osoby:");
        osoby.forEach(System.out::println);

        long pocetZen = osoby.stream()
                .map(Osoba::getPohlavi)
                .filter(p -> p.equals("Žena"))
                .count();
        System.out.println("\nPočet žen: " + pocetZen);
    }
}

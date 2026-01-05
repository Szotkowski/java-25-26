package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static SortedSet<Student> readStudents(File dir, String filename) throws IOException {
        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalArgumentException("Adresář neexistuje: " + dir);

        File file = new File(dir, filename);
        if (!file.exists())
            throw new IllegalArgumentException("Soubor neexistuje: " + file);

        SortedSet<Student> students = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], parts[1], parts[2]));
                }
            }
        }

        return Collections.unmodifiableSortedSet(students);
    }

    public static void readAllCourses(File dir, SortedMap<String, String> predmety,
                                      SortedMap<String, ArrayList<String>> studentiPredmety) throws IOException {

        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalArgumentException("Adresář neexistuje: " + dir);

        File[] files = dir.listFiles((_, name) -> name.startsWith("predmety_") && name.endsWith(".csv"));

        if (files == null) return;

        for (File f : files) {
            readStudentCourses(f, predmety, studentiPredmety);
        }
    }

    public static void readStudentCourses(File f,
                                          SortedMap<String, String> predmety,
                                          SortedMap<String, ArrayList<String>> studentiPredmety) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String uid = br.readLine();
            String delimiter = br.readLine();
            if (uid == null || delimiter == null) return;

            ArrayList<String> courses = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(delimiter);
                if (parts.length == 2) {
                    predmety.put(parts[0], parts[1]);
                    courses.add(parts[0]);
                }
            }
            studentiPredmety.put(uid, courses);
        }
    }

    static void main() {
        try {
            File dir = new File("src/CSV/");
            SortedSet<Student> studenti = readStudents(dir, "studenti.csv");
            SortedMap<String, String> predmety = new TreeMap<>();
            SortedMap<String, ArrayList<String>> studentiPredmety = new TreeMap<>();

            readAllCourses(dir, predmety, studentiPredmety);

            System.out.println("Studenti:");
            studenti.forEach(System.out::println);

            System.out.println("\nPředměty:");
            predmety.forEach((k, v) -> System.out.println(k + " - " + v));

            System.out.println("\nStudenti a jejich předměty:");
            studentiPredmety.forEach((uid, list) ->
                    System.out.println(uid + " -> " + list));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

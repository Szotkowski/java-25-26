package org.example;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    public static boolean isExistingReadableFile(File f) {
        if (f == null) {
            return true;
        }
        return !f.exists() || !f.isFile() || !f.canRead();
    }

    public static boolean saveCitizensToFile(File inputFile, File outputFile) {
        if (isExistingReadableFile(inputFile)) {
            return false;
        }

        List<Citizen> citizens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length == 5) {
                    try {
                        Citizen c = new Citizen(parts);
                        citizens.add(c);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Chyba při parsování řádku: " + line + ". Důvod: " + e.getMessage());
                    }
                } else {
                    System.err.println("Ignorován řádek s nesprávným počtem oddělených prvků: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení vstupního CSV souboru: " + e.getMessage());
            return false;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            for (Citizen c : citizens) {
                oos.writeObject(c);
            }
            return true;
        } catch (IOException e) {
            System.err.println("Chyba při zápisu do binárního souboru: " + e.getMessage());
            return false;
        }
    }

    public static void printCitizensFromFile(File f) {
        if (isExistingReadableFile(f)) {
            System.err.println("Chyba: Vstupní binární soubor " + f.getAbsolutePath() + " neexistuje nebo není čitelný.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj;
            int count = 0;
            System.out.println("--- Načítání Citizen objektů ze souboru: " + f.getName() + " ---");

            while (true) {
                try {
                    obj = ois.readObject();
                    if (obj instanceof Citizen) {
                        System.out.println("Objekt " + (++count) + ": " + obj);
                    } else {
                        System.err.println("Varování: Načten neočekávaný typ objektu: " + obj.getClass().getName());
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("--- Načteno celkem " + count + " Citizen objektů. ---");

        } catch (ClassNotFoundException e) {
            System.err.println("Chyba: Třída Citizen nebyla nalezena při deserializaci: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Chyba I/O při čtení binárního souboru: " + e.getMessage());
        }
    }
}

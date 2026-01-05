package org.example;

import java.io.File;

public class Main {
    static void main() {
        File inputFile = new File("adresy.csv");
        File outputFile = new File("občane.bin");

        boolean success = FileOperations.saveCitizensToFile(inputFile, outputFile);

        if (success) {
            FileOperations.printCitizensFromFile(outputFile);
        }
    }
}

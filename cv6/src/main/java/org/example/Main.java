package org.example;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;

public class Main {
    public static String askForText(String message) {
        return JOptionPane.showInputDialog(null, message, "Zadejte text", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showMessageResult(long size) {
        JOptionPane.showMessageDialog(null,
                "Celková velikost souborů: " + size + " bajtů.",
                "Výsledek",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static File chooseDirectory() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Vyberte složku");
        File selectedDir = null;
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedDir = chooser.getSelectedFile();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Musíte vybrat složku, jinak nelze pokračovat.",
                    "Výběr složky",
                    JOptionPane.WARNING_MESSAGE);
        }
        return selectedDir;
    }

    static void main(String[] args) {
        String extension = askForText("Zadejte příponu souboru (např. 'pdf'):");
        if (extension == null || extension.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Přípona nebyla zadána. Konec programu.", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File directory = chooseDirectory();
        if (directory == null) {
            return;
        }
        long totalSize = 0;
        try {
            totalSize = FileOperations.getTotalSizeOfFilesByExtension(directory, extension);
            showMessageResult(totalSize);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Chyba: " + e.getMessage(), "Chyba volání metody", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("\nSpouštění testu pro třídu Osoba...");
        testOsobaPerformance();

        System.out.println("\nSpouštění testu výkonu pro třídy Osoba...");
        OsobaPerformanceTest.runAllTests();
    }

    private static void testOsobaPerformance() {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.println("Čas pro testování třídy Osoba: " + (endTime - startTime) + " ms");
        System.out.println("(Poznámka: Implementace testu chybí, kód jen pro ukázku volání)");
    }
}

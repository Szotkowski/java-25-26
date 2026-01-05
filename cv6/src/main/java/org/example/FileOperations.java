package org.example;

import java.io.File;
import java.io.FileFilter;

public class FileOperations {
    public static long getTotalSizeOfFilesByExtension(File dir, String ext) throws IllegalArgumentException {
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Neplatný nebo neexistující adresář.");
        }
        if (ext == null || ext.trim().isEmpty()) {
            throw new IllegalArgumentException("Přípona nemůže být null nebo prázdná.");
        }
        long totalSize = 0;
        final String fileExtension = "." + ext.toLowerCase();
        FileFilter filter = file -> {
            if (file.isDirectory()) {
                return true;
            }
            return file.getName().toLowerCase().endsWith(fileExtension);
        };
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    try {
                        totalSize += getTotalSizeOfFilesByExtension(file, ext);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Chyba při rekurzi: " + e.getMessage());
                    }
                } else {
                    totalSize += file.length();
                }
            }
        }
        return totalSize;
    }
}

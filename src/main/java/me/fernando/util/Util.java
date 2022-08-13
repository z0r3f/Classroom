package me.fernando.util;

import me.fernando.util.file.UtilFile;

public class Util {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Util <file>");
            System.exit(0);
        }
        String fileName = args[0];
        System.out.println("Reading file: " + fileName);
        try {
            int countCharacters = UtilFile.countCharacters(fileName);
            System.out.println("File with: " + countCharacters + " characters");

            int countLines = UtilFile.countLines(fileName);
            System.out.println("File with: " + countLines + " lines");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

package me.fernando.util.file;

public class UtilFile {
    public static int countLines(String fileName) {
        int lines = 0;
        try {
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            while (bufferedReader.readLine() != null) {
                lines++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static int countCharacters(String fileName) {
        int characters = 0;
        try {
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                characters += line.length();
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characters;
    }
}

package FileHandlers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    public static void writeLines(String filename, List<String> lines) {
        createFileIfNotExists(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filename + " -> " + e.getMessage());
        }
    }

    public static void appendLine(String filename, String line) {
        createFileIfNotExists(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error appending to file: " + filename + " -> " + e.getMessage());
        }
    }

    public static ArrayList<String> readLines(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        createFileIfNotExists(filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename + " -> " + e.getMessage());
        }

        return lines;
    }

    public static List<String[]> readCSV(String filename) {
        List<String> raw = readLines(filename);
        List<String[]> table = new ArrayList<>();

        for (String line : raw) {
            table.add(line.split(",")); // simple CSV parsing
        }
        return table;
    }

    public static void createFileIfNotExists(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + filename + " -> " + e.getMessage());
        }
    }
}

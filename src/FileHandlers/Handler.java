package FileHandlers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    /**
     * write line to a cvs file
     * @param filename the file name
     * @param lines lines that need to be writen to file
     */
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

    /**
     * adding lines to open cvs file
     * @param filename the file name
     * @param line the line that need to be added at the end of file
     */
    public static void appendLine(String filename, String line) {
        createFileIfNotExists(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error appending to file: " + filename + " -> " + e.getMessage());
        }
    }

    /**
     * read the file and returns it as list
     * @param filename the file name
     * @return list of stings to be added to class
     */
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

    /**
     * reads the lines from cvs file
     * @param filename the file name
     * @return returns a table of information to be turned into model pattern
     */
    public static List<String[]> readCSV(String filename) {
        List<String> raw = readLines(filename);
        List<String[]> table = new ArrayList<>();

        for (String line : raw) {
            table.add(line.split(",")); // simple CSV parsing
        }
        return table;
    }

    /**
     * Error handling for if file doesn't exist
     * @param filename the file it's trying to open
     */
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

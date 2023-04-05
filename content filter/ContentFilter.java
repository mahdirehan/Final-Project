import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContentFilter {
    
    public static void main(String[] args) {
        // Example usage:
        List<File> entries = new ArrayList<>();
        entries.add(new File("File1.txt"));
        entries.add(new File("File2.txt"));
        String key = "key";
        List<File> output = filterEntries(entries, key);
        for (File file : output) {
            System.out.println("List of emtries where key is present : " + file.getName());
        }
    }
    
    public static List<File> filterEntries(List<File> entries, String key) {
        List<File> output = new ArrayList<>();
        for (File entry : entries) {
            if (entry.isFile() && containsKey(entry, key)) {
                output.add(entry);
            }
        }
        return output;
    }
    
    public static boolean containsKey(File file, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(key)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + file.getAbsolutePath() + ": " + e.getMessage());
        }
        return false;
    }
}

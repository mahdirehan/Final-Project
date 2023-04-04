import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContentFilter {
    public static void main(String[] args) {
        // Set up a list of files to filter
        List<File> entries = new ArrayList<>();
        // add entries to the list
        entries.add(new File("/Users/macgb/Downloads/engg 1420 final project/filters/count filter/file1.txt"));
        // Set up the key to filter by
        String key = "hello";
        // Call the filter method to get the filtered list of files
        List<File> filteredEntries = filter(entries, key);
        // Print out the filtered list of files
        System.out.println("Filtered entries: " + filteredEntries);
    }


    /**
     * Filters a list of files based on whether they contain a given key.
     *
     * @param entries the list of files to filter
     * @param key the key to filter by
     * @return a list of files that contain the key
     */
    public static List<File> filter(List<File> entries, String key) {
        List<File> filteredEntries = new ArrayList<>();
        for (File entry : entries) {
            if (entry.isFile() && containsKey(entry, key)) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }

    /**
     * Checks whether a given file's content contains a given key.
     *
     * @param file the file to check
     * @param key the key to look for in the file's content
     * @return true if the file's content contains the key, false otherwise
     */
    private static boolean containsKey(File file, String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(key)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

/*
 * 
 */
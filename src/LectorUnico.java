import java.io.*;
import java.util.HashSet;

public class Lector {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        String line;

        // Create a HashSet to store the unique strings
        HashSet<String> uniqueStrings = new HashSet<>();

        while ((line = reader.readLine()) != null) {
            String string = "https";
            int startIndex = line.indexOf(string);
            while (startIndex >= 0) {
                int endIndex = line.indexOf(" ", startIndex);
                if (endIndex < 0) {
                    endIndex = line.length();
                }
                String link = line.substring(startIndex, endIndex);
                // Check if the link is not already in the HashSet
                if (!uniqueStrings.contains(link)) {
                    // Add the link to the HashSet
                    uniqueStrings.add(link);
                    // Write the link to the output file
                    writer.write(link);
                    writer.newLine();
                }
                startIndex = line.indexOf(string, endIndex);
            }
        }
        reader.close();
        writer.close();
    }
}

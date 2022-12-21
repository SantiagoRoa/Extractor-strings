import java.io.*;
public class Lector {
    public static void main(String[] args) throws IOException {
        // Definir las rutas de los archivos input y output
        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";
        // Abrir archivos input y output
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        // Leer el archivo input linea por linea
        String line;
        while ((line = reader.readLine()) != null) {
            String string = "https";
            // Extraer la cadena de texto que contenga el string indicado
            int startIndex = line.indexOf(string);
            while (startIndex >= 0) {
                int endIndex = line.indexOf(" ", startIndex);
                if (endIndex < 0) {
                    endIndex = line.length();
                }
                String link = line.substring(startIndex, endIndex);
                // Escribir la cadena extraida en el archivo output
                writer.write(link);
                writer.newLine();
                startIndex = line.indexOf(string, endIndex);
            }
        }
        // Close the input and output files
        reader.close();
        writer.close();
    }
}


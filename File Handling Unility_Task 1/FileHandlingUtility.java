import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static String fileName = "sample.txt";

    // Write data to file
    public static void writeFile(String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read data from file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Modify (append) data to file
    public static void modifyFile(String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + content);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== File Handling Utility ===");

        System.out.print("Enter text to write into file: ");
        String writeData = scanner.nextLine();
        writeFile(writeData);

        readFile();

        System.out.print("\nEnter text to append into file: ");
        String modifyData = scanner.nextLine();
        modifyFile(modifyData);

        readFile();

        scanner.close();
    }
}

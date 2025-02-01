import java.io.*;

public class FileOperations {

    // Method to write text to a file
    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Content written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Content of the file " + fileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to modify text in a file (append to the file)
    public static void modifyFile(String fileName, String additionalContent) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // 'true' enables appending
            writer.write("\n" + additionalContent);
            System.out.println("Content added to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt";

        // Write to file
        String content = "Hello, this is the initial content of the file!";
        writeToFile(fileName, content);

        // Read from file
        readFromFile(fileName);

      
        // Modify the file (append more content)
        String newContent = "This is the additional content that we are appending.";
        modifyFile(fileName, newContent);

        // Read from file after modification
        readFromFile(fileName);
    }
}





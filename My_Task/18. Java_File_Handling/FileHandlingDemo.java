import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {

    public static void main(String[] args) {
        // Define the folder and file names
        String folderName = "MyDataFolder";
        String fileName = folderName + "/myData.txt";

        System.out.println("===== Java File Handling Demonstration =====\n");

        // ---------------------------------------------------------
        // 1. CREATE FOLDER (using mkdir())
        // ---------------------------------------------------------
        File folder = new File(folderName);
        if (folder.mkdir()) {
            System.out.println("SUCCESS: Folder created -> " + folderName);
        } else {
            System.out.println("INFO: Folder already exists or could not be created.");
        }

        // ---------------------------------------------------------
        // 2. CREATE FILE (using createNewFile())
        // ---------------------------------------------------------
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("SUCCESS: File created -> " + fileName);
            } else {
                System.out.println("INFO: File already exists.");
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not create file. " + e.getMessage());
        }

        // ---------------------------------------------------------
        // 3. WRITE DATA TO FILE (using FileWriter and write())
        // ---------------------------------------------------------
        // Using try-with-resources to automatically close the writer
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Welcome to Java File Handling!\n");
            writer.write("This is a sample text written into the file.\n");
            writer.write("File operations are successful.");
            System.out.println("SUCCESS: Data written to file.");
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file. " + e.getMessage());
        }

        // ---------------------------------------------------------
        // 4. READ DATA FROM FILE (using Scanner and hasNextLine())
        // ---------------------------------------------------------
        System.out.println("\n----- Reading File Content -----");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("> " + data);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file. " + e.getMessage());
        }

        // ---------------------------------------------------------
        // 5. DELETE FILE (using delete())
        // ---------------------------------------------------------
        // NOTE: Uncomment the block below ONLY if you want to permanently delete the file.
        /*
        System.out.println("\n----- Deleting File -----");
        if (file.delete()) {
            System.out.println("SUCCESS: File deleted successfully.");
        } else {
            System.out.println("ERROR: Failed to delete the file.");
        }
        */
        
        System.out.println("\n===== Demonstration Complete =====");
    }
}
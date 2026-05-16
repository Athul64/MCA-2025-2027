import java.io.*;
import java.util.Scanner;

public class FileHandlingComplete {

    static final String FILENAME = "data.txt";

    static void writeToFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nHow many lines to write? ");
        int n = sc.nextInt();
        sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            System.out.println("Enter " + n + " lines:");
            for (int i = 1; i <= n; i++) {
                System.out.print("  Line " + i + ": ");
                String line = sc.nextLine();
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            System.out.println("File written successfully: " + FILENAME);

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }
    }

    static void readFromFile() {
        System.out.println("\nContents of '" + FILENAME + "':");
        System.out.println("=".repeat(40));

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String line;
            int    count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + (++count) + ": " + line);
            }
            System.out.println("=".repeat(40));
            System.out.println("Total lines: " + count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILENAME);
            System.out.println("Please write to the file first (Option 1).");
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }

    static void appendToFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to append: ");
        String text = sc.nextLine();

        // FileWriter(filename, true) = APPEND mode
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write(text);
            bw.newLine();
            bw.flush();
            System.out.println("Appended successfully.");
        } catch (IOException e) {
            System.out.println("Append Error: " + e.getMessage());
        }
    }

    static void displayFileInfo() {
        File f = new File(FILENAME);
        System.out.println("\nFile Information:");
        System.out.println("  Name          : " + f.getName());
        System.out.println("  Absolute Path : " + f.getAbsolutePath());
        System.out.println("  Exists        : " + f.exists());
        System.out.println("  Size          : " + f.length() + " bytes");
        System.out.println("  Can Read      : " + f.canRead());
        System.out.println("  Can Write     : " + f.canWrite());
        System.out.println("  Is File       : " + f.isFile());
        System.out.println("  Is Directory  : " + f.isDirectory());
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("====== Java File Handling ======");

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Append to file");
            System.out.println("4. File information");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: writeToFile();     break;
                case 2: readFromFile();    break;
                case 3: appendToFile();    break;
                case 4: displayFileInfo(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

import java.util.Scanner;

public class SortLanguages {

    // Bubble Sort using compareTo() for String comparison
    static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap
                    String temp = arr[j];
                    arr[j]      = arr[j + 1];
                    arr[j + 1]  = temp;
                }
            }
        }
    }

    // Display array elements
    static void display(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  " + (i + 1) + ". " + arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many programming languages? ");
        int n = sc.nextInt();
        sc.nextLine(); // flush newline

        String[] languages = new String[n];

        System.out.println("Enter the language names:");
        for (int i = 0; i < n; i++) {
            System.out.print("  Language " + (i + 1) + ": ");
            languages[i] = sc.nextLine();
        }

        System.out.println("\nBefore Sorting:");
        display(languages);

        bubbleSort(languages);

        System.out.println("\nAfter Sorting (Alphabetical Order):");
        display(languages);

        sc.close();
    }
}

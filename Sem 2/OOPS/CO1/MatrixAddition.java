import java.util.Scanner;

public class MatrixAddition {

    // Read a matrix from user input
    static int[][] readMatrix(Scanner sc, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of " + name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("  [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Add two matrices element-wise
    static int[][] addMatrices(int[][] a, int[][] b, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Display a matrix in formatted form
    static void displayMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows    : ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns : ");
        int cols = sc.nextInt();

        int[][] matA   = readMatrix(sc, rows, cols, "Matrix A");
        int[][] matB   = readMatrix(sc, rows, cols, "Matrix B");
        int[][] result = addMatrices(matA, matB, rows, cols);

        System.out.println("\nMatrix A:");
        displayMatrix(matA, rows, cols);

        System.out.println("\nMatrix B:");
        displayMatrix(matB, rows, cols);

        System.out.println("\nResultant Matrix (A + B):");
        displayMatrix(result, rows, cols);

        sc.close();
    }
}

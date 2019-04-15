package multiplymatrix;

import java.util.Random;

import static multiplymatrix.MatrixMultiplier.multiplyMatrix;

public class Main {

    private final static int firstMatrixRows = 4;
    private final static int firstMatrixColumns = 4;
    private final static int secondMatrixRows = 4;
    private final static int secondMatrixColumns = 4;

    public static void main(String[] args) {
        final int[][] firstMatrix = new int[firstMatrixRows][firstMatrixColumns];
        final int[][] secondMatrix = new int[secondMatrixRows][secondMatrixColumns];

        randomizeMatrix(firstMatrix);
        randomizeMatrix(secondMatrix);

        final int[][] resultMatrix = multiplyMatrix(firstMatrix, secondMatrix, Runtime.getRuntime().availableProcessors());

        System.out.println("First Matrix:");
        printMatrix(firstMatrix);
        System.out.println("Second Matrix:");
        printMatrix(secondMatrix);
        System.out.println("Result Matrix:");
        printMatrix(resultMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix[0].length; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static void randomizeMatrix(int[][] matrix) {
        final Random randomize = new Random();
        for (int row = 0; row < matrix.length; ++row) {
            for (int column = 0; column < matrix[row].length; ++column) {
                matrix[row][column] = randomize.nextInt(200);
            }
        }
    }
}

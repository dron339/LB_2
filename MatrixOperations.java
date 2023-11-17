package org.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Константи для діапазону рандомних чисел
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println("1. Введення з клавіатури");
        System.out.println("2. Рандомне заповнення");

        int choice = scanner.nextInt();

        int[][] matrix;

        if (choice == 1) {
            matrix = createMatrixFromInput(scanner);
        } else if (choice == 2) {
            matrix = createRandomMatrix(scanner);
        } else {
            System.out.println("Некоректний вибір. Завершення програми.");
            return;
        }

        System.out.println("Отримана матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricMean);
    }

    private static int[][] createMatrixFromInput(Scanner scanner) {
        System.out.println("Введіть кількість рядків матриці (не більше 20):");
        int rows = scanner.nextInt();

        System.out.println("Введіть кількість стовпців матриці (не більше 20):");
        int cols = scanner.nextInt();

        return inputMatrixElements(scanner, rows, cols);
    }

    private static int[][] createRandomMatrix(Scanner scanner) {
        System.out.println("Введіть кількість рядків матриці (не більше 20):");
        int rows = scanner.nextInt();

        System.out.println("Введіть кількість стовпців матриці (не більше 20):");
        int cols = scanner.nextInt();

        return generateRandomMatrix(rows, cols);
    }

    private static int[][] inputMatrixElements(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }

        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }

        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        int product = 1;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                product *= value;
                count++;
            }
        }

        return Math.pow(product, 1.0 / count);
    }
}

package shell2;

import java.util.Random;

public class Main {
    private final static int arrLength = 15;
    static int[] arr = new int[arrLength];

    public static void main(String[] args) {
        randomizeArr(arr);
        System.out.println("Изначальный порядок: ");
        printArr(arr);

        ShellSorter shellSorter = new ShellSorter();
        shellSorter.shellsort(arr);

        System.out.println("Новый порядок: ");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; arr.length > i; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void randomizeArr(int[] arr) {
        final Random randomize = new Random();
        for (int i = 0; arr.length > i; i++) {
            arr[i] = randomize.nextInt(200);
        }
    }
}

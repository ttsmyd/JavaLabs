import java.util.Random;

public class Main {
    static int[][] matA = {
            {342, 432, 587},
            {420, 32, 824},
            {34, 91, 43},
    };

    static int[][] matB = {
            {234, 426, 314},
            {421, 355, 883},
            {523, 142, 234},
    };


    static int lengthOfX = 3, lengthOfY = 3;

    static int[][] result = new int[lengthOfX][lengthOfY];

    public static void main(String[] args) {

        FirstThread thread1 = new FirstThread();
        thread1.start();
        SecondThread thread2 = new SecondThread();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; lengthOfX > i; i++) {
            for (int j = 0; lengthOfY > j; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class FirstThread extends Thread {
        public void run() {
            for (int i = 0; lengthOfX / 2 > i; i++) {
                for (int j = 0; lengthOfY > j; j++) {
                    for (int x = 0; lengthOfY > x; x++) {
                        result[i][j] += matA[i][x] * matB[x][j];
                    }
                }
            }
        }
    }

    public static class SecondThread extends Thread {
        public void run() {
            for (int i = lengthOfX / 2; lengthOfX > i; i++) {
                for (int j = 0; lengthOfY > j; j++) {
                    for (int x = 0; lengthOfY > x; x++) {
                        result[i][j] += matA[i][x] * matB[x][j];
                    }
                }
            }
        }
    }




}
package multiplymatrix;

public class MatrixMultiplier {
    public static int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix, int countOfThreads) {
        assert countOfThreads < 0;

        final int finalRowLength = firstMatrix.length;
        final int finalColumnLength = secondMatrix[0].length;
        final int[][] resultMatrix = new int[finalRowLength][finalColumnLength];

        final int cellsForThread = (finalRowLength + finalColumnLength) / countOfThreads;
        int firstCellIndex = 0;
        final ThreadForMultiply[] threadForMultiplies = new ThreadForMultiply[countOfThreads];


        for (int threadIndex = countOfThreads - 1; threadIndex >= 0; --threadIndex) {
            int lastCellIndex = firstCellIndex + cellsForThread;
            if (threadIndex == 0) {
                lastCellIndex = finalRowLength * finalColumnLength;
            }
            threadForMultiplies[threadIndex] = new ThreadForMultiply(firstMatrix, secondMatrix, resultMatrix, firstCellIndex, lastCellIndex);
            threadForMultiplies[threadIndex].start();
            firstCellIndex = lastCellIndex;
        }

        try {
            for (final ThreadForMultiply threadForMultiply : threadForMultiplies)
                threadForMultiply.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }
}

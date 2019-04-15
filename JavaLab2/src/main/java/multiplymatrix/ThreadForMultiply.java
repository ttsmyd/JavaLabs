package multiplymatrix;

class ThreadForMultiply extends Thread {
    private final int[][] firstMatrix;
    private final int[][] secondMatrix;
    private final int[][] resultMatrix;
    private final int firstIndex;
    private final int lastIndex;
    private final int sumLength;

    public ThreadForMultiply(final int[][] firstMatrix,
                             final int[][] secondMatrix,
                             final int[][] resultMatrix,
                             final int firstIndex,
                             final int lastIndex) {
        this.firstMatrix  = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.firstIndex   = firstIndex;
        this.lastIndex    = lastIndex;

        sumLength = secondMatrix.length;
    }

    @Override
    public void run() {
        System.out.println("Thread runs and count matrix");
        final int colCount = secondMatrix[0].length;
        for (int index = firstIndex; index < lastIndex; ++index) {
            calculateValue(index / colCount, index % colCount);
        }
        System.out.println("Thread finished.");
    }

    private void calculateValue(final int row, final int col) {
        int sum = 0;
        for (int i = 0; i < sumLength; ++i) {
            sum += firstMatrix[row][i] * secondMatrix[i][col];
        }
        resultMatrix[row][col] = sum;
//        System.out.println(resultMatrix[row][col]);
    }
}

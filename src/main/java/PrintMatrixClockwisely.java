public class PrintMatrixClockwisely {

    public static void main(String[] args) {
        int arr[][] = {
                {3, 5, 2, 3, 6},
                {4, 7, 9, 5, 2},
                {4, 8, 5, 6, 3},
                {0, 4, 1, 6, 2}
        };
        int start = 0;
        printMatrixClockwisely(arr,start);
    }

    /**
     * 顺时针打印矩阵
     * @param arr
     * @param start
     */
    private static void printMatrixClockwisely(int[][] arr, int start) {

        start++;
    }
}

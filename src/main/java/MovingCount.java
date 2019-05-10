public class MovingCount {
    public static void main(String args[]) {
        int k = 8;
        int rows = 3, cols = 5;
        movingCount(k, rows, cols);
    }

    private static int movingCount(int k, int rows, int cols) {
        if (k < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(k, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (getDigitSum(rows) + getDigitSum(cols) <= k))
            visited[row * cols + col] = true;
        count = 1 + movingCountCore(k, rows, cols, row - 1, col, visited)
                + movingCountCore(k, rows, cols, row + 1, col, visited)
                + movingCountCore(k, rows, cols, row, col + 1, visited)
                + movingCountCore(k, rows, cols, row, col - 1, visited);
        return count;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

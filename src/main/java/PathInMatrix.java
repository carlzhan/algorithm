public class PathInMatrix {
    public static void main(String args[]) {
        char[] matrix = new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = new char[]{'A', 'B', 'C', 'C', 'E', 'D'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int clos, char[] str) {
        if (matrix == null || str == null || matrix.length < 1 || matrix.length < str.length) {
            return false;
        }
        boolean[] visited = new boolean[rows * clos];
        int curLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                return coreHasPath(matrix, rows, clos, i, j, str, visited, curLength);
            }
        }
        return false;
    }

    private static boolean coreHasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int curLength) {
        if (curLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[curLength]) {
            curLength++;
            visited[row * cols + col] = true;
            hasPath = coreHasPath(matrix, rows, cols, row - 1, col, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row + 1, col, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row, col - 1, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row, col + 1, str, visited, curLength);
            if (!hasPath) {
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }
}
